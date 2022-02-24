package com.Ezz.Game.Engine;

import android.annotation.NonNull;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout.LayoutParams;
import com.Ezz.Game.Engine.graphic.Entity;
import com.Ezz.Game.Engine.math.Vector2;
import com.Ezz.Game.Engine.util.Color;
import com.Ezz.Game.Engine.util.ScreenListener;
import java.util.ArrayList;
import java.util.Date;
import com.Ezz.Game.Engine.file.onFilePickedListener;

abstract public class Universe{

	private Engine engine;
	private float deltaTime;
	private ActionBar ActionBar = new ActionBar();
	private Context context;
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	private ArrayList<Entity> UIentities = new ArrayList<Entity>();
	public Input Input = new Input();
	public Camera Camera = new Camera();
	private ScreenListener screenListener;
	private Vector2 gravity = new Vector2(1, 1);
	ArrayList<onFilePickedListener> filePickListeners = new ArrayList<onFilePickedListener>();
	
	void initializeUniverse(@NonNull Context context){
		this.context = context;
		((Activity) context).getActionBar().hide();
		engine = new Engine(context);
		screenListener = new ScreenListener(){
			@Override
			public void onClick() {
			}
			@Override
			public void onTouch() {
			}
			@Override
			public void onTouchMove() {
			}
		};
		start();
	}
	
	public Context getContext(){
		return context;
	}
	
	public ActionBar getActionBar(){
		return ActionBar;
	}
	
	public AssetManager getAssets(){
		return context.getAssets();
	}
	
	public Resources getResources(){
		return context.getResources();
	}
	
	Engine getEngine(){
		return engine;
	}
	
	public void setScreenListener(@NonNull ScreenListener screenListener){
		this.screenListener = screenListener;
	}
	
	public ScreenListener getScreenListener(){
		return screenListener;
	}
	
	public void addOnFilePickedListener(onFilePickedListener ofpl){
		filePickListeners.add(ofpl);
	}
	
	public Vector2 getGravity(){
		return gravity;
	}
	
	public float getDeltaTime(){
		return deltaTime;
	}
	
	public abstract void start();
	public abstract void update();
	
	public void startUniverse(@NonNull Universe universe){
		((EzzActivity) context).startUniverse(universe);
	}
	
	public void setContentView(View view, LayoutParams params){
		((Activity) context).setContentView(view, params);
	}
	
	public void setContentView(int layoutResId){
		((Activity) context).setContentView(layoutResId);
	}
	
	public void setContentView(View view){
		((Activity) context).setContentView(view);
	}

	public void startActivity(Intent intent){
		((Activity) context).startActivity(intent);
	}

	class Engine extends View implements OnTouchListener {

		private Entity lastTouchedEntity;
		private float lastTime;

		Engine(Context context){
			super(context);
			Camera.size.set(getWidth(), getHeight());
			setOnTouchListener(this);
			lastTime = new Date().getTime();
		}
		
		public Universe getUniverse(){
			return Universe.this;
		}
		
		@Override
		public boolean onTouch(View p1, MotionEvent p2) {
			Input.action = p2.getAction();
			Input.me = p2;
			Input.position.set(p2.getX(), getHeight() - p2.getY());
			switch(p2.getAction()){
				case p2.ACTION_UP:
					screenListener.onClick();
				break;
				case p2.ACTION_MOVE:
					screenListener.onTouchMove();
				break;
				default:
					screenListener.onTouch();
				break;
			}
			for(final Entity e: entities){
				if(e.getPosition().x < Input.getPosition().x && Input.getPosition().x < e.getPosition().x + e.getSize().x && e.getPosition().y < Input.getPosition().y && Input.getPosition().y < e.getPosition().y + e.getSize().y){
					lastTouchedEntity = e;
					switch(p2.getAction()){
						case MotionEvent.ACTION_UP:
							e.onClick();
							e.getScreenListener().onClick();
						break;
						default:
							e.onTouch();
							e.getScreenListener().onTouch();
							break;
					}
				}else if(e == lastTouchedEntity){
					lastTouchedEntity = null;
					e.onTouchMove();
					e.getScreenListener().onTouchMove();
				}
			}
			return true;
		}
		@Override
		protected void onDraw(Canvas canvas) {
			super.onDraw(canvas);
			for(Entity e: entities){
				if(e.isUI()) UIentities.add(e);
				else if(UIentities.contains(e)) UIentities.remove(e);
			}
			for(Entity e: entities){
				if(e.getRigidBody() != null) e.getRigidBody().act(e);
				for(Script script: e.getScripts()){
					script.update();
				}
				e.rotate(e.angular);
				if(!e.isUI()){
					canvas.save();
					canvas.rotate(e.getRotation(), e.getRenderX() + e.getSize().x/2, e.getRenderY() + e.getSize().y/2);
					e.draw(canvas);
					canvas.restore();
				}
			}
			for(Entity e: UIentities){
				for(Script script: e.getScripts()){
					script.update();
				}
				e.rotate(e.angular);
				canvas.save();
				canvas.rotate(e.getRotation(), e.getRenderX(), e.getRenderY() + e.getSize().y);
				e.draw(canvas);
				canvas.restore();
			}
			ActionBar.draw(canvas);
			if(Camera.follow != null)
				Camera.getPosition().set(Camera.follow.getPosition());
			update();
			float t = lastTime - new Date().getTime();
			deltaTime = lastTime - t;
			lastTime = t;
			invalidate();
		}

		@Override
		protected void onSizeChanged(int w, int h, int oldw, int oldh) {
			super.onSizeChanged(w, h, oldw, oldh);
			Camera.size.set(w, h);
		}
	}
	
	public class Input{
		private Vector2 position = new Vector2();
		private int action;
		private MotionEvent me;
		
		public Vector2 getPosition(){
			return position;
		}
		
		public int getAction(){
			return action;
		}
		
		public MotionEvent getMotionEvent(){
			return me;
		}
	}
	
	public class Camera{
		
		private Vector2 position = new Vector2();
		private Vector2 size = new Vector2();
		private Entity follow;
		
		public Vector2 getPosition(){
			return position;
		}

		public Vector2 getSize(){
			return size;
		}
		
		public void followEntity(Entity entity){
			follow = entity;
		}
	}
	
	public class ActionBar{
		
		private Paint paint = new Paint();
		private Color color;
		private boolean isShow;
		
		public ActionBar(){
			color = new Color(){
				@Override
				public Color set(String hexColor) {
					super.set(hexColor);
					paint.setColor(toInt());
					return color;
				}
			}.set("6666ff");
		}
		
		public void draw(Canvas canvas){
			if(!isShow) return;
			canvas.drawRect(0, 0, getEngine().getWidth(), 100, paint);
		}
		
		public Color getColor(){
			return color;
		}
		
		public void show(){
			isShow = true;
		}
		
		public void hide(){
			isShow = false;
		}
	}
}

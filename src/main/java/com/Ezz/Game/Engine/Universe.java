package com.Ezz.Game.Engine;

import android.annotation.NonNull;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout.LayoutParams;
import com.Ezz.Game.Engine.graphic.Entity;
import com.Ezz.Game.Engine.math.Vector2;
import java.util.ArrayList;
import android.view.View.OnLongClickListener;
import android.os.Handler;
import android.app.ActionBar;

abstract public class Universe {

	private Engine engine;
	private Context context;
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	private ArrayList<Entity> UIentities = new ArrayList<Entity>();
	public Input Input = new Input();
	public Camera Camera = new Camera();

	public Universe(@NonNull Context context){
		this.context = context;
		((Activity) context).getActionBar().hide();
		engine = new Engine(context);
		start();
	}
	
	public Context getContext(){
		return context;
	}
	
	public ActionBar getActionBar(){
		return ((Activity) context).getActionBar();
	}
	
	public AssetManager getAssets(){
		return context.getAssets();
	}
	
	public Resources getResources(){
		return context.getResources();
	}
	
	public Engine getEngine(){
		return engine;
	}
	
	public abstract void start();
	public abstract void update();
	public abstract void onScreenTouch(float x, float y);

	public void setUniverse(@NonNull Universe universe){
		((Activity) context).setContentView(universe.getEngine());
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

	private class Engine extends View implements OnTouchListener, OnLongClickListener {

		private Entity lastTouchedEntity;

		Engine(Context context){
			super(context);
			Camera.size.set(getWidth(), getHeight());
			setOnTouchListener(this);
			setOnLongClickListener(this);
		}
		
		
		@Override
		public boolean onTouch(View p1, MotionEvent p2) {
			onScreenTouch(p2.getX(), getHeight() - p2.getY());
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
			Input.action = p2.getAction();
			Input.me = p2;
			Input.position.set(p2.getX(), getHeight() - p2.getY());
			return true;
		}

		@Override
		public boolean onLongClick(View p1) {
			for(Entity e: entities){
				if(e.getPosition().x < Input.getPosition().x && Input.getPosition().x < e.getPosition().x + e.getSize().x && e.getPosition().y < Input.getPosition().y && Input.getPosition().y < e.getPosition().y + e.getSize().y){
					e.onLongClick();
					e.getScreenListener().onLongClick();
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
				if(!e.isUI()){
					e.getScript().update();
					e.draw(canvas);
				}
			}
			for(Entity e: UIentities){
				e.getScript().update();
				e.draw(canvas);
			}
			update();
			if(Camera.follow != null)
				Camera.getPosition().set(Camera.follow.getPosition());
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
}

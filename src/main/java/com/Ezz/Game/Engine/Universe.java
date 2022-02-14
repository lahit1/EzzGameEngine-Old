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
import com.Ezz.Game.Engine.Entity;
import com.Ezz.Game.Engine.math.Vector2;
import java.util.ArrayList;

abstract public class Universe {

	private Engine engine;
	private Context context;
	private Vector2 position = new Vector2();
	private Vector2 size = new Vector2();
	private Vector2 gravity = new Vector2(0, -5);
	
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	public Input Input = new Input();

	public Universe(@NonNull Context context){
		this.context = context;
		((Activity) context).getActionBar().hide();
		engine = new Engine(context);
		engine.setOnTouchListener(engine);
		start();
	}
	
	public Context getContext(){
		return context;
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

	public Vector2 getPosition(){
		return position;
	}
	
	public Vector2 getSize(){
		return size;
	}
	
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

	private class Engine extends View implements OnTouchListener {

		Engine(Context context){
			super(context);
			size.set(getWidth(), getHeight());
		}
		
		@Override
		public boolean onTouch(View p1, MotionEvent p2) {
			onScreenTouch(p2.getX(), getHeight() - p2.getY());
			for(Entity e: entities){
				if(e.getPosition().x < Input.getPosition().x && Input.getPosition().x < e.getPosition().x + e.getSize().x && e.getPosition().y < Input.getPosition().y && Input.getPosition().y < e.getPosition().y + e.getSize().y){
					if(p2.getAction() == MotionEvent.ACTION_UP){
						e.onClick();
						e.getScreenListener().onClick();
					}else{
						e.onTouch();
						e.getScreenListener().onTouch();
					}
				}
			}
			Input.action = p2.getAction();
			Input.me = p2;
			Input.position.set(p2.getX(), getHeight() - p2.getY());
			return true;
		}
		
		@Override
		protected void onDraw(Canvas canvas) {
			super.onDraw(canvas);
			for(Entity e: entities){
				e.draw(canvas);
			}
			update();
			invalidate();
		}

		@Override
		protected void onSizeChanged(int w, int h, int oldw, int oldh) {
			super.onSizeChanged(w, h, oldw, oldh);
			size.set(w, h);
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
}

package com.Ezz.Game.Engine;

import android.annotation.NonNull;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
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
		engine = new Engine(context);
		((Activity) context).setContentView(engine);
		engine.setOnTouchListener(engine);
		start();
	}
	public Context getContext(){
		return context;
	}
	
	public abstract void start();
	public abstract void update();
	public abstract void onScreenTouch(float x, float y);

	public Vector2 getPosition(){
		position.set(engine.getX(), engine.getY());
		return position;
	}
	
	public Vector2 getSize(){
		return size;
	}
	
	public Vector2 getGravity(){
		return gravity;
	}

	public void setContentView(@NonNull View view){
		((Activity) getContext()).setContentView(view);
	}
	public void setContentView(@NonNull int layoutResID){
		((Activity) getContext()).setContentView(layoutResID);
	}

	public void setContentView(@NonNull View view, LayoutParams params){
		((Activity) getContext()).setContentView(view, params);
	}
	
	private class Engine extends View implements OnTouchListener {
		
		Engine(Context context){
			super(context);
			size.set(getWidth(), getHeight());
		}
		
		@Override
		public boolean onTouch(View p1, MotionEvent p2) {
			onScreenTouch(p2.getX(), getHeight() - p2.getY());
			Input.isClicked = p2.getAction() != MotionEvent.ACTION_UP;
			Input.position.set(p2.getX(), getHeight() - p2.getY());
			Input.montionevent = p2;
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
		private boolean isClicked = false;
		private Vector2 position = new Vector2();
		private MotionEvent montionevent;
		
		public boolean isScreenTouched(){
			return isClicked;
		}
		
		public Vector2 getPosition(){
			return position;
		}
		
		public MotionEvent getMontionEvent(){
			return montionevent;
		}
	}
}

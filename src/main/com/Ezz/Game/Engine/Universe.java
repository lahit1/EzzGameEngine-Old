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
import com.Ezz.Game.Engine.Math.Vector2;
import java.util.ArrayList;

abstract public class Universe extends View implements OnClickListener, OnTouchListener{

	public ArrayList<Entity> entities = new ArrayList<Entity>();
	private Vector2 position = new Vector2();

	public Universe(@NonNull Context context){
		super(context);
		setOnClickListener(this);
		setOnTouchListener(this);
		start();
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

	public abstract void start();
	public abstract void update();
	@Override public abstract void onClick(View p1);
	@Override public abstract boolean onTouch(View p1, MotionEvent p2);

	public Vector2 getPosition(){
		return position;
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
}

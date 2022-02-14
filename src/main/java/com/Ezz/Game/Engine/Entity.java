package com.Ezz.Game.Engine;

import android.annotation.NonNull;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.Ezz.Game.Engine.math.Vector2;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.Ezz.Game.Engine.ui.ScreenListener;

abstract public class Entity {
	
	private Universe universe;
	private Paint paint = new Paint();
	private Vector2 position = new Vector2();
	private Vector2 size = new Vector2(50, 50);
	private ScreenListener sl;
	
	public Entity(@NonNull Universe universe){
		this.universe = universe;
		universe.entities.add(this);
		sl = new ScreenListener(){
			@Override
			public void onClick() {
			}
			@Override
			public void onTouch() {
			}
		};
	}

	abstract public void draw(Canvas canvas);
	
	abstract public void onClick()
	
	abstract public void onTouch()
	
	public Universe getUniverse(){
		return universe;
	}
	
	public Paint getPaint(){
		return paint;
	}
	
	public Vector2 getPosition() {
		return position;
	}

	public Vector2 getSize() {
		return size;
	}
	
	public void setScreenListener(ScreenListener sl){
		this.sl = sl;
	}
	
	public ScreenListener getScreenListener(){
		return sl;
	}
	
	public float getRenderX(){
		return position.x;
	}
	
	public float getRenderY(){
		return -position.y + universe.getSize().y - size.y;
	}
}

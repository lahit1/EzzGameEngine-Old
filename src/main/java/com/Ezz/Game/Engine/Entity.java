package com.Ezz.Game.Engine;

import android.annotation.NonNull;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.Ezz.Game.Engine.math.Vector2;

abstract public class Entity {
	
	private Universe universe;
	private Paint paint = null;
	private Vector2 position = new Vector2();
	private Vector2 size = new Vector2(50, 50);
	
	public Entity(@NonNull Universe universe){
		this.universe = universe;
		universe.entities.add(this);
	}

	abstract public void draw(Canvas canvas);
	abstract public void onClick();
	abstract public void onTouch();
	
	public Universe getUniverse(){
		return universe;
	}
	
	public Paint getPaint(){
		if(paint == null){
			paint = new Paint();
			paint.setColor(Color.GRAY);
		}
		return paint;
	}
	
	public Vector2 getPosition() {
		return position;
	}

	public Vector2 getSize() {
		return size;
	}
	
	public float getRenderX(){
		return position.x;
	}
	
	public float getRenderY(){
		return -position.y + universe.getSize().y - size.y;
	}
}

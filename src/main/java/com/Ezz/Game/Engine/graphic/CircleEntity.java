package com.Ezz.Game.Engine.graphic;

import android.graphics.Canvas;
import com.Ezz.Game.Engine.Universe;
import com.Ezz.Game.Engine.graphic.Entity;

public class CircleEntity extends Entity {

	private float radius = 50;

	public CircleEntity(Universe universe){
		super(universe);
	}
	
	public CircleEntity(Universe universe, float radius){
		super(universe);
		this.radius = radius;
		getSize().set(radius * 2, radius * 2);
	}
	
	public void setRadius(float radius){
		this.radius = radius;
		getSize().set(radius * 2, radius * 2);
	}

	@Override
	public void draw(Canvas canvas) {
		getSize().set(radius * 2, radius * 2);
		canvas.drawCircle(getRenderX(), getRenderY(), getSize().x / 2, getPaint());
	}

	public float getRadius(){
		return radius;
	}

	@Override
	public void onClick() {
	}

	@Override
	public void onTouch() {
	}

	@Override
	public void onTouchMove() {
	}

	@Override
	public void onLongClick() {
	}
}

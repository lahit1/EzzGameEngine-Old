package com.Ezz.Game.Engine.graphic;

import android.graphics.Canvas;
import com.Ezz.Game.Engine.Universe;
import com.Ezz.Game.Engine.graphic.Entity;

public class CircleEntity extends Entity {

	public CircleEntity(Universe universe){
		super(universe);
	}
	
	public CircleEntity(Universe universe, float radius){
		super(universe);
		getSize().set(radius * 2, radius * 2);
	}
	
	public void setRadius(float radius){
		getSize().set(radius * 2, radius * 2);
	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawCircle(getRenderX(), getRenderY(), getSize().x / 2, getPaint());
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

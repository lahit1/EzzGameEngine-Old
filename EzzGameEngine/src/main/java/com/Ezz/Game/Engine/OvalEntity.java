package com.Ezz.Game.Engine;

import android.graphics.Canvas;

public class OvalEntity extends Entity {
	
	public OvalEntity(Universe universe){
		super(universe);
	}

	@Override
	public void draw(Canvas canvas){
		canvas.drawOval(getRenderX(), getRenderY(), getRenderX() + getSize().x, getRenderY() + getSize().y, getPaint());
	}
}

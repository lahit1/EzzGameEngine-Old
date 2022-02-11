package com.Ezz.Game.Engine;

import android.graphics.Canvas;

public class RectEntity extends Entity{
    
    public RectEntity(Universe universe){
		super(universe);
	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawRect(getRenderX(), getRenderY(), getRenderX() + getSize().x, getRenderY() + getSize().y, getPaint());
	}
}

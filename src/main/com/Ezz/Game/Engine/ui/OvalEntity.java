package com.Ezz.Game.Engine.ui;

import android.graphics.Canvas;
import com.Ezz.Game.Engine.Entity;
import com.Ezz.Game.Engine.Universe;

public class OvalEntity extends Entity {
	
	public OvalEntity(Universe universe){
		super(universe);
	}

	@Override
	public void draw(Canvas canvas){
		canvas.drawOval(getRenderX(), getRenderY(), getRenderX() + getSize().x, getRenderY() + getSize().y, getPaint());
	}
}
package com.Ezz.Game.Engine.graphic;

import android.graphics.Canvas;
import com.Ezz.Game.Engine.graphic.Entity;
import com.Ezz.Game.Engine.Universe;

public class OvalEntity extends Entity {
	
	public OvalEntity(Universe universe){
		super(universe);
	}

	@Override
	public void draw(Canvas canvas){
		canvas.drawOval(getRenderX(), getRenderY(), getRenderX() + getSize().x, getRenderY() + getSize().y, getPaint());
	}

	@Override
	public void onClick() {
	}

	@Override
	public void onTouch() {
	}

	@Override
	public void onLongClick() {
	}
}

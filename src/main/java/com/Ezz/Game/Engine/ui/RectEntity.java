package com.Ezz.Game.Engine.ui;

import android.graphics.Canvas;
import com.Ezz.Game.Engine.Entity;
import com.Ezz.Game.Engine.Universe;

public class RectEntity extends Entity{
    
    public RectEntity(Universe universe){
		super(universe);
	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawRect(getRenderX(), getRenderY(), getRenderX() + getSize().x, getRenderY() + getSize().y, getPaint());
	}

	@Override
	public void onClick() {
	}

	@Override
	public void onTouch() {
	}

}

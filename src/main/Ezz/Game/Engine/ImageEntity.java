package com.Ezz.Game.Engine;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

public class ImageEntity extends Entity {
	
	private Drawable drawable = null;
    
	public ImageEntity(Universe universe){
		super(universe);
	}
	
	public ImageEntity(Universe universe, Drawable drawable){
		super(universe);
		this.drawable = drawable;
	}

	public void setDrawable(Drawable drawable) {
		this.drawable = drawable;
	}

	public Drawable getDrawable() {
		return drawable;
	}
	
	@Override
	public void draw(Canvas canvas) {
		drawable.setBounds((int) getRenderX(), (int) getRenderY(), (int) getRenderX() + (int) getSize().x, (int)getRenderY() + (int)getSize().y);
		drawable.draw(canvas);
	}
}

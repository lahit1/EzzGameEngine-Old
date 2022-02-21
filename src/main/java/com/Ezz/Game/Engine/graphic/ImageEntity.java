package com.Ezz.Game.Engine.graphic;

import android.graphics.Canvas;
import com.Ezz.Game.Engine.graphic.Entity;
import com.Ezz.Game.Engine.Universe;
import com.Ezz.Game.Engine.file.Image;

public class ImageEntity extends Entity {
	
	private Image image = new Image();
    
	public ImageEntity(Universe universe){
		super(universe);
	}
	
	public ImageEntity(Universe universe, Image image){
		super(universe);
		this.image = image;
	}

	public void setDrawable(Image image) {
		this.image = image;
	}

	public Image getImage() {
		return image;
	}
	
	@Override
	public void draw(Canvas canvas) {
		if(image == null) return;
		image.getDrawable().setBounds((int) getRenderX(), (int) getRenderY(), (int) getRenderX() + (int) getSize().x, (int)getRenderY() + (int)getSize().y);
		image.getDrawable().draw(canvas);
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

package com.Ezz.Game.Engine.graphic;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import com.Ezz.Game.Engine.Universe;

public class ButtonEntity extends Entity {

	private Paint touchPaint = new Paint();

	public ButtonEntity(Universe universe){
		super(universe);
		getPaint().setColor(Color.GRAY);
		touchPaint.setColor(getPaint().getColor());
	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawRect(getRenderX(), getRenderY(), getRenderX() + getSize().x, getRenderY() + getSize().y, touchPaint);
	}

	@Override
	public void onClick() {
		touchPaint.setColor(getPaint().getColor());
	}

	@Override
	public void onTouch() {
		touchPaint.setColor(getPaint().getColor() + Color.parseColor("#333333"));
	}

	@Override
	public void onTouchMove() {
		touchPaint.setColor(getPaint().getColor());
	}

	@Override
	public void onLongClick() {
	}
}

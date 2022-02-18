package com.Ezz.Game.Engine.graphic;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.Ezz.Game.Engine.graphic.Entity;
import com.Ezz.Game.Engine.Universe;
import com.Ezz.Game.Engine.math.Vector2;
import android.view.MotionEvent;

public class SwitchEntity extends Entity {
	
	private Paint buttonPaint;
	private boolean checked;
	private int butPos;
	
	public SwitchEntity(Universe universe){
		super(universe);
		getPaint().setColor(Color.GRAY);
		buttonPaint = new Paint();
		buttonPaint.setColor(Color.BLACK);
	}

	@Override
	public void draw(Canvas canvas) {
		if(checked){
			getPaint().setColor(Color.GREEN);
		}else{
			getPaint().setColor(Color.GRAY);
		}
		canvas.drawOval(getRenderX(), getRenderY(), getRenderX() + getSize().x/3, getRenderY() + getSize().y, getPaint());
		canvas.drawOval(getRenderX() + getSize().x/3*2, getRenderY(), getRenderX() + getSize().x/3, getRenderY() + getSize().y, getPaint());
		canvas.drawRect(getRenderX() + getSize().x/6, getRenderY(), getRenderX() + getSize().x/3*1.5f, getRenderY() + getSize().y, getPaint());
		if(checked){
			canvas.drawOval(getRenderX() + getSize().x/3, getRenderY(), getRenderX() + getSize().x/1.5f, getRenderY() + getSize().y, buttonPaint);
		}else{
			canvas.drawOval(getRenderX(), getRenderY(), getRenderX() + getSize().x/3, getRenderY() + getSize().y, buttonPaint);
		}
	}

	public Paint getButtonPaint() {
		return buttonPaint;
	}
	
	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean isChecked() {
		return checked;
	}

	@Override
	public void onTouch() {
	}

	@Override
	public void onTouchMove() {
	}

	@Override
	public void onClick() {
		checked = !checked;
	}

	@Override
	public void onLongClick() {
	}
}

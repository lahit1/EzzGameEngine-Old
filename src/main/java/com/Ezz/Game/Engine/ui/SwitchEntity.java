package com.Ezz.Game.Engine.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.Ezz.Game.Engine.Entity;
import com.Ezz.Game.Engine.Universe;
import com.Ezz.Game.Engine.math.Vector2;
import android.graphics.Color;

public class SwitchEntity extends Entity {
	
	private Paint buttonPaint;
	private boolean checked;
	
	SwitchEntity(Universe universe){
		super(universe);
		getPaint().setColor(Color.GRAY);
		buttonPaint = new Paint();
		buttonPaint.setColor(Color.BLACK);
	}

	@Override
	public void draw(Canvas canvas) {
		if(getUniverse().Input.isScreenTouched()){
			Vector2 pos = getUniverse().Input.getPosition();
			checked = getPosition().x < pos.x && pos.x < getPosition().x + getSize().x && getPosition().y < pos.y && pos.y < getPosition().y + getSize().y;
		}
		
		if(checked){
			getPaint().setColor(Color.GREEN);
		}else{
			getPaint().setColor(Color.GRAY);
		}
		canvas.drawOval(getRenderX(), getRenderY(), getRenderX() + getSize().x, getRenderY() + getSize().y, getPaint());
		canvas.drawOval(getRenderX() + getSize().x, getRenderY(), getRenderX() + getSize().x*2, getRenderY() + getSize().y, getPaint());
		canvas.drawRect(getRenderX() + getSize().x/2, getRenderY(), getRenderX() + getSize().x*1.5f, getRenderY() + getSize().y, getPaint());
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
}

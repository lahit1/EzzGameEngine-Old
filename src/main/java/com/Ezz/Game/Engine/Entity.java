package com.Ezz.Game.Engine;

import android.annotation.NonNull;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.Ezz.Game.Engine.math.Vector2;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.Ezz.Game.Engine.ui.ScreenListener;

abstract public class Entity {

	private Universe universe;
	private Paint paint = new Paint();
	private Vector2 position = new Vector2();
	private Vector2 size = new Vector2(50, 50);
	private ScreenListener sl;
	private Script script;
	private boolean isUI = false;
	
	public int TouchTime;

	public Entity(@NonNull Universe universe) {
		this.universe = universe;
		universe.entities.add(this);
		sl = new ScreenListener(){
			@Override
			public void onClick() {
			}
			@Override
			public void onTouch() {
			}
			@Override
			public void onLongClick(){
			}
		};
		script = new Script(){

			@Override
			public void start() {
			}
			@Override
			public void update() {
			}
			
			@Override
			public void onClick() {
			}

			@Override
			public void onTouch() {
			}
		};
	}

	abstract public void draw(Canvas canvas);

	abstract public void onClick();

	abstract public void onTouch();

	abstract public void onLongClick();

	public Universe getUniverse() {
		return universe;
	}

	public Paint getPaint() {
		return paint;
	}

	public Vector2 getPosition() {
		return position;
	}

	public Vector2 getSize() {
		return size;
	}

	public void setScreenListener(ScreenListener sl) {
		this.sl = sl;
	}

	public ScreenListener getScreenListener() {
		return sl;
	}

	public void setScript(Script script) {
		this.script = script;
		script.myEntity = this;
		script.start();
	}

	public Script getScript() {
		return script;
	}

	public void setUI(boolean v) {
		isUI = v;
	}

	public boolean isUI() {
		return isUI;
	}

	public float getRenderX() {
		return position.x - (isUI ? 0 : universe.Camera.getPosition().x);
	}

	public float getRenderY() {
		return -position.y + universe.Camera.getSize().y - size.y - (isUI ? 0 : universe.Camera.getPosition().y);
	}
}

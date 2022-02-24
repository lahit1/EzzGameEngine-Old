package com.Ezz.Game.Engine.graphic;

import android.annotation.NonNull;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.Ezz.Game.Engine.Script;
import com.Ezz.Game.Engine.Universe;
import com.Ezz.Game.Engine.math.Vector2;
import com.Ezz.Game.Engine.util.Color;
import com.Ezz.Game.Engine.util.ScreenListener;
import java.util.ArrayList;
import com.Ezz.Game.Engine.physic.RigidBody;

abstract public class Entity {

	private Universe universe;
	Paint paint = new Paint();
	private Color color;
	private Vector2 position = new Vector2();
	private Vector2 size = new Vector2(50, 50);
	private float rotation;
	public float angular;
	private ScreenListener sl;
	private ArrayList<Script> scripts = new ArrayList<Script>();
	private RigidBody rigidBody;
	private boolean isUI = false;
	
	public Entity(@NonNull Universe universe) {
		this.universe = universe;
		universe.entities.add(this);
		sl = new ScreenListener(){
			@Override
			public void onClick() {}
			@Override
			public void onTouch() {}
			@Override
			public void onTouchMove() {}
		};
		color = new Color(){
			@Override
			public Color set(@NonNull String hexColor) {
				super.set(hexColor);
				paint.setColor(toInt());
				return color;
			}
		};
	}

	abstract public void draw(@NonNull Canvas canvas);

	abstract public void onClick();

	abstract public void onTouch();

	abstract public void onTouchMove();

	public Universe getUniverse() {
		return universe;
	}

	Paint getPaint() {
		return paint;
	}

	public Color getColor(){
		return color;
	}

	public Vector2 getPosition() {
		return position;
	}

	public Vector2 getSize() {
		return size;
	}

	public void setRotation(float degrees){
		rotation = degrees;
	}

	public void rotate(float degrees){
		rotation += degrees;
	}

	public float getRotation(){
		return rotation;
	}

	public void setScreenListener(@NonNull ScreenListener sl) {
		this.sl = sl;
	}

	public ScreenListener getScreenListener() {
		return sl;
	}

	public void addScript(@NonNull Script script) {
		scripts.add(script);
		script.myEntity = this;
		script.setAssetManager(getUniverse().getAssets());
		script.setResources(getUniverse().getResources());
		script.setUniverse(getUniverse());
		script.start();
	}

	public ArrayList<Script> getScripts() {
		return scripts;
	}
	
	public void setRigidBody(@NonNull RigidBody rigidBody){
		this.rigidBody = rigidBody;
	}

	public RigidBody getRigidBody(){
		return rigidBody;
	}

	public void setUI(boolean v) {
		isUI = v;
	}

	public boolean isUI() {
		return isUI;
	}

	public float getRenderX() {
		return position.x - (isUI ? 0 : universe.Camera.getPosition().x) - size.x/2;
	}

	public float getRenderY() {
		return -position.y + universe.Camera.getSize().y - size.y/2 - (isUI ? 0 : universe.Camera.getPosition().y);
	}
}

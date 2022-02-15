package com.Ezz.Game.Engine.math;

import android.annotation.NonNull;

public class Vector2 {

	public float x = 0;
	public float y = 0;

	public Vector2(){}

    public Vector2(float x, float y){
		this.x = x;
		this.y = y;
	}

	public double getHypotenuse(){
		return Math.hypot(x, y);
	}

	public float getAngle(){
		return 360 - (float) Math.toRadians(Math.atan2(x, y)) * Math.signum(x);
	}

	public void set(float x, float y){
		this.x = x;
		this.y = y;
	}

	public void set(@NonNull Vector2 v){
		x = v.x;
		y = v.y;
	}
	
	public void add(float x, float y){
		this.x += x;
		this.y += y;
	}
	
	public void add(@NonNull Vector2 v){
		this.x += v.x;
		this.y += v.y;
	}
	
	public void sub(float x, float y){
		this.x -= x;
		this.y -= y;
	}

	public void sub(@NonNull Vector2 v){
		this.x -= v.x;
		this.y -= v.y;
	}
	
	public void mul(float x, float y){
		this.x *= x;
		this.y *= y;
	}
	
	public void mul(@NonNull Vector2 v){
		this.x *= v.x;
		this.y *= v.y;
	}
	
	public void div(float x, float y){
		this.x /= x;
		this.y /= y;
	}

	public void div(@NonNull Vector2 v){
		this.x /= v.x;
		this.y /= v.y;
	}
	
	public Float[] toFloatArray(){
		Float[] f = {x, y};
		return f;
	}

	@Override
	public String toString() {
		return toFloatArray().toString();
	}
}

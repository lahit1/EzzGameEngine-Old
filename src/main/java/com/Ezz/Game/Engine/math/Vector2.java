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
	
	public Vector2(@NonNull Vector2 v){
		this.x = v.x;
		this.y = v.y;
	}

	public float getHypotenuse(){
		return (float)Math.hypot(x, y);
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
	
	public Vector2 calculate(float x, float y){
		Vector2 vc = new Vector2(x, y);
		vc.sub(this);
		return vc;
	}
	
	public Vector2 calculate(@NonNull Vector2 v){
		Vector2 vc = new Vector2(v);
		vc.sub(this);
		return vc;
	}
	
	public Float[] toArray(){
		Float[] f = {x, y};
		return f;
	}

	@Override
	public String toString() {
		return toArray().toString();
	}
}

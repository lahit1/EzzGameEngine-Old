package com.Ezz.Game.Engine.math;

import android.annotation.NonNull;

public class Quaternion {

	public float x = 0;
	public float y = 0;
	public float z = 0;
	public float w = 0;

	public Quaternion(){}

    public Quaternion(float x, float y, float z, float w){
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	public void set(float x, float y, float z, float w){
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	public void set(@NonNull Quaternion q){
		x = q.x;
		y = q.y;
		z = q.z;
		w = q.w;
	}
	
	public void translate(float x, float y, float z, float w){
		this.x += x;
		this.y += y;
		this.z += z;
		this.w += w;
	}

	public Float[] toFloatArray(){
		Float[] f = {x, y, z, w};
		return f;
	}

	@Override
	public String toString() {
		return toFloatArray().toString();
	}
}

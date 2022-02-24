package com.Ezz.Game.Engine.math;

import android.annotation.NonNull;

public class Vector3 {

	public float x = 0;
	public float y = 0;
	public float z = 0;

	public Vector3(){}

    public Vector3(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3(Vector3 v){
		this.x = v.x;
		this.y = v.y;
		this.z = v.z;
	}

	public void set(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void set(@NonNull Vector3 v){
		x = v.x;
		y = v.y;
		z = v.z;
	}
	
	public void add(float x, float y, float z){
		this.x += x;
		this.y += y;
		this.z += z;
	}
	
	public void add(Vector3 v){
		this.x += v.x;
		this.y += v.y;
		this.z += v.z;
	}
	
	public void sub(float x, float y, float z){
		this.x -= x;
		this.y -= y;
		this.z -= z;
	}

	public void sub(Vector3 v){
		this.x -= v.x;
		this.y -= v.y;
		this.z -= v.z;
	}
	
	public void mul(float x, float y, float z){
		this.x *= x;
		this.y *= y;
		this.z *= z;
	}
	
	public void mul(Vector3 v){
		this.x *= v.x;
		this.y *= v.y;
		this.z *= v.z;
	}
	
	public void div(float x, float y, float z){
		this.x /= x;
		this.y /= y;
		this.z /= z;
	}

	public void div(Vector3 v){
		this.x /= v.x;
		this.y /= v.y;
		this.z /= v.z;
	}

	public Vector3 calculate(float x, float y, float z){
		Vector3 vc = new Vector3(x, y, z);
		vc.sub(this);
		return vc;
	}

	public Vector3 calculate(Vector3 v){
		Vector3 vc = new Vector3(v);
		vc.sub(this);
		return vc;
	}

	public Float[] toArray(){
		Float[] f = {x, y, z};
		return f;
	}

	@Override
	public String toString() {
		return toArray().toString();
	}
}

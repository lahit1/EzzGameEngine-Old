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

	public Quaternion(@NonNull Quaternion q){
		this.x = q.x;
		this.y = q.y;
		this.z = q.z;
		this.w = q.w;
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
	
	public void add(float x, float y, float z, float w){
		this.x += x;
		this.y += y;
		this.z += z;
		this.w += w;
	}
	
	public void add(@NonNull Quaternion q){
		this.x += q.x;
		this.y += q.y;
		this.z += q.z;
		this.w += q.w;
	}
	
	public void sub(float x, float y, float z, float w){
		this.x -= x;
		this.y -= y;
		this.z -= z;
		this.w -= w;
	}

	public void sub(@NonNull Quaternion q){
		this.x -= q.x;
		this.y -= q.y;
		this.z -= q.z;
		this.w -= q.w;
	}
	
	public void mul(float x, float y, float z, float w){
		this.x *= x;
		this.y *= y;
		this.z *= z;
		this.w *= w;
	}
	
	public void mul(@NonNull Quaternion q){
		this.x *= q.x;
		this.y *= q.y;
		this.z *= q.z;
		this.w *= q.w;
	}
	
	public void div(float x, float y, float z, float w){
		this.x /= x;
		this.y /= y;
		this.z /= z;
		this.w /= w;
	}

	public void div(@NonNull Quaternion q){
		this.x /= q.x;
		this.y /= q.y;
		this.z /= q.z;
		this.w /= q.w;
	}

	public Quaternion calculate(float x, float y, float z, float w){
		Quaternion qc = new Quaternion(x, y, z, w);
		qc.sub(this);
		return qc;
	}

	public Quaternion calculate(@NonNull Quaternion v){
		Quaternion qc = new Quaternion(v);
		qc.sub(this);
		return qc;
	}

	public Float[] toArray(){
		Float[] f = {x, y, z, w};
		return f;
	}

	@Override
	public String toString() {
		return toArray().toString();
	}
}

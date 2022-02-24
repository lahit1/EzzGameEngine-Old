package com.Ezz.Game.Engine.math;

import android.annotation.NonNull;

public class Rect {
    
	public float left;
	public float bottom;
	public float right;
	public float top;
	
	public Rect(){}
	
	public Rect(float left, float bottom, float right, float top){
		this.left = left;
		this.bottom = bottom;
		this.right = right;
		this.top = top;
	}
	
	public Rect(@NonNull Rect r){
		this.left = r.left;
		this.bottom = r.bottom;
		this.right = r.right;
		this.top = r.top;
	}
    
	public void set(float left, float bottom, float right, float top){
		this.left = left;
		this.bottom = bottom;
		this.right = right;
		this.top = top;
	}
	
	public void set(@NonNull Rect r){
		this.left = r.left;
		this.bottom = r.bottom;
		this.right = r.right;
		this.top = r.top;
	}

	public float getArea(){
		return (right - left)*(top - bottom);
	}

	public float[] toArray(){
		float[] arr = {left, bottom, right, top};
		return arr;
	}

	@Override
	public String toString() {
		return toArray().toString();
	}
}

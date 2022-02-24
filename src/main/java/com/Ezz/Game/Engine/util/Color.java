package com.Ezz.Game.Engine.util;

public class Color {

	private float color;
	
    public Color() {}

	public Color(String hexColor) {
		set(hexColor);
	}

	public Color(int r, int g, int b, int a){
		color = android.graphics.Color.argb(a, r, g, b);
	}
	
	public Color(float r, float g, float b, float a){
		color = android.graphics.Color.argb(a, r, g, b);
	}
	
	public Color set(String hexColor) {
		if(hexColor.startsWith("#")){
			color = android.graphics.Color.parseColor(hexColor);
		}else{
			color = android.graphics.Color.parseColor("#" + hexColor);
		}
		return this;
	}

	public Color set(int r, int g, int b, int a){
		color = android.graphics.Color.argb(a, r, g, b);
		return this;
	}
	
	public Color set(float r, float g, float b, float a){
		color = android.graphics.Color.argb(a, r, g, b);
		return this;
	}
	
	public int toInt() {
		return (int) color;
	}
}

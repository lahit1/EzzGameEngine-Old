package com.Ezz.Game.Engine.file;

import android.annotation.NonNull;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.io.InputStream;

public class Image {
	
	private Drawable drawable;

    public Image(@NonNull Drawable drawable){
		this.drawable = drawable;
	}
    
    public Image(@NonNull Bitmap bitmap){
		drawable = new BitmapDrawable(bitmap);
	}
	public Image(@NonNull InputStream is){
		drawable = new BitmapDrawable(BitmapFactory.decodeStream(is));
	}
	
	public Drawable getDrawable(){
		return drawable;
	}
	
	public void setDrawable(@NonNull Drawable drawable){
		this.drawable = drawable;
	}

	public void setBitmap(@NonNull Bitmap bitmap){
		drawable = new BitmapDrawable(bitmap);
	}
	
	public void setFromStream(@NonNull InputStream is){
		drawable = new BitmapDrawable(BitmapFactory.decodeStream(is));
	}
}

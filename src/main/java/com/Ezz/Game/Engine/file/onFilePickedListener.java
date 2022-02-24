package com.Ezz.Game.Engine.file;
import android.net.Uri;

public interface onFilePickedListener {
    
    public void onPicked(Uri uri);
    public void onError();
}

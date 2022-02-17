package com.Ezz.Game.Engine.net;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.Ezz.Game.Engine.Universe;

public class Link {
    
	private Universe universe;
	private String url;
	
    public Link(Universe universe, String url){
		this.universe = universe;
		this.url = url;
	}
    
	public void open(){
		Intent i = new Intent();
		i.setAction(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		((Activity)universe.getContext()).startActivity(i);
	}
	
	public static void open(Universe universe, String url){
		Intent i = new Intent();
		i.setAction(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		((Activity)universe.getContext()).startActivity(i);
	}
}

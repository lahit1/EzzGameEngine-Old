package com.Ezz.Game.Engine.graphic;
import com.Ezz.Game.Engine.Universe;

public class Toast {
    
    public static void create(Universe universe, String message, int lenght){
		android.widget.Toast.makeText(universe.getContext(), message, lenght).show();
	}
    
	public static int LENGTH_SHORT = android.widget.Toast.LENGTH_SHORT;
	public static int LENGTH_LONG = android.widget.Toast.LENGTH_LONG;
}

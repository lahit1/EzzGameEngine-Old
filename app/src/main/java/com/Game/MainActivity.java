package com.Game;
 
import android.app.Activity;
import android.os.Bundle;
import com.Ezz.Game.Engine.Universe;
import android.graphics.RectF;

public class MainActivity extends Activity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
		setContentView(new Lobby(this));
    }
}

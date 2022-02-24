package com.Ezz.Game.Engine;
import android.app.Activity;
import android.content.Intent;
import com.Ezz.Game.Engine.file.onFilePickedListener;

public class EzzActivity extends Activity{
    
	private Universe universe;
	
	public void startUniverse(Universe universe){
		this.universe = universe;
		universe.initializeUniverse(this);
		setContentView(universe.getEngine());
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode != RESULT_OK) return;
		if(requestCode == 949996621){
			for(onFilePickedListener ofpl: universe.filePickListeners){
				ofpl.onPicked(data.getData());
				universe.filePickListeners.remove(ofpl);
			}
		}
	}
}

package com.Ezz.Game.Engine.file;

import android.content.Intent;
import com.Ezz.Game.Engine.EzzActivity;
import com.Ezz.Game.Engine.Universe;

public class FilePicker {
	
    private Intent fp = new Intent(Intent.ACTION_GET_CONTENT);
	private Universe universe;
	
	public FilePicker(Universe universe){
		this.universe = universe;
	}

	public void pick(onFilePickedListener ofpl){
		universe.addOnFilePickedListener(ofpl);
		((EzzActivity) universe.getContext()).startActivityForResult(fp, 949996621);
	}
}

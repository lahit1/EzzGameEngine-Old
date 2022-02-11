package com.Game;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.Ezz.Game.Engine.Universe;
import android.view.MotionEvent;

public class Lobby extends Universe{
	
	public Lobby(Context context){
		super(context);
	}

	@Override
	public void start() {
	}

	@Override
	public void update() {
	}

	@Override
	public void onClick(View p1) {
		((Activity) getContext()).setContentView(new TestGame(getContext()));
	}

	@Override
	public boolean onTouch(View p1, MotionEvent p2) {
		return false;
	}
}

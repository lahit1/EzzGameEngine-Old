package com.Game;

import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import com.Ezz.Game.Engine.Entity;
import com.Ezz.Game.Engine.OvalEntity;
import com.Ezz.Game.Engine.Universe;
import com.Ezz.Game.Engine.RectEntity;
import com.Ezz.Game.Engine.ImageEntity;
import android.graphics.drawable.Drawable;

public class TestGame extends Universe {

	

	Entity e;
	ImageEntity e2;
	
	public TestGame(Context context){
		super(context);
	}

	@Override
	public void start() {
		e = new OvalEntity(this);
		e.getPaint().setColor(Color.BLUE);
		e.getSize().set(250, 250);
		e.getPosition().y = 500;
		
		e2 = new ImageEntity(this);
		e2.setDrawable(getResources().getDrawable(R.drawable.ic_launcher));
		e2.getSize().set(250, 250);
		e2.getPosition().set(500, 250);
	}

	@Override
	public void update() {
		e.getPosition().x += 1.25;
		e.getPosition().y += 5;
		if(e.getPosition().y <= 300){
			e.getPosition().y = 300;
		}
	}

	@Override
	public boolean onTouch(View p1, MotionEvent p2) {
		try{
			e.getPosition().set(p2.getX(), p2.getY());
		}catch(Exception e){
			return false;
		}
		return true;
	}

	@Override
	public void onClick(View p1) {
	}
}

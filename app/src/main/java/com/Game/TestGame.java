package com.Game;

import android.content.Context;
import android.graphics.Color;
import android.widget.Toast;
import com.Ezz.Game.Engine.Entity;
import com.Ezz.Game.Engine.Universe;
import com.Ezz.Game.Engine.file.Image;
import com.Ezz.Game.Engine.ui.ImageEntity;
import com.Ezz.Game.Engine.ui.OvalEntity;
import com.Ezz.Game.Engine.ui.RectEntity;
import com.Ezz.Game.Engine.ui.ScreenListener;
import com.Ezz.Game.Engine.ui.SwitchEntity;
import java.io.IOException;
import android.media.MediaPlayer;
import com.Ezz.Game.Engine.Script;

public class TestGame extends Universe {

	Entity e;

	public TestGame(Context context) {
		super(context);
	}

	@Override
	public void start() {
		e = new OvalEntity(this);
		e.getPaint().setColor(Color.BLUE);
		e.getSize().set(250, 250);
		e.getPosition().y = 500;
		e.setUI(true);
		e.setScreenListener(new ScreenListener(){

				@Override
				public void onClick() {
				}

				@Override
				public void onTouch() {
//					Toast.makeText(getContext(), "Touch", Toast.LENGTH_SHORT).show();
				}

				@Override
				public void onLongClick() {
					Toast.makeText(getContext(), "LongClick", Toast.LENGTH_SHORT).show();
				}
		});
	}

	@Override
	public void update() {
		Camera.getPosition().add(2, 2);
	}

	@Override
	public void onScreenTouch(float x, float y) {
	}
}

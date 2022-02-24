package com.Ezz.Game.Engine;

import android.content.res.AssetManager;
import android.content.res.Resources;
import com.Ezz.Game.Engine.graphic.Entity;
import java.lang.reflect.ParameterizedType;

abstract public class Script<Entity>{
	public com.Ezz.Game.Engine.graphic.Entity myEntity = null;
	private Universe Universe;
	private AssetManager AssetManager;
	private Resources Resources;

	abstract public void start();
	abstract public void update();
	
	public void setUniverse(Universe universe) {
		Universe = universe;
	}

	public Universe getUniverse() {
		return Universe;
	}

	public void setAssetManager(AssetManager assetManager) {
		AssetManager = assetManager;
	}

	public AssetManager getAssetManager() {
		return AssetManager;
	}

	public void setResources(Resources resources) {
		Resources = resources;
	}

	public Resources getResources() {
		return Resources;
	}
}

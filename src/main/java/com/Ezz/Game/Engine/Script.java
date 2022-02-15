package com.Ezz.Game.Engine;
import android.content.res.AssetManager;
import android.content.res.Resources;

abstract public class Script{
	private Universe Universe;
	private AssetManager AssetManager;
	private Resources Resources;
	
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

abstract public interface Script {
	
	public Entity myEntity;
    abstract public void start();
	abstract public void update();
	abstract public void onClick();
	abstract public void onTouch();
}

package com.Ezz.Game.Engine.physic;

import com.Ezz.Game.Engine.math.Vector2;
import com.Ezz.Game.Engine.graphic.Entity;
import com.Ezz.Game.Engine.Script;

public class RigidBody{

	private Vector2 gravityMultipler = new Vector2(0, 1);
	private Vector2 velocity = new Vector2();

	public void act(Entity entity) {
		velocity.y -= gravityMultipler.y * entity.getUniverse().getGravity().y * 0.1;
		float cx = gravityMultipler.x * entity.getUniverse().getGravity().x;
		velocity.x /= cx == 0 ? 1 : cx;
		entity.getPosition().add(velocity);
	}
	
	public Vector2 getGravityMultipler(){
		return gravityMultipler;
	}
	
	public Vector2 getVelocity(){
		return velocity;
	}
}

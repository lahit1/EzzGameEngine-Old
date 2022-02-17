package com.Ezz.Game.Engine.physic;

import com.Ezz.Game.Engine.graphic.Entity;
import com.Ezz.Game.Engine.math.Vector2;

public class RigidBody {

	public Entity entity;
	private Vector2 gravity;
	private Collider collider;

    public void update(){
		entity.getPosition().add(gravity);
	}

	public void setCollider(Collider collider){
		this.collider = collider;
	}

	public Collider getCollider(){
		return collider;
	}
}

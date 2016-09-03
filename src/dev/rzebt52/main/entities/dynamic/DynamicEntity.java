package dev.rzebt52.main.entities.dynamic;

import dev.rzebt52.main.Conveyor;
import dev.rzebt52.main.entities.Entity;

public abstract class DynamicEntity extends Entity {

	protected float speed;
	protected float xSpeed;
	protected float ySpeed;

	public DynamicEntity(int x, int y, Conveyor conveyor) {

		super(x, y, conveyor);

	}

	protected void move() {

		if (!getCollision(xSpeed, 0)) {
			moveX();
		}

		if (!getCollision(0, ySpeed)) {
			moveY();
		}

	}

	protected void moveX() {
		x += xSpeed;
	}

	protected void moveY() {
		y += ySpeed;
	}

}

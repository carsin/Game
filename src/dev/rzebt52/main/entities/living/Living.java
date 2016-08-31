package dev.rzebt52.main.entities.living;

import dev.rzebt52.main.Conveyor;
import dev.rzebt52.main.entities.Entity;

public abstract class Living extends Entity {

	protected float speed;
	protected float xSpeed;
	protected float ySpeed;
	protected float traction;
	
	public Living(int x, int y, Conveyor conveyor) {
		
		super(x, y, conveyor);
		
	}
	
	protected void move() {
		
		moveX();
		moveY();
		
	}
	
	protected void moveX() {
		x += xSpeed;
		bounds.x = (int) (x + boundsX);
	}
	
	protected void moveY() {
		y += ySpeed;
		bounds.y = (int) (y + boundsY);
	}

}

package dev.rzebt52.main.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.rzebt52.main.Conveyor;
import dev.rzebt52.main.graphics.Assets;

public abstract class Entity {

	protected float x;
	protected float y;
	protected int width = Assets.DRAWSIZE;
	protected int height = Assets.DRAWSIZE;
	protected HitBox bounds;
	protected Conveyor conveyor;

	public Entity(float x, float y, Conveyor conveyor) {

		this.x = x;
		this.y = y;
		this.conveyor = conveyor;

		bounds = new HitBox(0, 0, width, height);

	}

	public boolean getCollision(float xOffset, float yOffset) {
		for(Entity e : conveyor.getEntityHandler().getEntities()) {
			if(e.equals(this)) {
				continue;
			}
			if(e.getRectOffset(0f, 0f).intersects(getRectOffset(xOffset, yOffset))) {
				return true;
			}
		}
		return false;
	}

	public Rectangle getRectOffset(float xOffset, float yOffset) {
		return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
	}

	public abstract void tick();

	public abstract void render(Graphics g);

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}

}

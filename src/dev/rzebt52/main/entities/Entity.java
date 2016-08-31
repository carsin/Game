package dev.rzebt52.main.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.rzebt52.main.Conveyor;
import dev.rzebt52.main.graphics.Assets;

public abstract class Entity {

	protected int boundsX;
	protected int boundsY;
	protected int boundsWidth;
	protected int boundsHeight;
	protected float x;
	protected float y;
	protected int width = Assets.DRAW_SIZE;
	protected int height = Assets.DRAW_SIZE;
	protected Rectangle bounds;
	protected Conveyor conveyor;

	public Entity(float x, float y, Conveyor conveyor) {

		this.x = x;
		this.y = y;
		this.conveyor = conveyor;
		
		bounds = new Rectangle();
		
		boundsX = (int) x;
		boundsY = (int) y;
		boundsWidth = width;
		boundsHeight = height;
		
		updateBounds();

	}
	
	public void updateBounds() {
		bounds.setBounds((int) (x + boundsX), (int) (y + boundsY), boundsWidth, boundsHeight);
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

}

package dev.rzebt52.main.graphics.camera;

import dev.rzebt52.main.Conveyor;
import dev.rzebt52.main.Game;
import dev.rzebt52.main.entities.Entity;

public class Camera {

	private int xOffset;
	private int yOffset;
	private Entity centeredEntity;
	@SuppressWarnings("unused")
	private Conveyor conveyor;
	
	public Camera(Conveyor conveyor) {
		this.conveyor = conveyor;
	}
	
	public Camera(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void centerOnEntity(Entity e) {
		centeredEntity = e;
	}
	
	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	public int getxOffset() {
		return xOffset;
	}

	public void setxOffset(int xOffset) {
		this.xOffset = xOffset;
	}

	public int getyOffset() {
		return yOffset;
	}

	public void setyOffset(int yOffset) {
		this.yOffset = yOffset;
	}

	public void tick() {
		xOffset = (int) centeredEntity.getX() - (Game.WIDTH - centeredEntity.getWidth()) / 2;
		yOffset = (int) centeredEntity.getY() - (Game.HEIGHT - centeredEntity.getHeight()) / 2;
	}
	
}


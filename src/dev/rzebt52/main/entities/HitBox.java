package dev.rzebt52.main.entities;

import java.awt.Rectangle;

public class HitBox extends Rectangle {

	private static final long serialVersionUID = 1L;
	private boolean isTrigger;
	
	public HitBox(int x, int y, int width, int height, boolean isTrigger) {
		
		super(x, y, width, height);
		
		this.isTrigger = isTrigger;
		
	}
	
	public void setTrigger(boolean isTrigger) {
		this.isTrigger = isTrigger;
	}
	
	public boolean isTrigger() {
		return isTrigger;
	}
	
	public boolean isCollider() {
		return !isTrigger;
	}
	
}

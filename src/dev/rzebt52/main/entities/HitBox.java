package dev.rzebt52.main.entities;

import java.awt.Rectangle;

public class HitBox extends Rectangle {

	private static final long serialVersionUID = 1L;
	
	public HitBox(int x, int y, int width, int height) {
		
		super(x, y, width - 1, height - 1);
		
	}
	
	public void setBounds(int x, int y, int width, int height) {
		
		this.x = x;
		this.y = y;
		this.width = width - 1;
		this.height = height - 1;
		
	}
	
}

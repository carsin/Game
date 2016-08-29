package dev.rzebt52.main.graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	public int width;
	public int height;
	
	public BufferedImage spriteSheet;
	
	public SpriteSheet(BufferedImage spriteSheet) {
		
		this.spriteSheet = spriteSheet;
		
		width = spriteSheet.getWidth();
		height = spriteSheet.getHeight();
		
	}
	
	public BufferedImage crop(int x, int y, int width, int height) {
		
		return spriteSheet.getSubimage(x * Assets.RESOLUTION, y * Assets.RESOLUTION, 
				width * Assets.RESOLUTION, height * Assets.RESOLUTION);
		
	}
	
	public BufferedImage crop(int x, int y) {
		
		return spriteSheet.getSubimage(x * Assets.RESOLUTION, y * Assets.RESOLUTION, 
				Assets.RESOLUTION, Assets.RESOLUTION);
		
	}
	
}

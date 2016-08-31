package dev.rzebt52.main.graphics;

import java.awt.image.BufferedImage;

public class Assets {

	public static final int RESOLUTION = 8;
	public static final int DRAW_SIZE = 56;
	
	public static SpriteSheet tiles;
	
	public static BufferedImage test;
	
	public static void update() {
		
		tiles = new SpriteSheet(ImageHandler.loadImage("resources/texturepacks/tiles.png"));
		
		test = tiles.crop(0, 0);
		
	}
	
}

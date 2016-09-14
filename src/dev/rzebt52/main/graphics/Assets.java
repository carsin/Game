package dev.rzebt52.main.graphics;

import java.awt.image.BufferedImage;

public class Assets {

	public static final int RESOLUTION = 8;
	public static final int DRAWSIZE = 56;
	public static final int DRAWRES = DRAWSIZE / RESOLUTION;
	
	public static SpriteSheet tiles, playerSpriteSheet;
	
	public static BufferedImage player, dirt, stone;
	
	public static void update() {
		
		tiles = new SpriteSheet(ImageHandler.loadImage("resources/textures/tiles.png"));
		playerSpriteSheet = new SpriteSheet(ImageHandler.loadImage("resources/textures/player.png"));
		
		player = playerSpriteSheet.crop(0, 0);
		stone = tiles.crop(0, 0);
		dirt = tiles.crop(1, 0);
		
	}
	
}

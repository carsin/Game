package dev.rzebt52.main.tiles;

import java.awt.image.BufferedImage;

public abstract class Tile {

	public static Tile tiles[] = new Tile[256];
	
	// public static Tile dirt = new DirtTile(1);
	
	protected BufferedImage texture;
	
	public Tile(int id, BufferedImage texture) {
		
		tiles[id] = this;
		updateTexture(texture);
		
	}
	
	public void updateTexture(BufferedImage texture) {
		
		this.texture = texture;
		
	}
	
}

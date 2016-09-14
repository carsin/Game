package dev.rzebt52.main.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.rzebt52.main.graphics.Assets;
import dev.rzebt52.main.tiles.tiles.*;

public abstract class Tile {

	public static Tile[] tiles = new Tile[256];
	public static Tile air = new Air(0);
	public static Tile stone = new Stone(1);
	public static Tile dirt = new Dirt(2);

	protected BufferedImage texture;
	protected int id;

	public Tile(int id, BufferedImage texture) {

		this.id = id;
		this.texture = texture;

		tiles[id] = this;

	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, Assets.DRAWSIZE, Assets.DRAWSIZE, null);
	}

	public static Tile getTile(int id) {
		if (id == -1) {
			return null;
		}
		if (tiles[id] != null) {
			return tiles[id];
		}
		return tiles[0];
	}

	public int getId() {
		return id;
	}

	public abstract boolean wallIsSolid();

}

package dev.rzebt52.main.tiles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.rzebt52.main.graphics.Assets;
import dev.rzebt52.main.tiles.tiles.Stone;
import dev.rzebt52.main.tiles.tiles.Test1;

public abstract class Tile {

	public static Tile tiles[] = new Tile[256];
	public static Tile stone = new Stone(0);
	public static Tile test1 = new Test1(1);

	// public static Tile dirt = new DirtTile(1);

	protected BufferedImage texture;
	protected boolean wall;
	protected int id;

	public Tile(int id, BufferedImage texture) {

		this.id = id;
		this.texture = texture;

		tiles[id] = this;

	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, Assets.DRAWSIZE, Assets.DRAWSIZE, null);
		if (wall) {
			g.setColor(Color.BLACK);
			g.drawRect(x, y, Assets.DRAWSIZE, Assets.DRAWSIZE);
		}
	}

	public static Tile getTile(int id) {
		if (tiles[id] != null) {
			return tiles[id];
		}
		return tiles[0];
	}

	public boolean isWall() {
		return wall;
	}

	public void setWall(boolean wall) {
		this.wall = wall;
	}

}

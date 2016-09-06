package dev.rzebt52.main.world;

import java.awt.Color;
import java.awt.Graphics;

import dev.rzebt52.main.graphics.Assets;
import dev.rzebt52.main.tiles.Tile;
import dev.rzebt52.main.util.Util;

public class Region {

	public static int REGIONSIZE = 8;

	private int tiles[][];
	private int worldX;
	private int worldY;
	private int worldZ;

	public Region(int worldX, int worldY, int worldZ, String path) {

		this.worldX = worldX;
		this.worldY = worldY;
		this.worldZ = worldZ;

		loadRegion(path + "regions/" + worldX + "_" + worldY + "_" + worldZ + ".region");

	}

	public int getTile(int x, int y) {
		try {
			if (tiles[x][y] != -1)
				return tiles[x][y];
		} catch (ArrayIndexOutOfBoundsException e) {
			return -1;
		}
		return -1;
	}

	public void loadRegion(String path) {

		String regionFile = Util.loadFile(path);
		String[] tokens = regionFile.split("\\s+");

		tiles = new int[REGIONSIZE][REGIONSIZE];

		for (int x = 0; x < REGIONSIZE; x++) {
			for (int y = 0; y < REGIONSIZE; y++) {
				tiles[x][y] = Util.parseInt(tokens[(x + y * REGIONSIZE)]);
			}
		}
	}

	public void tick() {

	}

	public void render(Graphics g) {
		for (int x = 0; x < REGIONSIZE; x++) {
			for (int y = 0; y < REGIONSIZE; y++) {
				Tile.getTile(tiles[x][y]).render(g, (x + worldX * REGIONSIZE) * Assets.DRAWSIZE,
						(y + worldY * REGIONSIZE) * Assets.DRAWSIZE);
				if (worldZ == 1 && Tile.getTile(tiles[x][y]).wallIsSolid()) {
					g.setColor(Color.BLACK);
					g.drawRect(x * Assets.DRAWSIZE, y * Assets.DRAWSIZE, Assets.DRAWSIZE, Assets.DRAWSIZE);
				}
			}
		}
	}

	public int getWorldX() {
		return worldX;
	}

	public int getWorldY() {
		return worldY;
	}

	public int getWorldZ() {
		return worldZ;
	}

}

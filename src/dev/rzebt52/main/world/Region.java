package dev.rzebt52.main.world;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import dev.rzebt52.main.graphics.Assets;
import dev.rzebt52.main.tiles.Tile;
import dev.rzebt52.main.util.Util;

public class Region {

	public static int REGIONSIZE = 8;

	private int tiles[][];
	private int worldX;
	private int worldY;

	public Region(int worldX, int worldY, String path) {

		this.worldX = worldX;
		this.worldY = worldY;

		loadRegion(path + "regions/" + worldX + "_" + worldY + ".region");

	}

	public int getTile(int x, int y) {
		return tiles[x][y];
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
				Tile.getTile(tiles[x][y]).render(g, (x + worldX * REGIONSIZE) * Assets.DRAWSIZE, (y + worldY * REGIONSIZE) * Assets.DRAWSIZE);
				Tile.getTile(tiles[x][y]).setWall(true);
			}
		}
	}

	public int getWorldX() {
		return worldX;
	}

	public int getWorldY() {
		return worldY;
	}

}

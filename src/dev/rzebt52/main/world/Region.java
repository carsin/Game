package dev.rzebt52.main.world;

import java.awt.Graphics;

import dev.rzebt52.main.Conveyor;
import dev.rzebt52.main.graphics.Assets;
import dev.rzebt52.main.tiles.Tile;
import dev.rzebt52.main.util.Util;

public class Region {

	public static final int REGIONSIZE = 8;
	public static final int REGIONHEIGHT = 2;

	private int tiles[][][];
	private int worldX;
	private int worldY;
	private Conveyor conveyor;

	public Region(int worldX, int worldY, String path, Conveyor conveyor) {

		this.worldX = worldX;
		this.worldY = worldY;
		this.conveyor = conveyor;

		loadRegion(path + "regions/" + worldX + "_" + worldY + ".region");

	}

	public int getTile(int x, int y, int z) {
		try {
			return tiles[x][y][z];
		} catch (ArrayIndexOutOfBoundsException e) {
			return -1;
		}
	}

	public void loadRegion(String path) {

		String regionFile = Util.loadFile(path);
		String[] tokens = regionFile.split("\\s+");

		tiles = new int[REGIONSIZE][REGIONSIZE][REGIONHEIGHT];

		for (int z = 0; z < REGIONHEIGHT; z++) {
			for (int y = 0; y < REGIONSIZE; y++) {
				for (int x = 0; x < REGIONSIZE; x++) {
					tiles[x][y][z] = Util.parseInt(tokens[(x + y * REGIONSIZE + z * REGIONSIZE * REGIONSIZE)]);
				}
			}
		}
	}

	public void tick() {

	}

	public void render(Graphics g) {
		for (int x = 0; x < REGIONSIZE; x++) {
			for (int y = 0; y < REGIONSIZE; y++) {
				for (int z = 0; z < REGIONHEIGHT; z++) {
					Tile.getTile(tiles[x][y][z]).render(g,
							(x + worldX * REGIONSIZE) * Assets.DRAWSIZE - conveyor.getCamera().getxOffset(),
							(y + worldY * REGIONSIZE) * Assets.DRAWSIZE - conveyor.getCamera().getyOffset());
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

}

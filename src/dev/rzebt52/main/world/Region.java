package dev.rzebt52.main.world;

import java.awt.Graphics;
import java.util.Random;

import dev.rzebt52.main.Conveyor;
import dev.rzebt52.main.graphics.Assets;
import dev.rzebt52.main.tiles.Tile;
import dev.rzebt52.main.util.Util;

public class Region {

	public static final int REGIONSIZE = 8;
	public static final int REGIONHEIGHT = 2;
	public static final int REGIONUNLOADDISTANCE = 4;

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
			return 0;
		}
	}

	public void loadRegion(String path) {

		String regionFile = Util.loadFile(path);

		if (regionFile != "" && regionFile != null) {
			String[] tokens = regionFile.split("\\s+");

			tiles = new int[REGIONSIZE][REGIONSIZE][REGIONHEIGHT];

			for (int z = 0; z < REGIONHEIGHT; z++) {
				for (int y = 0; y < REGIONSIZE; y++) {
					for (int x = 0; x < REGIONSIZE; x++) {
						tiles[x][y][z] = Util.parseInt(tokens[(x + y * REGIONSIZE + z * REGIONSIZE * REGIONSIZE)]);
					}
				}
			}
		} else {
			tiles = new int[REGIONSIZE][REGIONSIZE][REGIONHEIGHT];

			for (int z = 0; z < REGIONHEIGHT; z++) {
				for (int y = 0; y < REGIONSIZE; y++) {
					for (int x = 0; x < REGIONSIZE; x++) {
						if (z == 0) {
							tiles[x][y][z] = new Random().nextInt(2) + 1;
						} else {
							tiles[x][y][z] = 0;
						}
					}
				}
			}
		}
	}

	public void tick() {
		
		int z = 0;

		for (int x = 0; x < REGIONSIZE; x++) {
			for (int y = 0; y < REGIONSIZE; y++) {
					Random r = new Random();
					int randNumber = r.nextInt(10000);
					if (randNumber == 5000) {
						if (getTile(x, y, z) == Tile.grass.getId()) {
							if (getTile(x - 1, y, z) == Tile.dirt.getId() || getTile(x + 1, y, z) == Tile.dirt.getId() || getTile(x, y - 1, z) == Tile.dirt.getId() || getTile(x, y + 1, z) == Tile.dirt.getId()) {
								tiles[x][y][z] = Tile.grass.getId();
						}
					}
				}
			}
		}

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

	/*
	 * public boolean isTouching(int tileX, int tileY, int tileZ, int id) { for
	 * (int x = 0; x < REGIONSIZE; x++) { for (int y = 0; y < REGIONSIZE; y++) {
	 * for (int z = 0; z < REGIONHEIGHT; z++) { if () } } } }
	 */

	public int getWorldX() {
		return worldX;
	}

	public int getWorldY() {
		return worldY;
	}

}

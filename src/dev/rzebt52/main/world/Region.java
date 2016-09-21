package dev.rzebt52.main.world;

import java.awt.Color;
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

	public void getTileAndPrint(int x, int y, int z) {
		try {
			System.out.println("Found tile " + tiles[x][y][z] + " at x:" + x + ", y:" + y + ", z:" + z);

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Out of bounds, 0");
		}
	}
	
	public void setTile(int x, int y, int z, int t) {
		tiles[x][y][z] = t;
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
							tiles[x][y][z] = 6;
						} else {
							if (new Random().nextInt(10) == 0) {
								tiles[x][y][z] = new Random().nextInt(2) + 1;
							} else {
								tiles[x][y][z] = 0;
							}
						}
					}
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
		for (int x = 0; x < REGIONSIZE; x++) {
			for (int y = 0; y < REGIONSIZE; y++) {
				for (int z = 0; z < REGIONHEIGHT; z++) {
					int worldPixelsX = worldX * REGIONSIZE * Assets.DRAWSIZE;
					int worldPixelsY = worldY * REGIONSIZE * Assets.DRAWSIZE;
					int worldPosX = worldX * REGIONSIZE;
					int worldPosY = worldY * REGIONSIZE;
					if (z == 1) {
						g.setColor(Color.BLACK);
						World world = conveyor.getWorld();
						boolean currentTile, tileUp, tileDown, tileLeft, tileRight;
						currentTile = Tile.getTile(getTile(x, y, z)).wallIsSolid();
						try {
							tileUp = Tile.getTile(world.getTile(x + worldPosX, y - 1 + worldPosY, z)).wallIsSolid();
						} catch (NullPointerException e) {
							tileUp = false;
						}
						try {
							tileDown = Tile.getTile(world.getTile(x + worldPosX, y + 1 + worldPosY, z)).wallIsSolid();
						} catch (NullPointerException e) {
							tileDown = false;
						}
						try {
							tileLeft = Tile.getTile(world.getTile(x - 1 + worldPosX, y + worldPosY, z)).wallIsSolid();
						} catch (NullPointerException e) {
							tileLeft = false;
						}
						try {
							tileRight = Tile.getTile(world.getTile(x + 1 + worldPosX, y + worldPosY, z)).wallIsSolid();
						} catch (NullPointerException e) {
							tileRight = false;
						}
						int coordX = x * Assets.DRAWSIZE - conveyor.getCamera().getxOffset() + worldPixelsX;
						int coordY = y * Assets.DRAWSIZE - conveyor.getCamera().getyOffset() + worldPixelsY;
						if (!currentTile) {
							if (tileUp)
								g.drawLine(coordX, coordY, coordX + Assets.DRAWSIZE - 1, coordY);
							if (tileDown)
								g.drawLine(coordX, coordY + Assets.DRAWSIZE - 1, coordX + Assets.DRAWSIZE - 1,
										coordY + Assets.DRAWSIZE - 1);
							if (tileLeft)
								g.drawLine(coordX, coordY, coordX, coordY + Assets.DRAWSIZE - 1);
							if (tileRight)
								g.drawLine(coordX + Assets.DRAWSIZE - 1, coordY, coordX + Assets.DRAWSIZE - 1,
										coordY + Assets.DRAWSIZE - 1);
						}
					}
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

package dev.rzebt52.main.world;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import dev.rzebt52.main.Conveyor;
import dev.rzebt52.main.util.Util;

public class World {

	private ArrayList<Region> regions;
	private String path;
	private Conveyor conveyor;
	private long seed;
	private Random generator;

	public World(String path, long seed, Conveyor conveyor) {

		this.path = path;
		this.seed = seed;
		this.conveyor = conveyor;
		generator = new Random(seed);

		regions = new ArrayList<Region>();

	}
	
	public World(String path, Conveyor conveyor) {

		this.path = path;
		this.conveyor = conveyor;
		generator = new Random(seed);

		regions = new ArrayList<Region>();

	}

	public void loadWorld() {
		String worldFile = Util.loadFile(path);
		String[] tokens = worldFile.split("\\s+");
		for (int i = 0; i < tokens.length; i++) {
			
			String[] token = tokens[i].split("=");
			String id = token[0];
			String value = token[1];
			
			switch (id) {
			case "seed":
				seed = Util.parseInt(value);
			}
		}
	}

	public void loadRegion(int regionX, int regionY) {
		regions.add(new Region(regionX, regionY, path, conveyor));
	}

	public void unloadRegion(int regionX, int regionY) {
		Iterator<Region> iterator = regions.iterator();
		while (iterator.hasNext()) {
			Region r = iterator.next();
			if (r.getWorldX() == regionX && r.getWorldY() == regionY) {
				regions.remove(r);
			}
		}
	}

	public void unloadRegion(Region r) {
		regions.remove(r);
	}

	public void tick() {
		for (int i = 0; i < regions.size(); i++) {
			Region r = regions.get(i);
			r.tick();
		}

	}

	public void render(Graphics g) {
		for (Region r : regions) {
			r.render(g);
		}
	}

	public Region getRegion(int x, int y) {
		for (Region r : regions) {
			if (r.getWorldX() == x && r.getWorldY() == y) {
				return r;
			}
		}
		return null;
	}

	public int getTile(int x, int y, int z) {
		int regionX;
		int regionY;
		if(x >= 0) {
			regionX = (int) Math.floor(x / Region.REGIONSIZE);
		} else {
			regionX = (int) Math.ceil(x / Region.REGIONSIZE) - 1;
		}
		if(x >= 0) {
			regionY = (int) Math.floor(y / Region.REGIONSIZE);
		} else {
			regionY = (int) Math.ceil(y / Region.REGIONSIZE) - 1;
		}
		Region r = getRegion(regionX, regionY);
		try {
			int t = r.getTile(x - r.getWorldX() * Region.REGIONSIZE, y - r.getWorldY() * Region.REGIONSIZE, z);
			return t;
		} catch (NullPointerException e) {
			return -1;
		}
	}
	
	public void setTile(int x, int y, int z, int t) {
		int regionX;
		int regionY;
		if(x >= 0) {
			regionX = (int) Math.floor(x / Region.REGIONSIZE);
		} else {
			regionX = (int) Math.ceil(x / Region.REGIONSIZE) + 1;
		}
		if(x >= 0) {
			regionY = (int) Math.floor(y / Region.REGIONSIZE);
		} else {
			regionY = (int) Math.ceil(y / Region.REGIONSIZE) + 1;
		}
		Region r = getRegion(regionX, regionY);
		try {
			r.setTile(x - r.getWorldX() * Region.REGIONSIZE, y - r.getWorldY() * Region.REGIONSIZE, z, t);
		} catch (NullPointerException e) {
		}
	}

	public void getTileAndPrint(int x, int y, int z) {
		Region r;
		int regionX;
		int regionY;
		if (x >= 0)
			regionX = (int) Math.floor(x / Region.REGIONSIZE);
		else
			regionX = (int) Math.ceil(x / Region.REGIONSIZE);
		if (y >= 0)
			regionY = (int) Math.floor(y / Region.REGIONSIZE);
		else
			regionY = (int) Math.ceil(y / Region.REGIONSIZE);
		r = getRegion(regionX, regionY);

		try {
			r.getTileAndPrint(x - r.getWorldX() * Region.REGIONSIZE, y - r.getWorldY() * Region.REGIONSIZE, z);
		} catch (NullPointerException e) {

		}
	}

	public ArrayList<Region> getRegions() {
		return regions;
	}

	public String getPath() {
		return path;
	}

	public long getSeed() {
		return seed;
	}
	
	public Random getGenerator() {
		return generator;
	}

}

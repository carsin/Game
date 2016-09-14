package dev.rzebt52.main.world;

import java.awt.Graphics;
import java.util.ArrayList;

import dev.rzebt52.main.Conveyor;

public class World {

	private ArrayList<Region> regions;
	private String path;
	private Conveyor conveyor;

	public World(String path, Conveyor conveyor) {

		this.path = path;

		regions = new ArrayList<Region>();
		loadRegion(0, 0);

	}

	public void loadRegion(int regionX, int regionY) {
		regions.add(new Region(regionX, regionY, path, conveyor));
	}

	public void unloadRegion(int regionX, int regionY) {
		for (Region r : regions) {
			if (r.getWorldX() == regionX && r.getWorldY() == regionY) {
				regions.remove(r);
			}
		}
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
		Region r = getRegion((int) Math.floor(x / Region.REGIONSIZE), (int) Math.floor(y / Region.REGIONSIZE));
		try {
			int t = r.getTile(x + r.getWorldX() * Region.REGIONSIZE, y + r.getWorldY() * Region.REGIONSIZE, z);
			return t;
		} catch (NullPointerException e) {
			return -1;
			
		}
	}

	public ArrayList<Region> getRegions() {
		return regions;
	}

	public String getPath() {
		return path;
	}

}

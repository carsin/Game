package dev.rzebt52.main.world;

import java.awt.Graphics;
import java.util.ArrayList;

public class World {

	private ArrayList<Region> regions;

	public World(String path) {
		
		regions = new ArrayList<Region>();
		regions.add(new Region(0, 0, 0, path));
		regions.add(new Region(0, 0, 1, path));
		
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
	
	public Region getRegion(int x, int y, int z) {
		for(Region r : regions) {
			if(r.getWorldX() == x && r.getWorldY() == y && r.getWorldZ() == z) {
				return r;
			}
		}
		return null;
	}
	
	public int getTile(int x, int y, int z) {
		Region r = getRegion((int) Math.floor(x / Region.REGIONSIZE), (int) Math.floor(y / Region.REGIONSIZE), z);
		System.out.println((int) Math.floor(x / Region.REGIONSIZE));
		try {
			int t = r.getTile(x + r.getWorldX() * Region.REGIONSIZE, y + r.getWorldY() * Region.REGIONSIZE);
			return t;
		} catch (NullPointerException e) {
			return -1;
		}
		
	}

}

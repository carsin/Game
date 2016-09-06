package dev.rzebt52.main.tiles.tiles;

import dev.rzebt52.main.tiles.Tile;

public class Air extends Tile {

	public Air(int id) {
		super(id, null);
	}

	@Override
	public boolean wallIsSolid() {
		return false;
	}
	
}

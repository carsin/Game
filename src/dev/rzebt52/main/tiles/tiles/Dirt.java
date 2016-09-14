package dev.rzebt52.main.tiles.tiles;

import dev.rzebt52.main.graphics.Assets;
import dev.rzebt52.main.tiles.Tile;

public class Dirt extends Tile {

	public Dirt(int id) {
		super(id, Assets.dirt);
	}

	@Override
	public boolean wallIsSolid() {
		return false;
	}

}

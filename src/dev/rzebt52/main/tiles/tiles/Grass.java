package dev.rzebt52.main.tiles.tiles;

import dev.rzebt52.main.graphics.Assets;
import dev.rzebt52.main.tiles.Tile;

public class Grass extends Tile {

	public Grass(int id) {
		super(id, Assets.grass);
	}

	@Override
	public boolean wallIsSolid() {
		return true;
	}

}

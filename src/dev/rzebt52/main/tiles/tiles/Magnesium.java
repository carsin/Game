package dev.rzebt52.main.tiles.tiles;

import dev.rzebt52.main.graphics.Assets;
import dev.rzebt52.main.tiles.Tile;

public class Magnesium extends Tile {
	public Magnesium(int id) {
		super(id, Assets.magnesium);
	}

	@Override
	public boolean wallIsSolid() {
		return true;
	}
}

package dev.rzebt52.main.tiles.tiles;

import dev.rzebt52.main.graphics.Assets;
import dev.rzebt52.main.tiles.Tile;

public class Leaves extends Tile { 
	public Leaves(int id) {
		super(id, Assets.leaves);
	}

	@Override
	public boolean wallIsSolid() {
		return true;
	}

}

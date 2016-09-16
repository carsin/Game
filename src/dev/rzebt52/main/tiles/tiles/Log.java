package dev.rzebt52.main.tiles.tiles;

import dev.rzebt52.main.graphics.Assets;
import dev.rzebt52.main.tiles.Tile;

public class Log extends Tile {

	public Log(int id) {
		super(id, Assets.log);
	}

	@Override
	public boolean wallIsSolid() {
		return true;
	}

}

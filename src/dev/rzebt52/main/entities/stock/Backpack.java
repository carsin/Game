package dev.rzebt52.main.entities.stock;

import java.awt.Graphics;

import dev.rzebt52.main.Conveyor;
import dev.rzebt52.main.Game;
import dev.rzebt52.main.graphics.Assets;
import dev.rzebt52.main.tiles.Tile;

public class Backpack {

	private Tile currentTile;
	private int hotBarNum;
	private Conveyor conveyor;

	public Backpack(Conveyor conveyor) {

		currentTile = Tile.getTile(3);
		this.conveyor = conveyor;

	}

	public void tick() {
		for (int i = 0; i < 6; i++) {
			if (conveyor.getKeyHandler().getKeys(i + 49)) {		
				setCurrentTile(Tile.getTile(i + 1));
			}
		}
	}

	public void render(Graphics g) {
		g.drawImage(currentTile.getTexture(), Game.WIDTH - 80, Game.HEIGHT - 80, Assets.DRAWSIZE, Assets.DRAWSIZE,
				null);
	}

	public Tile getCurrentTile() {
		return currentTile;
	}

	public void setCurrentTile(Tile currentTile) {
		this.currentTile = currentTile;
	}

}

package dev.rzebt52.main.entities.dynamic;

import dev.rzebt52.main.Conveyor;
import dev.rzebt52.main.entities.Entity;
import dev.rzebt52.main.graphics.Assets;
import dev.rzebt52.main.tiles.Tile;

public abstract class DynamicEntity extends Entity {

	protected float speed;
	protected float xSpeed;
	protected float ySpeed;

	public DynamicEntity(int x, int y, Conveyor conveyor) {

		super(x, y, conveyor);

	}

	protected void move() {

		if (!getCollision(xSpeed, 0)) {
			moveX();
		}

		if (!getCollision(0, ySpeed)) {
			moveY();
		}

	}

	protected void moveX() {
		if (xSpeed < 0) {
			int nextFrame = (int) (x + xSpeed + bounds.x) / Assets.DRAWSIZE;
			if (!getTileCollision(nextFrame, (int) (y + bounds.y) / Assets.DRAWSIZE, 1)
					&& !getTileCollision(nextFrame, (int) (y + bounds.y + bounds.height) / Assets.DRAWSIZE, 1)) {
				x += xSpeed;
			} else {
				x = nextFrame * Assets.DRAWSIZE + Assets.DRAWSIZE - bounds.x + 1;
			}
		} else if (xSpeed > 0) {
			int nextFrame = (int) (x + xSpeed + bounds.x + bounds.width) / Assets.DRAWSIZE;
			if (!getTileCollision(nextFrame, (int) (y + bounds.y) / Assets.DRAWSIZE, 1)
					&& !getTileCollision(nextFrame, (int) (y + bounds.y + bounds.height) / Assets.DRAWSIZE, 1)) {
				x += xSpeed;
			} else {
				x = nextFrame * Assets.DRAWSIZE - bounds.x - bounds.width - 1;
			}
		}
	}

	protected void moveY() {
		if (ySpeed < 0) {
			int nextFrame = (int) (y + ySpeed + bounds.y) / Assets.DRAWSIZE;
			if (!getTileCollision((int) (x + bounds.x) / Assets.DRAWSIZE, nextFrame, 1)
					&& !getTileCollision((int) (x + bounds.x + bounds.width) / Assets.DRAWSIZE, nextFrame, 1)) {
				y += ySpeed;
			} else {
				y = nextFrame * Assets.DRAWSIZE + Assets.DRAWSIZE - bounds.y + 1;
			}
		} else if (ySpeed > 0) {
			int nextFrame = (int) (y + ySpeed + bounds.y + bounds.height) / Assets.DRAWSIZE;
			if (!getTileCollision((int) (x + bounds.x) / Assets.DRAWSIZE, nextFrame, 1)
					&& !getTileCollision((int) (x + bounds.x + bounds.width) / Assets.DRAWSIZE, nextFrame, 1)) {
				y += ySpeed;
			} else {
				y = nextFrame * Assets.DRAWSIZE - bounds.y - bounds.height - 1;
			}
		}
	}

	public boolean getTileCollision(int x, int y, int z) {
		Tile t = Tile.getTile(conveyor.getWorld().getTile(x, y, z));
		if(conveyor.getWorld().getTile(x, y, z) != -1)
			return t.wallIsSolid();
		return true;
	}
}

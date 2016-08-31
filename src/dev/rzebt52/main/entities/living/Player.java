package dev.rzebt52.main.entities.living;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import dev.rzebt52.main.Conveyor;
import dev.rzebt52.main.graphics.Assets;
import dev.rzebt52.main.input.KeyHandler;

public class Player extends Living {

	public Player(int x, int y, Conveyor conveyor) {

		super(x, y, conveyor);
		speed = 2;
		traction = 0.3f;
		
		boundsX = 3 * Assets.RESOLUTION;
		boundsY = 3 * Assets.RESOLUTION;
		boundsWidth = 3 * Assets.RESOLUTION;
		boundsHeight = 3 * Assets.RESOLUTION;
		
		updateBounds();
		
	}

	public void getControls() {

		KeyHandler keyHandler = conveyor.getKeyHandler();

		if (keyHandler.getKeys(KeyEvent.VK_W)) {
			ySpeed = -speed;
		}

		if (keyHandler.getKeys(KeyEvent.VK_S)) {
			ySpeed = speed;
		}

		else if (!keyHandler.getKeys(KeyEvent.VK_W) && !keyHandler.getKeys(KeyEvent.VK_S)) {
			ySpeed = 0;
		}
		
		if (keyHandler.getKeys(KeyEvent.VK_A)) {
			xSpeed = -speed;
		}
		
		if (keyHandler.getKeys(KeyEvent.VK_D)) {
			xSpeed = speed;
		}
		
		else if (!keyHandler.getKeys(KeyEvent.VK_A) && !keyHandler.getKeys(KeyEvent.VK_D)) {
			xSpeed = 0;
		}

	}

	@Override
	public void tick() {
		getControls();
		move();
	}

	@Override
	public void render(Graphics g) {

		g.drawImage(Assets.test, (int) x, (int) y, (int) width, (int) height, null);

	}

}

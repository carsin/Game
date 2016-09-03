package dev.rzebt52.main.entities.dynamic;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import dev.rzebt52.main.Conveyor;
import dev.rzebt52.main.graphics.Assets;
import dev.rzebt52.main.input.KeyHandler;

public class Player extends DynamicEntity {

	private boolean controlled;
	
	public Player(int x, int y, boolean controlled, Conveyor conveyor) {

		super(x, y, conveyor);
		this.controlled = controlled;
		
		speed = 5;
		
		bounds.setBounds(3 * Assets.DRAWRES, 4, 4 * Assets.DRAWRES, 4 * Assets.DRAWRES);
		
	}

	public void getControls() {

		KeyHandler keyHandler = conveyor.getKeyHandler();

		if (keyHandler.getKeys(KeyEvent.VK_W) && !keyHandler.getKeys(KeyEvent.VK_S)) {
			ySpeed = -speed;
		}

		else if (keyHandler.getKeys(KeyEvent.VK_S) && !keyHandler.getKeys(KeyEvent.VK_W)) {
			ySpeed = speed;
		}
		
		else {
			ySpeed = 0;
		}
		
		if (keyHandler.getKeys(KeyEvent.VK_A) && !keyHandler.getKeys(KeyEvent.VK_D)) {
			xSpeed = -speed;
		}

		else if (keyHandler.getKeys(KeyEvent.VK_D) && !keyHandler.getKeys(KeyEvent.VK_A)) {
			xSpeed = speed;
		}
		
		else {
			xSpeed = 0;
		}

	}

	@Override
	public void tick() {
		if(controlled) {
			getControls();
		}
		move();
	}

	@Override
	public void render(Graphics g) {

		g.drawImage(Assets.player, (int) x, (int) y, width, height, null);

	}

}

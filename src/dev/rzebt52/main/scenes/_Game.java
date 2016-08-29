package dev.rzebt52.main.scenes;

import java.awt.Color;
import java.awt.Graphics;

import dev.rzebt52.main.Conveyor;
import dev.rzebt52.main.graphics.Assets;

public class _Game extends Scene {
	
	public _Game(Conveyor conveyor) {
		super(conveyor);
	}

	public void tick() {
		
	}

	public void render(Graphics g) {
		
		g.setColor(Color.LIGHT_GRAY);
		g.drawImage(Assets.test, 100, 100, Assets.DRAW_SIZE, Assets.DRAW_SIZE, null);
		g.drawString("FPS: " + conveyor.getGame().getFrames() + " TPS: " + conveyor.getGame().getTicks(), 10, 20);
		
	}
	
}

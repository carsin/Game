package dev.rzebt52.scenes;

import java.awt.Color;
import java.awt.Graphics;

import dev.rzebt52.main.Conveyor;

public class _Game extends Scene {
	
	public _Game(Conveyor conveyor) {
		super(conveyor);
	}

	public void tick() {
		
	}

	public void render(Graphics g) {
		
		g.setColor(Color.LIGHT_GRAY);
		g.drawString("FPS: " + conveyor.getGame().getFrames() + " TPS: " + conveyor.getGame().getTicks(), 10, 20);
		
	}
	
}

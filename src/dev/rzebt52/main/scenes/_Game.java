package dev.rzebt52.main.scenes;

import java.awt.Color;
import java.awt.Graphics;

import dev.rzebt52.main.Conveyor;
import dev.rzebt52.main.entities.living.Player;
import dev.rzebt52.main.graphics.Assets;

public class _Game extends Scene {
	
	Player player;
	
	public _Game(Conveyor conveyor) {
		super(conveyor);
		player = new Player(20, 20, conveyor);
	}

	public void tick() {
		player.tick();
	}

	public void render(Graphics g) {
		
		g.setColor(Color.LIGHT_GRAY);
		g.drawImage(Assets.test, 100, 100, Assets.DRAW_SIZE, Assets.DRAW_SIZE, null);
		player.render(g);
		g.drawImage(Assets.test, 100, 100, Assets.DRAW_SIZE, Assets.DRAW_SIZE, null);
		
	}
	
}

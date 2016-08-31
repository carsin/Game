package dev.rzebt52.main.scenes;

import java.awt.Graphics;

import dev.rzebt52.main.Conveyor;
import dev.rzebt52.main.entities.EntityHandler;
import dev.rzebt52.main.entities.living.Player;

public class _Game extends Scene {
	
	private EntityHandler entityHandler;
	
	public _Game(Conveyor conveyor) {
		super(conveyor);
		entityHandler = new EntityHandler(conveyor);
		entityHandler.add(new Player(100, 100, false, conveyor));
		entityHandler.add(new Player(20, 20, true, conveyor));
	}

	public void tick() {
		entityHandler.tick();
	}

	public void render(Graphics g) {
		entityHandler.render(g);
	}
	
	public EntityHandler getEntityHandler() {
		return entityHandler;
	}
	
}

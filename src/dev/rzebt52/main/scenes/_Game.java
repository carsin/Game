package dev.rzebt52.main.scenes;

import java.awt.Graphics;

import dev.rzebt52.main.Conveyor;
import dev.rzebt52.main.entities.EntityHandler;
import dev.rzebt52.main.entities.dynamic.Player;
import dev.rzebt52.main.world.World;

public class _Game extends Scene {
	
	private EntityHandler entityHandler;
	private World world;
	
	public _Game(Conveyor conveyor) {
		super(conveyor);
		world = new World("resources/worlds/world1/");
		entityHandler = new EntityHandler(conveyor);
		entityHandler.add(new Player(100, 100, false, conveyor));
		entityHandler.add(new Player(20, 20, true, conveyor));
	}

	public void tick() {
		world.tick();
		entityHandler.tick();
	}

	public void render(Graphics g) {
		world.render(g);
		entityHandler.render(g);
	}
	
	public EntityHandler getEntityHandler() {
		return entityHandler;
	}
	
	public World getWorld() {
		return world;
	}
	
}

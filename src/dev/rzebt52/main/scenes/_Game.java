package dev.rzebt52.main.scenes;

import java.awt.Graphics;

import dev.rzebt52.main.Conveyor;
import dev.rzebt52.main.entities.EntityHandler;
import dev.rzebt52.main.entities.dynamic.Player;
import dev.rzebt52.main.graphics.camera.Camera;
import dev.rzebt52.main.world.World;

public class _Game extends Scene {

	private EntityHandler entityHandler;
	private World world;
	private Camera camera;
	private Player player;

	public _Game(Conveyor conveyor) {
		super(conveyor);
		world = new World("resources/worlds/world1/", conveyor);
		camera = new Camera(100, 100);
		entityHandler = new EntityHandler(conveyor);
		player = new Player(100, 100, true, conveyor);
		entityHandler.add(player);
		camera.centerOnEntity(player);
	}

	public void tick() {
		world.tick();
		entityHandler.tick();
		camera.tick();
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
	
	public Camera getCamera() {
		return camera;
	}

}

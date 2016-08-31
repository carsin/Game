package dev.rzebt52.main.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import dev.rzebt52.main.Conveyor;

public class EntityHandler {

	private ArrayList<Entity> entities;
	private Conveyor conveyor;

	public EntityHandler(Conveyor conveyor) {
		this.conveyor = conveyor;
		entities = new ArrayList<Entity>();
	}

	public void tick() {
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.tick();
		}
	}

	public void render(Graphics g) {
		for (Entity e : entities) {
			e.render(g);
		}
	}

	public void add(Entity e) {
		entities.add(e);
	}

	public void remove(Entity e) {
		entities.remove(e);
	}
	
	public ArrayList<Entity> getEntities() {
		return entities;
	}

}

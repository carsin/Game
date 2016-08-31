package dev.rzebt52.main.scenes;

import java.awt.Graphics;

import dev.rzebt52.main.Conveyor;

public abstract class Scene {

	public Conveyor conveyor;

	public Scene(Conveyor conveyor) {
		this.conveyor = conveyor;
	}

	public static Scene currentScene;

	public static void setScene(Scene scene) {
		currentScene = scene;
	}

	public static Scene getCurrentScene() {
		return currentScene;
	}

	public abstract void tick();

	public abstract void render(Graphics g);

}

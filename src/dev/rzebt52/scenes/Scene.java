package dev.rzebt52.scenes;

import java.awt.Graphics;

public abstract class Scene {

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

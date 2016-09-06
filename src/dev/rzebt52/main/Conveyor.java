package dev.rzebt52.main;

import java.awt.Canvas;

import javax.swing.JFrame;

import dev.rzebt52.main.entities.EntityHandler;
import dev.rzebt52.main.input.KeyHandler;
import dev.rzebt52.main.world.World;

public class Conveyor {

	public Game game;
	
	public Conveyor(Game game) {
		this.game = game;
	}
	
	public Game getGame(){
		return game;
	}
	
	public KeyHandler getKeyHandler() {
		return game.getKeyHandler();
	}
	
	public JFrame getFrame() {
		return game.getFrame();
	}
	
	public Canvas getCanvas() {
		return game.getCanvas();
	}
	
	public EntityHandler getEntityHandler() {
		return game._game.getEntityHandler();
	}
	
	public World getWorld() {
		return game._game.getWorld();
	}

}

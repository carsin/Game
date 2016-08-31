package dev.rzebt52.main.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import dev.rzebt52.main.Conveyor;

public class KeyHandler implements KeyListener {

	@SuppressWarnings("unused")
	private Conveyor conveyor;
	private boolean keys[];
	
	public KeyHandler(Conveyor conveyor) {
		
		this.conveyor = conveyor;
		
		keys = new boolean[1024];
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		keys[e.getKeyCode()] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		keys[e.getKeyCode()] = false;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	public boolean getKeys(int key) {

		return keys[key];
		
	}

}

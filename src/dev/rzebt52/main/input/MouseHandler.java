package dev.rzebt52.main.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener {

	private int mouseX = 0;
	private int mouseY = 0;
	private boolean mouseIn;
	private boolean mouseOut;
	private boolean[] clicked;
	private boolean[] pressed;
	
	public MouseHandler() {
		
		clicked = new boolean[4];
		pressed = new boolean[4];
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int button = e.getButton();
		pressed[button] = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int button = e.getButton();
		pressed[button] = false;
	}

	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	public boolean isMouseIn() {
		return mouseIn;
	}

	public boolean isMouseOut() {
		return mouseOut;
	}
	
	public boolean getPressed(int button) {
		return pressed[button];
	}
 
	public boolean getClicked(int button) {
		return clicked[button];
	}
	
}

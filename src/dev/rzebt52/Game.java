package dev.rzebt52;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game implements Runnable {

	public static final int WIDTH = 1366;
	public static final int HEIGHT = 768;
	public static final String NAME = "Game";
	
	public Thread thread;
	public boolean running;
	
	private Canvas canvas;
	private JFrame frame;

	public Game() {
		
		frame = new JFrame(NAME);
		canvas = new Canvas();
		
		canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(canvas, BorderLayout.CENTER);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void run() {

		int maxTps = 120;
		int maxFps = 60;
		double timePerTick = 1000000000 / maxTps;
		double timePerFrame = 1000000000 / maxFps;
		double deltaTicks = 0;
		double deltaFrames = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		int frames = 0;

		while (running) {
			now = System.nanoTime();
			deltaTicks += (now - lastTime) / timePerTick;
			deltaFrames += (now - lastTime) / timePerFrame;
			timer += now - lastTime;
			lastTime = now;
			
			if (deltaTicks >= 1) {
				
				tick();
				ticks++;
				deltaTicks--;
				
			}
			
			if (deltaFrames >= 1) {
				
				render();
				frames++;
				deltaFrames--;
				
			}
			
			if (timer >= 1000000000) {
				
				System.out.println("TPS: " + ticks + " FPS: " + frames);
				
				ticks = 0;
				frames = 0;
				timer = 0;
				
			}
			
		}

	}
	
	public synchronized void start() {
		
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	public synchronized void stop() {
		
		running = false;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void tick() {

	}
	
	public void render() {
		BufferStrategy bs = canvas.getBufferStrategy();
		if (bs == null) {
			canvas.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		//Creating background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		new Game().start();
	}

}

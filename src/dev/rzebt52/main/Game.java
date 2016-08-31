package dev.rzebt52.main;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import dev.rzebt52.main.graphics.Assets;
import dev.rzebt52.main.input.KeyHandler;
import dev.rzebt52.main.scenes.Scene;
import dev.rzebt52.main.scenes._Game;

public class Game implements Runnable {

	public static final int WIDTH = 1366;
	public static final int HEIGHT = 768;
	public static final String NAME = "Game";

	private Thread thread;
	private boolean running;

	private Canvas canvas;
	private JFrame frame;
	
	private Conveyor conveyor;
	private KeyHandler keyHandler;

	int ticks = 0;
	int frames = 0;
	
	// SCENES //

	public _Game _game;

	// SCENES //

	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	private int tickCount = 0;
	
	private void initFrame() {
		
		frame = new JFrame(NAME);
		canvas = new Canvas();

		canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		canvas.setFocusable(false);

		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(canvas, BorderLayout.CENTER);
		frame.setResizable(false);
		frame.setFocusable(true);
		frame.addKeyListener(keyHandler);
		frame.setLocationRelativeTo(null);
		frame.requestFocus();
		frame.pack();
		frame.setVisible(true);
		
	}

	private void init() {
		
		conveyor = new Conveyor(this);
		keyHandler = new KeyHandler(conveyor);
		Assets.update();
		initFrame();

		// INITIALIZE SCENES // 

		_game = new _Game(conveyor);

		// INITIALIZE SCENES // 

		Scene.setScene(_game);
		
	}

	@Override
	public void run() {

		int maxTps = 60;
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

		init();

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

				this.ticks = ticks;
				this.frames = frames;
				
				ticks = 0;
				frames = 0;
				timer = 0;

			}

		}

		stop();

	}

	private synchronized void start() {

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

	private void tick() {
		
		tickCount++;

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = i + tickCount + tickCount;
		}

		Scene.getCurrentScene().tick();

	}

	private void render() {
		
		BufferStrategy bs = canvas.getBufferStrategy();
		if (bs == null) {
			canvas.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		// BACKGROUND //
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);

//		g.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
		Scene.getCurrentScene().render(g);

		g.dispose();
		bs.show();

	}

	public static void main(String[] args) {
		new Game().start();
	}

	// GETTERS AND SETTERS //

	public int getTicks() {
		return ticks;
	}

	public int getFrames() {
		return frames;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public KeyHandler getKeyHandler() {
		return keyHandler;
	}

}

package main;

import gui.GuiManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel implements Runnable {

	private ArrayList<ITickable> updateList = new ArrayList<ITickable>();
	private ArrayList<ITickable> tempUpdateList = new ArrayList<ITickable>();
	private DrawManager drawManager = new DrawManager();

	public static InputManager inputManager;

	private GuiManager guiManager;
	private SnakeGame snakeGame;

	private JFrame frame;
	private Thread thread;

	private static final long serialVersionUID = 1L;

	private boolean running;
	private long lastTick;
	private long delta;
	static boolean started = false;

	public Game(JFrame frame) {
		inputManager = new InputManager();
		this.frame = frame;
		this.guiManager = new GuiManager(this, drawManager);

		this.frame.addKeyListener(inputManager);
		this.addMouseListener(inputManager);
		this.addMouseMotionListener(inputManager);

		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		this.init();
		while (running) {
			this.doLoop();
			this.calculateDelta();
			this.repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {}
		}
	}

	private void calculateDelta() {
		long currentTime = System.currentTimeMillis();
		delta = currentTime - lastTick;
		lastTick = currentTime;
	}

	private void doLoop() {
		for (ITickable e: updateList) {
			e.update(delta);
		}
		for(ITickable e: tempUpdateList){
			updateList.add(e);
		}
		tempUpdateList = new ArrayList<ITickable>();
	}

	private void init() {
		running = true;
		lastTick = System.currentTimeMillis();

		guiManager.showMainMenu();
	}

	public void startGame() {
		started = true;
		snakeGame = new SnakeGame(this, drawManager);
		snakeGame.reset();
	}

	public GuiManager getGuiManager() {
		return this.guiManager;
	}

	public void closeGame() {
		frame.dispose();
		running = false;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		drawManager.draw(g);

		g.setColor(Color.RED);
		// g.drawString("Delta:" + delta, 20, 20);
	}

	public void addToUpdateList(ITickable tick) {
		tempUpdateList.add(tick);
	}

	public void removeFormUpdateList(ITickable tick) {
		updateList.remove(tick);
	}

	public DrawManager getDrawManager() {
		return this.drawManager;
	}

	public SnakeGame getGame() {
		return snakeGame;
	}

	public static void main(String[] args) {

		JFrame f = new JFrame("Snake!");
		Game g = new Game(f);

		g.setPreferredSize(new Dimension(800, 600));;
		f.setSize(800, 600);
		f.setResizable(false);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(g);

	}

}
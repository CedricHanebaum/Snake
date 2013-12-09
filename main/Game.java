package main;

import gui.GuiManager;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Game implements Runnable {

	private ArrayList<ITickable> updateList = new ArrayList<ITickable>();
	private ArrayList<ITickable> tempUpdateList = new ArrayList<ITickable>();
	private DrawManager drawManager;

	public static InputManager inputManager;

	private GuiManager guiManager;
	private SnakeGame snakeGame;

	private JFrame frame;
	private Thread thread;

	private boolean running;
	private long lastTick;
	private long delta;
	static boolean started = false;

	public Game() {
		this.frame = new JFrame("Snake");
		this.frame.setSize(800, 600);
		this.frame.setResizable(false);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setVisible(true);

		this.drawManager = new DrawManager();
		this.frame.add(drawManager);


		inputManager = new InputManager();
		this.frame.addKeyListener(inputManager);
		this.drawManager.addMouseListener(inputManager);
		this.drawManager.addMouseMotionListener(inputManager);

		this.guiManager = new GuiManager(this, drawManager);

		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		this.init();
		while (running) {
			this.doLoop();
			this.calculateDelta();
			drawManager.draw();
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
		new Game();
	}

}
package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class InputManager implements KeyListener, MouseListener, MouseMotionListener{
	
	private ArrayList<IMouseNoticeable> mouseListeners = new ArrayList<IMouseNoticeable>();
	
	public boolean[] keys = new boolean[256];
	
	public boolean isDown(int keyCode){
		return keys[keyCode];
	}
	
	public void addListener(IMouseNoticeable mN){
		mouseListeners.add(mN);
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
	public void keyTyped(KeyEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {
		for(IMouseNoticeable mN: mouseListeners){
			mN.mouseClicked(e.getPoint());
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {
		for(IMouseNoticeable mN: mouseListeners){
			mN.mouseMoved(e.getPoint());
		}
	}

}

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CatchGame extends JFrame implements KeyListener {
	
	int x = 250;
	int y = 250;
	JPanel p1;
	JPanel p2;
	JPanel p3;
	JPanel p4;
	JPanel p5;
	boolean fin = false;
	boolean close = true;
	
	class MyThread1 extends Thread{
		
		JPanel p = new JPanel();
		long beg;
		long end;
		//blue and orange
		public MyThread1(JPanel p, Color c) {
			this.p.setBounds(p.getX(), p.getY(), 10, 10);
			this.p.setBackground(c);
			p.setVisible(false);
		}
		
		public void run() {
			beg = System.currentTimeMillis();
			x = p1.getX();
			y = p1.getY();
			p.setVisible(true);
			
			if(p.getX() < x)
				p.setBounds(p.getX()+10, p.getY(), 10, 10);
			else if(p.getX() > x)
				p.setBounds(p.getX()-10, p.getY(), 10, 10);
			else if(x == p.getX() && p.getY() >= 10 && p.getY() <= 490) {
					if(p.getY() < y)
						p.setBounds(p.getX(), p.getY()+10, 10, 10);
					else if(p.getY() > y)
						p.setBounds(p.getX(), p.getY()-10, 10, 10);
			}
			while(!(p.getX() == x && p.getY() == y)) {
				if(fin) break;
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				x = p1.getX();
				y = p1.getY();
				if(p.getX() >= 10 && p.getX() <= 490 && p.getX() != x) {
					if(p.getX() < x)
						p.setBounds(p.getX()+10, p.getY(), 10, 10);
					else if(p.getX() > x)
						p.setBounds(p.getX()-10, p.getY(), 10, 10);
					else if(x == p.getX() && p.getY() >= 10 && p.getY() <= 490) {
							if(p.getY() < y)
								p.setBounds(p.getX(), p.getY()+10, 10, 10);
							else if(p.getY() > y)
								p.setBounds(p.getX(), p.getY()-10, 10, 10);
							else {
								fin = true;
								System.out.println("beg" + beg + "end" + end);
								break;
							}
					}
				}
				else {
					if(p.getY() < y && p.getY()+10 <= 500)
						p.setBounds(p.getX(), p.getY()+10, 10, 10);
					else if(p.getY() > y && p.getY()-10 >= 0)
						p.setBounds(p.getX(), p.getY()-10, 10, 10);
					else {
						fin = true;
						break;
					}
				}
			}
			end = System.currentTimeMillis();
			if(close) {	
				JFrame score = new JFrame();
				JLabel label = new JLabel("Skorunuz: " + (end-beg)/1000);
				score.setSize(300, 300);
				score.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				score.add(label);
				dispose();
				score.setVisible(true);
			}
		}
		
	}
	
	class MyThread2 extends Thread{
		
		JPanel p = new JPanel();
		long beg;
		long end;
		//green and red
		public MyThread2(JPanel p, Color c) {
			this.p = p;
			this.p.setBackground(c);
			p.setVisible(false);
		}
		
		public void run() {
			beg = System.currentTimeMillis();
			x = p1.getX();
			y = p1.getY();
			p.setVisible(true);
			
			if(p.getY() < y)
				p.setBounds(p.getX(), p.getY()+10, 10, 10);
			else if(p.getY() > y)
				p.setBounds(p.getX(), p.getY()-10, 10, 10);
			else if(y == p.getY() && p.getX() >= 10 && p.getX() <= 490) {
					if(p.getX() < x)
						p.setBounds(p.getX()+10, p.getY(), 10, 10);
					else if(p.getY() > y)
						p.setBounds(p.getX()-10, p.getY(), 10, 10);
			}
			
			while(!(p.getX() == x && p.getY() == y)) {
				if(fin) break;
				
				try {
					Thread.sleep(750);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				x = p1.getX();
				y = p1.getY();
				if(p.getY() >= 10 && p.getY() <= 490 && p.getY() != y) {
					if(p.getY() < y)
						p.setBounds(p.getX(), p.getY()+10, 10, 10);
					else if(p.getY() > y)
						p.setBounds(p.getX(), p.getY()-10, 10, 10);
					else if(y == p.getY() && p.getX() >= 10 && p.getX() <= 490) {
							if(p.getX() < x)
								p.setBounds(p.getX()+10, p.getY(), 10, 10);
							else if(p.getY() > y)
								p.setBounds(p.getX()-10, p.getY(), 10, 10);
							else {
								fin = true;
								close = false;
								break;
							}
					}
				}
				else {
					if(p.getX() < x && p.getX()+10 <= 500)
						p.setBounds(p.getX()+10, p.getY(), 10, 10);
					else if(p.getX() > x && p.getX()-10 >= 0)
						p.setBounds(p.getX()-10, p.getY(), 10, 10);
					else {
						fin = true;
						close = false;
						break;
					}
				}
			}
			end = System.currentTimeMillis();
			JFrame score = new JFrame();
			JLabel label = new JLabel("Skorunuz: " + (end-beg)/1000);
			score.setSize(300, 300);
			score.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			score.add(label);
			dispose();
			score.setVisible(true);
		}
	
	}
	
	public CatchGame() {
		
		setSize(510, 547);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p1 = new JPanel();
		p1.setBackground(Color.BLACK);
		p1.setBounds(250, 250, 10, 10);
		p1.addKeyListener(this);
		p2 = new JPanel();
		p2.setBackground(Color.BLUE);
		p2.setBounds(500, 0, 10, 10);
		p3 = new JPanel();
		p3.setBackground(Color.GREEN);
		p3.setBounds(500, 500, 10, 10);
		p4 = new JPanel();
		p4.setBackground(Color.RED);
		p4.setBounds(0, 0, 10, 10);
		p5 = new JPanel();
		p5.setBackground(Color.ORANGE);
		p5.setBounds(0, 500, 10, 10);
		
		addKeyListener(this);
		
		MyThread1 t2 = new MyThread1(p2, Color.BLUE);
		MyThread2 t3 = new MyThread2(p3, Color.GREEN);
		MyThread2 t4 = new MyThread2(p4, Color.RED);
		MyThread1 t5 = new MyThread1(p5, Color.ORANGE);
		
		setLayout(null);
		add(p1);
		
		add(t2.p);
		add(t3.p);
		add(t4.p);
		add(t5.p);
		
		setVisible(true);
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
	

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {
		x = p1.getX();
		y = p1.getY();
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT && x <= 490)
			p1.setBounds(x+10, y, 10, 10);
		else if(key == KeyEvent.VK_LEFT && x >= 10)
			p1.setBounds(x-10, y, 10, 10);
		else if(key == KeyEvent.VK_UP && y >= 10)
			p1.setBounds(x, y-10, 10, 10);
		else if(key == KeyEvent.VK_DOWN && y <= 490)
			p1.setBounds(x, y+10, 10, 10);
	}
	
	
	public static void main(String[] args) {
		new CatchGame();
	}
}

package com.wpz;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	private int x, y;
	private Dir dir;
	private static final int SPEED = 10;
	private static final int WIDTH = 10;
	private static final int HEIGTH = 10;

	public Bullet(int x, int y, Dir dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.red);

		g.fillRect(x, y, WIDTH, HEIGTH);
		g.setColor(c);
		move();
	}

	public void move() {
		switch (dir) {
		case LEFT:
			x -= SPEED;
			break;
		case UP:
			y -= SPEED;
			break;
		case RIGHT:
			x += SPEED;
			break;
		case DOWN:
			y += SPEED;
			break;
		default:
			break;
		}

	}
}

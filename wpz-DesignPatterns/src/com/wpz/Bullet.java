package com.wpz;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet {
	private int x, y;
	private Dir dir;
	private static final int SPEED = 10;
	public  static final int WIDTH = ResourceMgr.bulletL.getWidth();
	public  static final int HEIGTH = ResourceMgr.bulletL.getHeight();
	TankFrame tf = null;
	private Group group = Group.Bad;
	private boolean living = true;
	Rectangle rect = new Rectangle();
	
	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Bullet(int x, int y, Dir dir,TankFrame tf,Group group) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
		this.group = group;
		
		rect.x=this.x;
		rect.y=this.y;
		rect.width=WIDTH;
		rect.height=HEIGTH;
	}

	public void paint(Graphics g) {
		if(!living) {
			tf.bullets.remove(this);
		}
//		Color c = g.getColor();
//		g.setColor(Color.red);
//		g.fillRect(x, y, WIDTH, HEIGTH);
//		g.setColor(c);
		switch (dir){
		case LEFT:
			g.drawImage(ResourceMgr.bulletL, x, y, null);
			break;				
		case UP:
			g.drawImage(ResourceMgr.bulletU, x, y, null);
			break;
		case RIGHT:
			g.drawImage(ResourceMgr.bulletR, x, y, null);
			break;
		case  DOWN:
			g.drawImage(ResourceMgr.bulletD, x, y, null);
			break;
		}
		
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
		rect.x =x;
		rect.y =y;
		if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;
	}

	public void collideWidth(Tank tank) {
		if(this.group==tank.getGroup()) {
			return;
		}
		
//		Rectangle r1 = new Rectangle(x,y,WIDTH,HEIGTH);
//		Rectangle r2 = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGTH);
//		if(r1.intersects(r2)) {
		if(this.rect.intersects(tank.rect)) {
			tank.die();
			this.die();
			int ex=tank.getX()+Tank.WIDTH/2-Explode.WIDTH/2;
			int ey=tank.getY()+Tank.HEIGTH/2-Explode.HEIGTH/2; 
			tf.explodes.add(new Explode(ex, ey, tf));
			
		}
		
	
	}

	private void die() {
		this.living = false;
	}
	
	
}

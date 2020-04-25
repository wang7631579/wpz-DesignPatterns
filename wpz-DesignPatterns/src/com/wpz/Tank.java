package com.wpz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Tank {
	private int x, y;
	private Dir dir = Dir.DOWN;
	private static final int SPEED = 1;
	private boolean moving = true;
	private boolean living = true;
	private TankFrame tf;
	private Random random = new Random();
	private Group group = Group.Bad;
	public  static final int WIDTH = ResourceMgr.goodTankU.getWidth();
	public  static final int HEIGTH = ResourceMgr.goodTankU.getHeight();
	Rectangle rect = new Rectangle();
	
	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Tank(int x, int y, Dir dir,TankFrame tf,Group group) {
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
		if(!living) {tf.tanks.remove(this);}		
		switch (dir){
			case LEFT:
				g.drawImage(this.group==Group.Good?ResourceMgr.goodTankL:ResourceMgr.badTankL, x, y, null);
				break;				
			case UP:
				g.drawImage(this.group==Group.Good?ResourceMgr.goodTankU:ResourceMgr.badTankU, x, y, null);
				break;
			case RIGHT:
				g.drawImage(this.group==Group.Good?ResourceMgr.goodTankR:ResourceMgr.badTankR, x, y, null);
				break;
			case  DOWN:
				g.drawImage(this.group==Group.Good?ResourceMgr.goodTankD:ResourceMgr.badTankD, x, y, null);
				break;
		}
		
//		
//		Color c = g.getColor();
//		g.setColor(Color.YELLOW);
//		g.fillRect(x, y, 50, 50);
//		g.setColor(c);
		move();
	}

	public void move() {
		if(!moving) {return ;}
		
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
		
		if(this.group==Group.Bad && random.nextInt(100)>95) {
			this.fire();
		}
		
		if(this.group==Group.Bad && random.nextInt(100)>95) {
			randomDir();
		}
		
		if(this.group==Group.Bad && random.nextInt(100)>95) {
			boundsCheck();
		}
		
		rect.x=x;
		rect.y=y;
		
	}

	private void boundsCheck() {
		if(this.x <0 ) {x=0;}
		if(this.y <30 ) {y=30;}	
		if(this.x > TankFrame.GAME_WIDTH -Tank.WIDTH) {x =TankFrame.GAME_WIDTH -Tank.WIDTH;}
		if(this.y > TankFrame.GAME_HEIGHT -Tank.HEIGTH) {y =TankFrame.GAME_HEIGHT -Tank.HEIGTH;}	
		
	}

	private void randomDir() {
		this.dir =Dir.values()[random.nextInt(4)];
		
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public void fire() {
		int bx=this.x+Tank.WIDTH/2-Bullet.WIDTH/2;
		int by=this.y+Tank.HEIGTH/2-Bullet.HEIGTH/2;
		tf.bullets.add(new Bullet(bx,by,dir,tf,this.getGroup()));
//		
//		
//		tf.b = ;
	}

	public void die() {
		this.living = false;
	}

}

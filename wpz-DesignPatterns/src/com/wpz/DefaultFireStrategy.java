package com.wpz;

public class DefaultFireStrategy implements FireStrategy{

	@Override
	public void fire(Tank t) {
		int bx=t.x+Tank.WIDTH/2-Bullet.WIDTH/2;
		int by=t.y+Tank.HEIGTH/2-Bullet.HEIGTH/2;
		new Bullet(bx,by,t.dir,t.tf,t.getGroup());
		if(t.group == Group.Good) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
	}
	
}

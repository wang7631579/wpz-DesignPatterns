package com.wpz;

import java.awt.Graphics;

public class Explode {
	public  static final int WIDTH = ResourceMgr.explodes[0].getWidth();
	public  static final int HEIGTH = ResourceMgr.explodes[0].getHeight();
	private int x,y;
	private boolean living = true;
	TankFrame tf;
	private int step=0;
	
	public Explode(int x, int y, TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.tf = tf;
		new Audio("audio/explode.wav").run();
	}
	public void paint(Graphics g) {
		g.drawImage(ResourceMgr.explodes[step++], x, y, null);
		if(step>=ResourceMgr.explodes.length) {
			//
			//step=0;
			tf.explodes.remove(this);
		}
	}

	
}

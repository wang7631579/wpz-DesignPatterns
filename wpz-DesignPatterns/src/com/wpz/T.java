package com.wpz;



import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class T {

	public static void main(String[] args) throws InterruptedException {
		TankFrame f = new TankFrame();
		for(;;) {
			Thread.sleep(50);
			f.repaint();
		}
//		
//		Frame f = new Frame();
//		f.setSize(800,600);
//		f.setResizable(false);
//		f.setTitle("WPZ");
//		f.setVisible(true);
//		f.addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				System.exit(0);
//			}
//		});
	}

}

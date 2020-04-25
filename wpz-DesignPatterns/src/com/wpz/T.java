package com.wpz;

public class T {

	public static void main(String[] args) throws InterruptedException {
		int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));

		TankFrame tf = new TankFrame();
		for (int i = 0; i < initTankCount; i++) {

			tf.tanks.add(new Tank(50 + i * 80, 200, Dir.DOWN, tf, Group.Bad));

		}

		new Thread(()-> {
				new Audio("audio/war1.wav").loop();
			
		}).start();
		
		for (;;) {
			Thread.sleep(50);
			tf.repaint();
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

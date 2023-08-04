package org.jvav;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;
import res.GetRes;

/**
 * Jvav AD
 * <p>来自张浩杨博士的广告</p>
 * @author 张浩杨博士
 * @since Jvav 0.0.3
 * @see Jvav.top
 */
public class JvavAD {
	private final int width = 746;
	private final int height = 356;
	private Random r = new Random();
	private int x = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() - width;
	private int y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public static boolean threadRun = false;
	private int et = 0;
	@SuppressWarnings("serial")
	public static JFrame jFrame = new JFrame() {
		@Override
		public void paint(Graphics g) {
			// TODO 自动生成的方法存根
			g.drawImage(GetRes.adImage, 0, 0, this);
		}
	};
	public JvavAD() { 
		jFrame.setTitle("张浩杨博士推荐的广告" + " ET:" + et);
		jFrame.setBounds(x , y - 356, width, height);
		jFrame.setIconImage(GetRes.icon);
		jFrame.setAlwaysOnTop(true);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jFrame.setResizable(false);
		jFrame.setVisible(true);
		/*
		 * 判断是否显示
		 */
		if (jFrame.isVisible()) {
			for (int i = 0; i < height + 50; i++) {
				jFrame.setLocation(x, y - i);
			}
		}
		/**
		 * 专用特性
		 * @author 张浩杨博士
		 */
		jFrame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				et++;
				jFrame.setTitle("张浩杨博士推荐的广告" + " ET:" + et);
				if (!threadRun && et > 10) {
					Runnable adThread =()->{
						while (jFrame.isVisible()) {
							int x1 = r.nextInt(x);
							int y1 = r.nextInt(y - height);
							jFrame.setLocation(x1, y1);
							Util.sleep(200);
						}
						threadRun = !threadRun;
					};
					Thread jvavThread = new Thread(adThread);
					jvavThread.start();
					threadRun = !threadRun;
				} else {
					int x1 = r.nextInt(x);
					int y1 = r.nextInt(y - height);
					jFrame.setLocation(x1, y1);
				}
			}
		});
	}
}

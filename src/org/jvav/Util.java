package org.jvav;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

/**
 * Jvav������
 * @author �ź���ʿ
 */
public class Util {
	/**
	 * Jvav���
	 * @author �ź���ʿ
	 * @param <T>
	 * @param t
	 * @since Jvav 0.0.1
	 */
	public static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
		}
	}
	public static void soundPlayer(AudioInputStream inputStream) {
		try {
            AudioFormat format = inputStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(inputStream);
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 1000);
            clip.stop();
            clip.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	public static void wAit(Object object) {
		synchronized (object) {
			try {
				object.wait();
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
	public static void notiFy(Object object) {
		synchronized (object) {
			object.notify();
		}
	}
}

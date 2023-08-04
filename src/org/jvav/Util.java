package org.jvav;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

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
	/*
	 * ��ȡ��ǰĿ¼
	 */
	public static String userpath = System.getProperty("user.dir");
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
	@SuppressWarnings("finally")
	public static String version(){
		String version = null;
		try {
			InputStream vStream = Util.class.getResourceAsStream("/res/Version.txt");
			InputStreamReader sr = new InputStreamReader(vStream, "UTF-8");
			BufferedReader br = new BufferedReader(sr);
			version = br.readLine();
			br.close();
			sr.close();
		} finally {
			// TODO �Զ����ɵ� catch ��
			return version;
		}
	}
	public static void getVersionFile() {
		try {
			URL url = new URL("");
		} catch (MalformedURLException e) {
			// TODO �Զ����ɵ� catch ��
		}
	}
	public static boolean isOutDate(String getVersion) {
		return true;
	}
}

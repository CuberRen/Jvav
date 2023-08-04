package org.jvav;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;


/**
 * Jvav�������ࣨRebuild��
 * <p>����̨���� ��ʹ��CMD����<p>
 * @version 0.1.1
 * @author �ź��ʿ
 */
public class Main {
	public static Scanner sc = new Scanner(System.in);
	private static String bit = System.getProperty("os.arch");
	private static String ver = Util.version();
	private static String version = "Jvav version " + ver + "\nJvav(TM) Jvav Build Kit " + "(" + ver + ")\nJvav HotToilet(TM) " + bit + " Toilet VM " + "(" +"Build " + ver + ", Toilet Mode" + ")";
	public static CountDownLatch downLatch = new CountDownLatch(0);
	/**
	 * Jvav������
	 * @author �ź��ʿ
	 * @since Jvav 0.0.1
	 * @see Jvav.top
	 */
	public static void main(String[] args) {
		try {
			for (int i = 0; i < args.length + 1; i++) {
				String arg = args[i];
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println(version + " ������:�ź��ʿ");
			while (true) {
				System.out.print("=>");
				String input = sc.nextLine();
				String [] arg = input.split("\\ ");
				if (arg[1] != null) {
					command(arg[0], arg[1]);
				} else {
					command(input, null);
				}
			}
		}
	}
	/**
	 * Jvav���������
	 * <p>˽�з���</p>
	 * @author �ź��ʿ
	 * @param <T>
	 * @param command
	 * @since Jvav 0.0.1
	 */
	private static <T> void command(String command, T t) {
		switch(command.toLowerCase()) {
		case "ad":
			if (JvavAD.threadRun == false) {
				new JvavAD();
			} else {
				System.out.println("���Ѿ�����һ������ˣ�");
			}
			break;
		case "author":
			System.out.println("JVAV�����ߣ��ź��ʿ");
			break;
		case "chat":
			JvavChatbot.chat(sc);
			break;
		case "update":
			System.out.println(version);
			break;
		case "clad":
			JvavAD.jFrame.dispose();
			break;
		case "compiler":
			;
			break;
		case "exit":
			System.out.println("�˳�JVAV����̨�ɹ���");
			System.exit(0);
			break;
		case "help":
			System.out.println(
					"+==========Jvav�����˵�==========+"
					+ "\nAD - ��ʾ�����ź��ʿ�Ƽ��Ĺ��"
					+ "\nAUTHOR - ��ȡ������Ϣ"
					+ "\nCHAT - �����ź��ʿ���Ƶ����ܻ�����"
					+ "\nUPADTE - ������"
					+ "\nCLAD - ǿ�ƹر��ź��ʿ�Ƽ��Ĺ��"
					+ "\nEXIT - �˳�JVAV"
					+ "\nHELP - ��ȡ����"
					+ "\nVERSION - ��ȡ�汾��Ϣ"
					+ "\n��ע�⣺����������ִ�Сд"
					+ "\n+==============================+"
					);
			break;
		case "version":
			System.out.println(version);
			break;
		case "":
			break;
		default: 
			System.out.println("δ֪�����������HELP��ȡ����");
			break;
		}
	}
}

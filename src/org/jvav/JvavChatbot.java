package org.jvav;

import java.util.Scanner;

public class JvavChatbot {
	/**
	 * JvavChatBot��̬����
	 * @author �ź��ʿ
	 * @since 0.0.6
	 * @param sc
	 * @see Jvav.top
	 */
	public static void chat(Scanner sc) {
		/*
		 * ��ע�⣡
		 * ��̬����
		 */
		System.out.println("+==========JvavChatBot==========+");
		// TODO �Զ����ɵĹ��캯�����
		while (true) {
			System.out.print("BOT=>");
			String question = sc.nextLine();
			if (question.endsWith("��")) {
				System.out.print("Processing:");
				for (int i = 0; i < question.length(); i++) {
					System.out.print(".");
					Util.sleep(100);
				}
				System.out.print("\n");
				if (question.contains("��")) {
					String result = question.replace("��", "��");
					String result2 = result.replace("��", "��");
					System.out.println(result2);
				} else {
					String result = question.replace("��", "��");
					String result2 = result.replace("��", "��");
					System.out.println(result2);
				}
			} else if (question.equalsIgnoreCase("exit")) {
				break; //����whileѭ�������˳�
			} else {
				System.err.println("δ֪���ʾ䣡�ʾ�����ԡ��𣿡���β");
				Util.sleep(10);
			}
		}
	}
}

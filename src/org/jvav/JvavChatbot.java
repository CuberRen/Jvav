package org.jvav;

import java.util.Scanner;

public class JvavChatbot {
	/**
	 * JvavChatBot静态方法
	 * @author 张浩杨博士
	 * @since 0.0.6
	 * @param sc
	 * @see Jvav.top
	 */
	public static void chat(Scanner sc) {
		/*
		 * 请注意！
		 * 静态方法
		 */
		System.out.println("+==========JvavChatBot==========+");
		// TODO 自动生成的构造函数存根
		while (true) {
			System.out.print("BOT=>");
			String question = sc.nextLine();
			if (question.endsWith("吗？")) {
				System.out.print("Processing:");
				for (int i = 0; i < question.length(); i++) {
					System.out.print(".");
					Util.sleep(100);
				}
				System.out.print("\n");
				if (question.contains("我")) {
					String result = question.replace("我", "你");
					String result2 = result.replace("吗？", "。");
					System.out.println(result2);
				} else {
					String result = question.replace("你", "我");
					String result2 = result.replace("吗？", "。");
					System.out.println(result2);
				}
			} else if (question.equalsIgnoreCase("exit")) {
				break; //跳出while循环，即退出
			} else {
				System.err.println("未知的问句！问句必须以“吗？”结尾");
				Util.sleep(10);
			}
		}
	}
}

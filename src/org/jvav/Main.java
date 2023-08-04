package org.jvav;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;


/**
 * Jvav启动主类（Rebuild）
 * <p>控制台程序 需使用CMD运行<p>
 * @version 0.1.1
 * @author 张浩杨博士
 */
public class Main {
	public static Scanner sc = new Scanner(System.in);
	private static String bit = System.getProperty("os.arch");
	private static String ver = "\"0.1.1 Dev\"";
	private static String version = "Jvav version " + ver + "\nJvav(TM) Jvav Build Kit " + "(" + ver + ")\nJvav HotToilet(TM) " + bit + " Toilet VM " + "(" +"Build " + ver + ", Toilet Mode" + ")";
	public static CountDownLatch downLatch = new CountDownLatch(0);
	/**
	 * Jvav主方法
	 * @author 张浩杨博士
	 * @since Jvav 0.0.1
	 * @see Jvav.top
	 */
	public static void main(String[] args) {
		try {
			for (int i = 0; i < args.length + 1; i++) {
				String arg = args[i];
				command(arg);
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println(version + " 制造者:张浩杨博士");
			while (true) {
				System.out.print("=>");
				String input = sc.nextLine();
				command(input);
			}
		}
	}
	/**
	 * Jvav命令解释器
	 * <p>私有方法</p>
	 * @author 张浩杨博士
	 * @param command
	 * @since Jvav 0.0.1
	 */
	private static void command(String command) {
		switch(command.toLowerCase()) {
		case "ad":
			if (JvavAD.threadRun == false) {
				new JvavAD();
			} else {
				System.out.println("您已经启动一个广告了！");
			}
			break;
		case "author":
			System.out.println("JVAV制造者：张浩杨博士");
			break;
		case "chat":
			JvavChatbot.chat(sc);
			break;
		case "clad":
			JvavAD.jFrame.dispose();
			break;
		case "compiler":
			;
			break;
		case "exit":
			System.out.println("退出JVAV控制台成功！");
			System.exit(0);
			break;
		case "help":
			System.out.println(
					"+==========Jvav帮助菜单==========+"
					+ "\nAD - 显示来自张浩杨博士推荐的广告"
					+ "\nAUTHOR - 获取作者信息"
					+ "\nCHAT - 启动张浩杨博士研制的智能机器人"
					+ "\nCLAD - 强制关闭张浩杨博士推荐的广告"
					+ "\nEXIT - 退出JVAV"
					+ "\nHELP - 获取帮助"
					+ "\nVERSION - 获取版本信息"
					+ "\n请注意：所有命令不区分大小写"
					+ "\n+==============================+"
					);
			break;
		case "version":
			System.out.println(version);
			break;
		case "":
			break;
		default: 
			System.out.println("未知的命令！请输入HELP获取帮助");
			break;
		}
	}
}

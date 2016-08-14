package com.lbyl;

import java.util.ArrayList;
import java.util.List;

/**
 * 聊天工具类，只需调用
 * 
 * @author LBYL
 *
 */
public class ChatTools {

	private ChatTools() {
	}// 无需外部构造

	private static ArrayList<Thread> stList = new ArrayList();

	/**
	 * @return the stList
	 */
	public static ArrayList<Thread> getStList() {
		return stList;
	}

	/**
	 * @param stList
	 *            the stList to set
	 */
	public static void setStList(ArrayList<Thread> stList) {
		ChatTools.stList = stList;
	}

}

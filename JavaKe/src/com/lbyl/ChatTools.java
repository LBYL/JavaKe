package com.lbyl;

import java.util.ArrayList;
import java.util.List;

/**
 * ���칤���ֻ࣬�����
 * 
 * @author LBYL
 *
 */
public class ChatTools {

	private ChatTools() {
	}// �����ⲿ����

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

package com.lbyl.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * ���칤���ֻ࣬�����
 * 
 * @author LBYL
 *
 */
public class ChatUtil {

	// �����ⲿ����
	private ChatUtil() {}
	//�̶߳���ά��
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
		ChatUtil.stList = stList;
	}
	/**
	 * Ⱥ������
	 */
	public static void sendMsg2All() {
		
	}

}

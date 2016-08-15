package com.lbyl.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 聊天工具类，只需调用
 * 
 * @author LBYL
 *
 */
public class ChatUtil {

	// 无需外部构造
	private ChatUtil() {}
	//线程队列维护
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
	 * 群发方法
	 */
	public static void sendMsg2All() {
		
	}

}

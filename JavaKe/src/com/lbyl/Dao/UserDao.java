package com.lbyl.Dao;

import java.util.HashMap;
import java.util.Map;

import com.lbyl.Bean.UserInfo;

/**
 * �û����ݿ���
 * 
 * @author LBYL
 *
 */
public final class UserDao {

	private static Map<String, UserInfo> UserDB = new HashMap();

	// ��̬��ģ���û�����
	static {

		for (int i = 0; i < 10; i++) {

			UserInfo user = new UserInfo();
			user.setName("user" + i);
			user.setPassword(i);

			UserDB.put(user.getName(), user);
		}
	}

}

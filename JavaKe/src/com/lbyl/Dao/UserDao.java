package com.lbyl.Dao;

import java.util.HashMap;
import java.util.Map;

import com.lbyl.Bean.UserInfo;

/**
 * 用户数据库类
 * 
 * @author LBYL
 *
 */
public final class UserDao {

	public static Map<String, UserInfo> UserDB = new HashMap();

	// 静态块模拟用户数据
	static {

		for (int i = 0; i < 10; i++) {

			UserInfo user = new UserInfo();
			user.setName("user" + i);
			user.setPassword(String.valueOf(i));

			UserDB.put(user.getName(), user);
		}
	}

}

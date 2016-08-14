package com.lbyl.Biz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ServerThread extends Thread {

	private Socket client;
	private OutputStream ous;
	private InputStream ins;

	public ServerThread(Socket client) {
		this.client = client;
	}
	/**
	 * 线程主要执行方法
	 */
	@Override
	public void run() {
		super.run();

		// 获取输入输出流
		try {
			ous = client.getOutputStream();
			ins = client.getInputStream();

			// 一旦上线，则问候
			ous.write("欢迎上线!\r\n".getBytes());// getbytes获取的是单字节码
			
			checkLogin();
			
			
			

			BufferedReader bf = new BufferedReader(new InputStreamReader(ins));// 将输入流包装




		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 验证账户
	 * @throws IOException 
	 */
	private void checkLogin() throws IOException {
		ous.write("请输入账号密码\r\n:".getBytes());
		
		
		
		
		
	}

}

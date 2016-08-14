package com.lbyl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 首先实现聊天室功能
 * 服务器类：
 * 启动服务器，循环接受客户端
 * @author LBYL
 *
 */
public class ChatServer {

	private static OutputStream ous;
	private static InputStream ins;

	public static void main(String[] args) {
		
		try {
			//创建服务器
			ServerSocket sc =new ServerSocket(9090);
			System.out.println("------服务器创建成功！-------");
			Socket client = sc.accept();
			
			//获取输入输出流
			ous = client.getOutputStream();
			ins = client.getInputStream();
			
			//一旦上线，则问候
			ous.write("欢迎上线！".getBytes());
			
			//交流？
			System.out.println(ins.read());
			
			
			
			

			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

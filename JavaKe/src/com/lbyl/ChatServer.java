package com.lbyl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 首先实现聊天室功能 服务器类： 启动服务器，循环接受客户端
 * 
 * @author LBYL
 *
 */
public class ChatServer {

	private static OutputStream ous;
	private static InputStream ins;

	public static void main(String[] args) {

		try {
			// 创建服务器
			ServerSocket sc = new ServerSocket(9090);
			System.out.println("------服务器创建成功！-------");

			while (true) {
				//阻塞接收客户端
				Socket client = sc.accept();
				System.out.println("上线了一个客户端！");
				//创建线程
				ServerThread st = new ServerThread(client);
				//维护到队列中
				ChatTools.getStList().add(st);
				System.out.println("-------现在有"+ChatTools.getStList().size()+"个客户端--------");
				
				st.start();
				

			}

			// //获取输入输出流
			// ous = client.getOutputStream();
			// ins = client.getInputStream();
			//
			// //一旦上线，则问候
			// ous.write("欢迎上线!\r\n".getBytes());//getbytes获取的是单字节码
			//
			// //交流？
			// System.out.println(ins.read());
			//
			// BufferedReader bf = new BufferedReader(new
			// InputStreamReader(ins));//将输入流包装
			// String readLine = bf.readLine();
			//
			// System.out.println(readLine);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

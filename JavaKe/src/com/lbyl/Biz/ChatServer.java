package com.lbyl.Biz;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.lbyl.Utils.ChatUtil;

/**
 * 首先实现聊天室功能 服务器类： 启动服务器，循环接受客户端
 * 
 * @author LBYL
 *
 */
public class ChatServer {

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
				ChatUtil.getStList().add(st);
				System.out.println("-------现在有"+ChatUtil.getStList().size()+"个客户端--------");
				
				st.start();
				

			}


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

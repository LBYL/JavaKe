package com.lbyl.Biz;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.lbyl.Utils.ChatUtil;

/**
 * ����ʵ�������ҹ��� �������ࣺ ������������ѭ�����ܿͻ���
 * 
 * @author LBYL
 *
 */
public class ChatServer {

	public static void main(String[] args) {

		try {
			// ����������
			ServerSocket sc = new ServerSocket(9090);
			System.out.println("------�����������ɹ���-------");

			while (true) {
				//�������տͻ���
				Socket client = sc.accept();
				System.out.println("������һ���ͻ��ˣ�");
				//�����߳�
				ServerThread st = new ServerThread(client);
				//ά����������
				ChatUtil.getStList().add(st);
				System.out.println("-------������"+ChatUtil.getStList().size()+"���ͻ���--------");
				
				st.start();
				

			}


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

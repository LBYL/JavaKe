package com.lbyl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����ʵ�������ҹ��� �������ࣺ ������������ѭ�����ܿͻ���
 * 
 * @author LBYL
 *
 */
public class ChatServer {

	private static OutputStream ous;
	private static InputStream ins;

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
				ChatTools.getStList().add(st);
				System.out.println("-------������"+ChatTools.getStList().size()+"���ͻ���--------");
				
				st.start();
				

			}

			// //��ȡ���������
			// ous = client.getOutputStream();
			// ins = client.getInputStream();
			//
			// //һ�����ߣ����ʺ�
			// ous.write("��ӭ����!\r\n".getBytes());//getbytes��ȡ���ǵ��ֽ���
			//
			// //������
			// System.out.println(ins.read());
			//
			// BufferedReader bf = new BufferedReader(new
			// InputStreamReader(ins));//����������װ
			// String readLine = bf.readLine();
			//
			// System.out.println(readLine);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

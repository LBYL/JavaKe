package com.lbyl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����ʵ�������ҹ���
 * �������ࣺ
 * ������������ѭ�����ܿͻ���
 * @author LBYL
 *
 */
public class ChatServer {

	private static OutputStream ous;
	private static InputStream ins;

	public static void main(String[] args) {
		
		try {
			//����������
			ServerSocket sc =new ServerSocket(9090);
			System.out.println("------�����������ɹ���-------");
			Socket client = sc.accept();
			
			//��ȡ���������
			ous = client.getOutputStream();
			ins = client.getInputStream();
			
			//һ�����ߣ����ʺ�
			ous.write("��ӭ���ߣ�".getBytes());
			
			//������
			System.out.println(ins.read());
			
			
			
			

			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

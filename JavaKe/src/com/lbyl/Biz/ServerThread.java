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
	 * �߳���Ҫִ�з���
	 */
	@Override
	public void run() {
		super.run();

		// ��ȡ���������
		try {
			ous = client.getOutputStream();
			ins = client.getInputStream();

			// һ�����ߣ����ʺ�
			ous.write("��ӭ����!\r\n".getBytes());// getbytes��ȡ���ǵ��ֽ���
			
			checkLogin();
			
			
			

			BufferedReader bf = new BufferedReader(new InputStreamReader(ins));// ����������װ




		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ��֤�˻�
	 * @throws IOException 
	 */
	private void checkLogin() throws IOException {
		ous.write("�������˺�����\r\n:".getBytes());
		
		
		
		
		
	}

}

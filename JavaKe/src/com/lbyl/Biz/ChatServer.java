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

	private boolean runningState;
	private int port;
	private ServerSocket sc;
	private MainThread mThread;

	// ����ʱ����˿ں�
	public ChatServer(int port) {
		this.port = port;
		runningState = false;
	}

	/**
	 * @param �ⲿ���ÿ���״̬
	 */
	public void setRunningState(boolean runningState) {
		this.runningState = runningState;
	}

	/**
	 * ����������
	 */
	public void setUpServer() {
		try {
			// ����������

			if (runningState) {// ����Ѿ����ˣ��Ͳ���Ӧ
				return;
			}
			sc = new ServerSocket(port);
			runningState = true;
			System.out.println("------�����������ɹ���-------");

			mThread = new MainThread();
			mThread.start();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ���ط���������״̬
	 * 
	 * @return
	 */
	public boolean getRunningState() {
		return runningState;
	}
	/**
	 * �رշ�����
	 * @throws IOException 
	 */
	public void closeServer() throws IOException{
		sc.close();
		mThread.interrupt();
	}

	/**
	 * ѭ�����տͻ����߳�
	 * 
	 * @author LBYL
	 *
	 */
	class MainThread extends Thread {

		@Override
		public void run() {
			super.run();
			while (!isInterrupted()) {
				// �������տͻ���
				Socket client;
				try {
					client = sc.accept();
					System.out.println("������һ���ͻ��ˣ�");
					// �����߳�
					ServerThread st = new ServerThread(client);
					// ά����������
					ChatUtil.getStList().add(st);
					System.out.println("-------������" + ChatUtil.getStList().size() + "���ͻ���--------");

					st.start();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("ֹͣ���տͻ���");
				}

			}
		}
	}
}

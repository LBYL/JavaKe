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

	private boolean runningState;
	private int port;
	private ServerSocket sc;
	private MainThread mThread;

	// 构造时传入端口号
	public ChatServer(int port) {
		this.port = port;
		runningState = false;
	}

	/**
	 * @param 外部设置开闭状态
	 */
	public void setRunningState(boolean runningState) {
		this.runningState = runningState;
	}

	/**
	 * 开启服务器
	 */
	public void setUpServer() {
		try {
			// 创建服务器

			if (runningState) {// 如果已经开了，就不响应
				return;
			}
			sc = new ServerSocket(port);
			runningState = true;
			System.out.println("------服务器创建成功！-------");

			mThread = new MainThread();
			mThread.start();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 返回服务器运行状态
	 * 
	 * @return
	 */
	public boolean getRunningState() {
		return runningState;
	}
	/**
	 * 关闭服务器
	 * @throws IOException 
	 */
	public void closeServer() throws IOException{
		sc.close();
		mThread.interrupt();
	}

	/**
	 * 循环接收客户端线程
	 * 
	 * @author LBYL
	 *
	 */
	class MainThread extends Thread {

		@Override
		public void run() {
			super.run();
			while (!isInterrupted()) {
				// 阻塞接收客户端
				Socket client;
				try {
					client = sc.accept();
					System.out.println("上线了一个客户端！");
					// 创建线程
					ServerThread st = new ServerThread(client);
					// 维护到队列中
					ChatUtil.getStList().add(st);
					System.out.println("-------现在有" + ChatUtil.getStList().size() + "个客户端--------");

					st.start();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("停止接收客户端");
				}

			}
		}
	}
}

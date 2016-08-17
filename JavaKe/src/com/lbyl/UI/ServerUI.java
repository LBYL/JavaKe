package com.lbyl.UI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.lbyl.Biz.ChatServer;

public class ServerUI {

	private ServerUI serverUI;
	private ChatServer chatServer;
	private JLabel lb_port;
	private JTextField jtf_openServer;
	private JButton jb_port;
	private JFrame jf;

	public void initUI() {
		serverUI = new ServerUI();
		chatServer = new ChatServer(9090);

		initFrame();// 初始化窗口
		initComp();// 初始化组件
		addComp();//add组件

		jf.setVisible(true);

	}
	/**
	 * add组件
	 */
	private void addComp() {
		jf.add(lb_port);
		jf.add(jtf_openServer);
		jf.add(jb_port);
	}
	/**
	 * 初始化控件
	 */
	private void initComp() {
		lb_port = new JLabel("端口号：");
		jtf_openServer = new JTextField(4);
		jtf_openServer.setText("9090");
		jb_port = new JButton("开启服务器");
		
		// 加监听器
		addListeners();
	}

	/**
	 * 为组件加上监听器
	 */
	private void addListeners() {
		jb_port.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				actionServer();
			}

		});
	}
	/**
	 * 初始化Frame
	 */
	private void initFrame() {
		jf = new JFrame("JavaKe");
		jf.setLayout(new FlowLayout());
		jf.setSize(900, 900);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(3);
	}

	/**
	 * 取方框内数字，创建服务器
	 */
	private void actionServer() {

		String text_port = jtf_openServer.getText();
		if (chatServer.getRunningState()) {// 如果服务器正在运行
			try {
				chatServer.closeServer();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			chatServer.setRunningState(false);// 设置其关闭状态
			return;
		} // 否则创建服务器
		if (text_port != null) {// 并未开启服务器且
			chatServer.setUpServer();
			jb_port.setText("关闭服务器");
		}
	}

}

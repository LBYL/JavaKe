package com.lbyl.UI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.lbyl.Biz.ChatServer;

public class ServerUI {
	/**
	 * 程序入口，启动服务器界面
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ChatServer chatServer = new ChatServer(9090);

		JFrame jf = new JFrame("JavaKe");
		jf.setLayout(new FlowLayout());
		jf.setSize(900, 900);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(3);

		JLabel lb_port = new JLabel("端口号：");
		JTextField jtf_openServer = new JTextField(4);
		jtf_openServer.setText("9090");
		JButton jb_port = new JButton("开启服务器");

		jb_port.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				actionServer();
			}

			/*
			 * 取方框内数字，创建服务器
			 */
			private void actionServer() {
				// TODO Auto-generated method stub

				String text_port = jtf_openServer.getText();
				if (chatServer.getRunningState()) {// 如果服务器正在运行
					try {
						chatServer.closeServer();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					chatServer.setRunningState(false);// 设置其关闭状态
					System.out.println("----------服务器已关闭！---------");
					return;
				} // 否则创建服务器
				if (text_port != null) {// 并未开启服务器且
					chatServer.setUpServer();
					jb_port.setText("关闭服务器");
				}
			}
		});

		jf.add(lb_port);
		jf.add(jtf_openServer);
		jf.add(jb_port);

		jf.setVisible(true);
	}

}

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
	 * ������ڣ���������������
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

		JLabel lb_port = new JLabel("�˿ںţ�");
		JTextField jtf_openServer = new JTextField(4);
		jtf_openServer.setText("9090");
		JButton jb_port = new JButton("����������");

		jb_port.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				actionServer();
			}

			/*
			 * ȡ���������֣�����������
			 */
			private void actionServer() {
				// TODO Auto-generated method stub

				String text_port = jtf_openServer.getText();
				if (chatServer.getRunningState()) {// �����������������
					try {
						chatServer.closeServer();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					chatServer.setRunningState(false);// ������ر�״̬
					System.out.println("----------�������ѹرգ�---------");
					return;
				} // ���򴴽�������
				if (text_port != null) {// ��δ������������
					chatServer.setUpServer();
					jb_port.setText("�رշ�����");
				}
			}
		});

		jf.add(lb_port);
		jf.add(jtf_openServer);
		jf.add(jb_port);

		jf.setVisible(true);
	}

}

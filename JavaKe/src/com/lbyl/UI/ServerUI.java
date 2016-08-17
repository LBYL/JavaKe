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

		initFrame();// ��ʼ������
		initComp();// ��ʼ�����
		addComp();//add���

		jf.setVisible(true);

	}
	/**
	 * add���
	 */
	private void addComp() {
		jf.add(lb_port);
		jf.add(jtf_openServer);
		jf.add(jb_port);
	}
	/**
	 * ��ʼ���ؼ�
	 */
	private void initComp() {
		lb_port = new JLabel("�˿ںţ�");
		jtf_openServer = new JTextField(4);
		jtf_openServer.setText("9090");
		jb_port = new JButton("����������");
		
		// �Ӽ�����
		addListeners();
	}

	/**
	 * Ϊ������ϼ�����
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
	 * ��ʼ��Frame
	 */
	private void initFrame() {
		jf = new JFrame("JavaKe");
		jf.setLayout(new FlowLayout());
		jf.setSize(900, 900);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(3);
	}

	/**
	 * ȡ���������֣�����������
	 */
	private void actionServer() {

		String text_port = jtf_openServer.getText();
		if (chatServer.getRunningState()) {// �����������������
			try {
				chatServer.closeServer();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			chatServer.setRunningState(false);// ������ر�״̬
			return;
		} // ���򴴽�������
		if (text_port != null) {// ��δ������������
			chatServer.setUpServer();
			jb_port.setText("�رշ�����");
		}
	}

}

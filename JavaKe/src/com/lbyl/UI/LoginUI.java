package com.lbyl.UI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.lbyl.Biz.ChatServer;
import com.lbyl.Dao.UserDao;
import com.lbyl.Utils.LogUtil;

public class ClientUI {

	private ChatServer chatServer;
	private JLabel lb_user;
	private JTextField jtf_user;
	private JButton jb_login;
	private JFrame jf;
	private JLabel jl_pwd;
	private JTextField jtf_pwd;
	private JLabel jl_error;
	private String userName;
	private String userPwd;

	public void initUI() {

		initFrame();// ��ʼ������
		initComp();// ��ʼ�����
		addComp();// add���

		jf.setVisible(true);

	}

	/**
	 * add���
	 */
	private void addComp() {
		jf.add(lb_user);
		jf.add(jtf_user);
		jf.add(jl_pwd);
		jf.add(jtf_pwd);
		jf.add(jb_login);
		jf.add(jl_error);
	}

	/**
	 * ��ʼ���ؼ�
	 */
	private void initComp() {
		lb_user = new JLabel("�û�����");
		jtf_user = new JTextField(10);
		jl_pwd = new JLabel("���룺");
		jtf_pwd = new JTextField(10);
		jb_login = new JButton("��¼");
		jl_error = new JLabel("");

		// �Ӽ�����
		addListeners();
	}

	/**
	 * Ϊ������ϼ�����
	 */
	private void addListeners() {
		// ��¼��ť
		jb_login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				actionLogin();
			}

		});
	}

	/**
	 * ��ʼ��Frame
	 */
	private void initFrame() {
		jf = new JFrame("��ӭ����JavaKe");
		jf.setLayout(new FlowLayout());
		jf.setSize(200, 200);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(3);
	}

	/**
	 * ȡ���������֣�����������
	 */
	private void actionLogin() {
		if(!checkInfo()){//����û���Ϣ������ֹͣ��֤
			return;
		}
		userName = jtf_user.getText();
		userPwd = jtf_pwd.getText();
		if (!UserDao.UserDB.containsKey(userName)) {
			jl_error.setText("�û�������!");
			return;
		}
		if(!UserDao.UserDB.get(userName).getPassword().equals(userPwd)){
			jl_error.setText("�������");
			return;
		}
		LogUtil.log("�û���¼�ɹ�");
		
	}

	/**
	 * ����¼��Ϣ
	 */
	private Boolean checkInfo() {
		if (!ChatServer.getRunningState()) {// ���������û�����У�������ʾ��
			jl_error.setText("���ȼ������");
			return false;
		}
		if (jtf_user.getText() == null) {
			jl_error.setText("����д�û���");
			return false;
		}
		if (jtf_pwd.getText() == null) {
			jl_error.setText("����д����");
			return false;
		}
		return  true;
	}

}
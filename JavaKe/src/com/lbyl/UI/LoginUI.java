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

		initFrame();// 初始化窗口
		initComp();// 初始化组件
		addComp();// add组件

		jf.setVisible(true);

	}

	/**
	 * add组件
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
	 * 初始化控件
	 */
	private void initComp() {
		lb_user = new JLabel("用户名：");
		jtf_user = new JTextField(10);
		jl_pwd = new JLabel("密码：");
		jtf_pwd = new JTextField(10);
		jb_login = new JButton("登录");
		jl_error = new JLabel("");

		// 加监听器
		addListeners();
	}

	/**
	 * 为组件加上监听器
	 */
	private void addListeners() {
		// 登录按钮
		jb_login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				actionLogin();
			}

		});
	}

	/**
	 * 初始化Frame
	 */
	private void initFrame() {
		jf = new JFrame("欢迎来到JavaKe");
		jf.setLayout(new FlowLayout());
		jf.setSize(200, 200);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(3);
	}

	/**
	 * 取方框内数字，创建服务器
	 */
	private void actionLogin() {
		if(!checkInfo()){//如果用户信息有误，则停止验证
			return;
		}
		userName = jtf_user.getText();
		userPwd = jtf_pwd.getText();
		if (!UserDao.UserDB.containsKey(userName)) {
			jl_error.setText("用户不存在!");
			return;
		}
		if(!UserDao.UserDB.get(userName).getPassword().equals(userPwd)){
			jl_error.setText("密码错误");
			return;
		}
		LogUtil.log("用户登录成功");
		
	}

	/**
	 * 检查登录信息
	 */
	private Boolean checkInfo() {
		if (!ChatServer.getRunningState()) {// 如果服务器没有运行，给出提示：
			jl_error.setText("请先检查网络");
			return false;
		}
		if (jtf_user.getText() == null) {
			jl_error.setText("请填写用户名");
			return false;
		}
		if (jtf_pwd.getText() == null) {
			jl_error.setText("请填写密码");
			return false;
		}
		return  true;
	}

}
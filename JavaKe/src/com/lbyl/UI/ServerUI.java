package com.lbyl.UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ServerUI {
	/**
	 * ������ڣ���������������
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		JFrame jf = new JFrame("JavaKe");
		jf.setLayout(new FlowLayout());
		jf.setSize(900, 900);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(3);
		
		JLabel lb_port = new JLabel("�˿ںţ�");
		JButton jb_port = new JButton("����������");
		JTextField jtf_openServer  = new JTextField(4);
		
		
		jf.add(lb_port);
		jf.add(jtf_openServer);
		jf.add(jb_port);
		
		
		

		
		
		
		
		jf.setVisible(true);
	}

}

package zjut.java.ch9;

import java.awt.*;
import javax.swing.*;

public class TestSize extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	TestSize(String sTitle) {
		super(sTitle);
		Container c = getContentPane();
		c.setLayout(null);// ���������ÿգ�����setBounds��������
		JComboBox<String> jcb = new JComboBox<String>();
		JButton btnTest = new JButton("���԰�ť");

		jcb.addItem("0 - ��һ��");
		jcb.addItem("1 - �ڶ���");
		jcb.setSelectedIndex(1);

		c.add(btnTest);
		c.add(jcb);
		// �������λ�����С
		jcb.setBounds(250, 150, 100, 40);
		btnTest.setBounds(20, 20, 100, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 250);
	}

	public static void main(String[] args) {
		TestSize frm = new TestSize("���������С��λ��");
		frm.setVisible(true);
	}
}

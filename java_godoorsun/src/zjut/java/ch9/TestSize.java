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
		c.setLayout(null);// 将布局设置空，否则setBounds不起作用
		JComboBox<String> jcb = new JComboBox<String>();
		JButton btnTest = new JButton("测试按钮");

		jcb.addItem("0 - 第一项");
		jcb.addItem("1 - 第二项");
		jcb.setSelectedIndex(1);

		c.add(btnTest);
		c.add(jcb);
		// 设置组件位置与大小
		jcb.setBounds(250, 150, 100, 40);
		btnTest.setBounds(20, 20, 100, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 250);
	}

	public static void main(String[] args) {
		TestSize frm = new TestSize("测试组件大小与位置");
		frm.setVisible(true);
	}
}

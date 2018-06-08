package zjut.java.ch9;

import java.awt.*;
import javax.swing.*;

public class TestJPanel extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TestJPanel(String sTitle) {
		super(sTitle);
		setSize(400, 300);// 设置大小
		// 获取窗口面板;
		Container c = getContentPane();
		c.setBackground(Color.RED); // 窗口背景红色
		c.setLayout(null);// 取消布局器
		JPanel pan = new JPanel();
		pan.setBackground(Color.YELLOW); // pan背景黄色
		pan.setSize(200, 100);
		add(pan);// 用add方法把面板pan添加到窗口中
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		TestJPanel frm = new TestJPanel("JFrame with JPanel");
		frm.setVisible(true);
	}

}

package zjut.java.ch9;

import java.awt.*;
import javax.swing.*;

public class TestJLabel extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TestJLabel() {
		super("JFrame with JLabel");
		// 三个标签上的文字
		String[] s = { "第一个标签", "文字在图标的左侧", "文字在图标的下方" };
		ImageIcon[] ic = { null, new ImageIcon("new.png"), new ImageIcon("save.png") };
		// 三个标签在水平方向上的对齐方式
		int[] ih = { 0, JLabel.LEFT, JLabel.CENTER };
		// 三个标签在垂直方向上的对齐方式
		int[] iv = { 0, JLabel.CENTER, JLabel.BOTTOM };
		Container c = getContentPane();// 取得窗口的内容面板
		c.setLayout(new FlowLayout(FlowLayout.LEFT)); // 设置布局管理器
		for (int i = 0; i < 3; i++) {
			// 创建三个标签
			JLabel myLabel = new JLabel(s[i], ic[i], JLabel.LEFT);
			if (i > 0) {
				myLabel.setHorizontalTextPosition(ih[i]);
				myLabel.setVerticalTextPosition(iv[i]);
			}
			// 设置边框, setBorder来自JLabel的父类JComponent
			myLabel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			myLabel.setToolTipText("第" + (i + 1) + "个标签");
			// 加入到窗口的内容面板中
			c.add(myLabel);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
	}

	public static void main(String args[]) {
		TestJLabel frm = new TestJLabel();
		frm.setVisible(true);
	}
}

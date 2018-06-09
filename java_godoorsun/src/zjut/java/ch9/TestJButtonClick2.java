package zjut.java.ch9;

import java.awt.*;
import java.awt.event.*;//第①步，引入事件包
import javax.swing.*;

public class TestJButtonClick2 {// 利用匿名类实现监听
	TestJButtonClick2() {
		JFrame f = new JFrame("匿名类实现监听");
		Container c = f.getContentPane();
		JButton b = new JButton("Press Me!");
		// 以下利用匿名类实现第②③④步
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "你点击了按钮\"" + e.getActionCommand() + "\"", "提示",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		c.add(b, "Center");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(200, 100);
		f.setVisible(true);
	}

	public static void main(String args[]) {
		new TestJButtonClick2();
	}
}

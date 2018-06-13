package zjut.java.ch9;

import java.awt.*;
import javax.swing.*;
import java.awt.Color;

public class TestGridLayout {
	public static void main(String args[]) {
		JFrame f = new JFrame("JFrame with GridLayout");
		Container c = f.getContentPane();
		c.setLayout(new GridLayout(3, 2));// 3行2列
		JComponent[] ctls = { new JCheckBox("1 - CheckBox"), new JCheckBox("2 - CheckBox"),
				new JRadioButton("3 - RadioButton"), new JRadioButton("4 - RadioButton"), new JButton("OK"),
				new JButton("CANCEL") };
		for (int i = 0; i < ctls.length; i++) {
			c.add(ctls[i]);// 从上到下，从左到右添加组件
			// 设置边框
			if (i >= 0 & i < 2)
				((JCheckBox) ctls[i]).setBorderPainted(true);
			if (i >= 2 & i < 4)
				((JRadioButton) ctls[i]).setBorderPainted(true);
			ctls[i].setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		}
		f.setSize(400, 200);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}

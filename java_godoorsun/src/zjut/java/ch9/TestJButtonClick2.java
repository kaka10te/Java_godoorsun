package zjut.java.ch9;

import java.awt.*;
import java.awt.event.*;//�ڢٲ��������¼���
import javax.swing.*;

public class TestJButtonClick2 {// ����������ʵ�ּ���
	TestJButtonClick2() {
		JFrame f = new JFrame("������ʵ�ּ���");
		Container c = f.getContentPane();
		JButton b = new JButton("Press Me!");
		// ��������������ʵ�ֵڢڢۢܲ�
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "�����˰�ť\"" + e.getActionCommand() + "\"", "��ʾ",
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

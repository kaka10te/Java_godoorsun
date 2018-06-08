package zjut.java.ch9;

import java.awt.*;
import javax.swing.*;

public class TestJTextField {
	public static void main(String args[]) {
		JFrame frm = new JFrame("JFrame with JTextField");
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setSize(260, 100);
		Container c = frm.getContentPane();
		c.setLayout(new FlowLayout());

		JTextField[] t = { new JTextField("2012103088", 15), new JPasswordField("1234567890", 15) };
		c.add(new JLabel("�û�����"));
		c.add(t[0]);
		c.add(new JLabel("��    �룺"));
		c.add(t[1]);

		t[0].setEditable(false);// �û�������Ϊֻ��
		frm.setVisible(true);
	}
}
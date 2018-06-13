package zjut.java.ch9;

import java.awt.BorderLayout;

import javax.swing.*;

public class TestBorderLayout {
	public static void main(String args[]) {
		JFrame frm = new JFrame("JFrame with BorderLayout");
		frm.setLayout(new BorderLayout());
		// North����һ����ť
		frm.add("North", new JButton("North"));
		// South����һ��������JComboBox
		JComboBox<String> jcb = new JComboBox<String>();
		jcb.addItem("0 - First Item");
		jcb.addItem("1 - Second Item");
		jcb.setSelectedIndex(1);
		frm.add(jcb, "South");
		// East����һ����ѡ��JRadioButton
		frm.add(BorderLayout.EAST, new JRadioButton("East"));
		// West����һ����ѡ��JCheckBox
		frm.add(new JCheckBox("West"), BorderLayout.WEST);
		// Center����һ�������ı���JTextField
		frm.add("Center", new JTextField("Center"));
		// ��������
		frm.setSize(400, 300);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}
}

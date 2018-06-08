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
		// ������ǩ�ϵ�����
		String[] s = { "��һ����ǩ", "������ͼ������", "������ͼ����·�" };
		ImageIcon[] ic = { null, new ImageIcon("new.png"), new ImageIcon("save.png") };
		// ������ǩ��ˮƽ�����ϵĶ��뷽ʽ
		int[] ih = { 0, JLabel.LEFT, JLabel.CENTER };
		// ������ǩ�ڴ�ֱ�����ϵĶ��뷽ʽ
		int[] iv = { 0, JLabel.CENTER, JLabel.BOTTOM };
		Container c = getContentPane();// ȡ�ô��ڵ��������
		c.setLayout(new FlowLayout(FlowLayout.LEFT)); // ���ò��ֹ�����
		for (int i = 0; i < 3; i++) {
			// ����������ǩ
			JLabel myLabel = new JLabel(s[i], ic[i], JLabel.LEFT);
			if (i > 0) {
				myLabel.setHorizontalTextPosition(ih[i]);
				myLabel.setVerticalTextPosition(iv[i]);
			}
			// ���ñ߿�, setBorder����JLabel�ĸ���JComponent
			myLabel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			myLabel.setToolTipText("��" + (i + 1) + "����ǩ");
			// ���뵽���ڵ����������
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

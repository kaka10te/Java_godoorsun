package zjut.java.ch9;

import java.awt.*;
import javax.swing.*;

public class TestJButton extends JFrame {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	TestJButton(String sTitle) {
		super(sTitle);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		// ������ť�ϵ�ͼ��
		ImageIcon[] ic = { new ImageIcon("new.gif"), new ImageIcon("open.gif") };
		// ������ť
		JButton[] btn = { new JButton("�½�", ic[0]), new JButton("�м�"), new JButton("��", ic[1]) };
		int i;
		for (i = 0; i < btn.length; i++)
			c.add(btn[i]);
		// btn[0]��������ͼ�����
		btn[0].setHorizontalTextPosition(SwingConstants.LEFT);
		// ������ѡ��
		JCheckBox[] ck = { new JCheckBox("��"), new JCheckBox("��") };
		for (i = 0; i < ck.length; i++) {
			c.add(ck[i]);
			ck[i].setSelected(true);// ����ѡ������Ϊѡ��״̬
		}
		// ������ѡ��
		JRadioButton[] r = { new JRadioButton("��"), new JRadioButton("��") };
		ButtonGroup rg = new ButtonGroup();
		for (i = 0; i < r.length; i++) {
			c.add(r[i]);
			rg.add(r[i]);// ���ButtonGroup����������ֻ��ͬʱѡ��һ��
		}
		// ���õ�ѡ���ѡ��״̬
		r[0].setSelected(false);
		r[1].setSelected(true);

		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		TestJButton frm = new TestJButton("JFrame with JButton");
		frm.setVisible(true);
	}
}

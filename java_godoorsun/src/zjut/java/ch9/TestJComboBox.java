package zjut.java.ch9;

import java.awt.*;
import javax.swing.*;

public class TestJComboBox extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// �������С������
	JComboBox<Object> cbxFont = new JComboBox<Object>();
	JComboBox<String> cbxFontSize = new JComboBox<String>();// �����С

	TestJComboBox(String sTitle) {
		super(sTitle);

		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.LEFT));

		c.add(new JLabel("�������ƣ�"));
		c.add(cbxFont);
		c.add(new JLabel("�����С��"));
		c.add(cbxFontSize);
		
		// ��ʼ���������С������
		InitFonts();

		setSize(300, 140);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// ��ʼ�������
	@SuppressWarnings("deprecation")
	private void InitFonts() {
		// ���ϵͳ����������
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fontList = ge.getAvailableFontFamilyNames();
		int i;

		// �����������
		for (i = 0; i < fontList.length; i++)
			cbxFont.addItem(String.valueOf(i) + "  |  " + fontList[i]);

		cbxFont.setSelectedIndex(231);// ѡ��indexΪ231����
		// ��������С
		for (i = 9; i <= 72; i++)
			cbxFontSize.addItem(new Integer(i).toString());
		cbxFontSize.setSelectedIndex(3);// ѡ��indexΪ3����
	}

	public static void main(String args[]) {
		TestJComboBox frm = new TestJComboBox("JFrame with JComboBox");
		frm.setVisible(true);
	}
}

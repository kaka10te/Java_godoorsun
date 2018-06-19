
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TestJComboBox extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// �������С������
	JComboBox<Object> cbxFont = new JComboBox<Object>();
	JComboBox<String> cbxFontSize = new JComboBox<String>();// �����С
	JButton yesbtn = new JButton("ȷ��");
	JButton cancelbtn = new JButton("ȡ��");
	static Font selectFont; 

	public Font getSelectFont() {
		return selectFont;
	}

	public void setSelectFont(Font selectFont) {
		TestJComboBox.selectFont = selectFont;
	}

	TestJComboBox(String sTitle) {
		super();

		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.LEFT));
		c.add(new JLabel("�������ƣ�"));
		c.add(cbxFont);
		c.add(new JLabel("�����С��"));
		c.add(cbxFontSize);
		c.add(yesbtn);
		c.add(cancelbtn);
		cancelbtn.addActionListener(this);
		yesbtn.addActionListener(this);
		// ��ʼ���������С������
		setVisible(true);
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
			cbxFont.addItem(fontList[i]);

		cbxFont.setSelectedIndex(231);// ѡ��indexΪ231����
		// ��������С
		for (i = 9; i <= 72; i++)
			cbxFontSize.addItem(new Integer(i).toString());
		cbxFontSize.setSelectedIndex(3);// ѡ��indexΪ3����
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// System.out.println(ta.getFont());
		if(e.getSource()==yesbtn) {
			String fontname = cbxFont.getSelectedItem().toString();
			int sizeFont = Integer.parseInt(cbxFontSize.getSelectedItem().toString());
			selectFont = new Font(fontname,Font.PLAIN,sizeFont);
			TestJFrameExtends.getTa().setFont(selectFont);
			dispose();
		}
		if(e.getSource()==cancelbtn) {
			dispose();
		}
		// System.out.println(ta.getFont());
	}
}

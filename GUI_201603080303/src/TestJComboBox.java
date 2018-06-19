
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TestJComboBox extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 字体与大小下拉框
	JComboBox<Object> cbxFont = new JComboBox<Object>();
	JComboBox<String> cbxFontSize = new JComboBox<String>();// 字体大小
	JButton yesbtn = new JButton("确认");
	JButton cancelbtn = new JButton("取消");
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
		c.add(new JLabel("字体名称："));
		c.add(cbxFont);
		c.add(new JLabel("字体大小："));
		c.add(cbxFontSize);
		c.add(yesbtn);
		c.add(cancelbtn);
		cancelbtn.addActionListener(this);
		yesbtn.addActionListener(this);
		// 初始化字体与大小下拉框
		setVisible(true);
		InitFonts();
		setSize(300, 140);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// 初始化字体框
	@SuppressWarnings("deprecation")
	private void InitFonts() {
		// 获得系统的字体数组
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fontList = ge.getAvailableFontFamilyNames();
		int i;

		// 添加字体名称
		for (i = 0; i < fontList.length; i++)
			cbxFont.addItem(fontList[i]);

		cbxFont.setSelectedIndex(231);// 选择index为231的项
		// 添加字体大小
		for (i = 9; i <= 72; i++)
			cbxFontSize.addItem(new Integer(i).toString());
		cbxFontSize.setSelectedIndex(3);// 选择index为3的项
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

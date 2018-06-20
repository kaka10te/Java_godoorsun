import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class FontDialog extends JDialog implements ActionListener {
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
		FontDialog.selectFont = selectFont;
	}

	FontDialog(String sTitle) {
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

		// ����
		int windowW = 300;
		int windowH = 140;
		Dimension tool = Toolkit.getDefaultToolkit().getScreenSize();
		int screenW = tool.width;
		int screenH = tool.height;
		this.setLocation(screenW / 2 - windowW / 2, screenH / 2 - windowH / 2);

		this.setSize(300, 140);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
		if (e.getSource() == yesbtn) {
			String fontname = cbxFont.getSelectedItem().toString();
			int sizeFont = Integer.parseInt(cbxFontSize.getSelectedItem().toString());
			selectFont = new Font(fontname, Font.PLAIN, sizeFont);
			Notebook.getTa().setFont(selectFont);
		}
		if (e.getSource() == cancelbtn) {
			dispose();
		}
		// System.out.println(ta.getFont());
	}
}

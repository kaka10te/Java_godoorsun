package zjut.java.ch9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestKeyListener extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	TestKeyListener(String sTitle) {
		super(sTitle);
		Container c = getContentPane();
		c.setLayout(new GridLayout(4, 1, 2, 2));
		// ѡ���ɫ
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel1.add(new JLabel("ѡ���ɫ��"));
		JComboBox<String> jcb = new JComboBox<String>();
		jcb.addItem("��ʦ");
		jcb.addItem("ѧ��");
		jcb.setSelectedIndex(1);
		panel1.add(jcb);
		c.add(panel1);
		// ����ѧ��
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2.add(new JLabel("����ѧ�ţ�"));
		FgTextField txtNum = new FgTextField("", 15, true);
		panel2.add(txtNum);
		c.add(panel2);
		// ��������
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel3.add(new JLabel("�������룺"));
		panel3.add(new JPasswordField("", 15));
		c.add(panel3);
		// ��¼��ť
		JPanel panel4 = new JPanel();
		panel4.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panel4.add(new JButton("��¼"));
		panel4.add(new JButton("ȡ��"));
		c.add(panel4);
	}

	public static void main(String args[]) {
		TestKeyListener f = new TestKeyListener("�����¼�");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}
}

// �Զ��嵥���ı��򣬴�JTextField�̳й���
class FgTextField extends JTextField {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	boolean m_bOnlyInteger;// ����ָʾ�Ƿ�ֻ������������

	FgTextField(String sText, int columns, boolean bOnlyInteger) {
		super(sText, columns);

		m_bOnlyInteger = bOnlyInteger;
		addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (m_bOnlyInteger) {
					char c = e.getKeyChar();
					if (c < '0' | c > '9')
						e.consume(); // ȡ������
				}
			}
		});
	}
}

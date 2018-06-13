package zjut.java.ch9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestCardLayout implements MouseListener {
	CardLayout layout = new CardLayout();
	JFrame f = new JFrame("JFrame with CardLayout");
	Container c;
	JButton page1Button;
	JLabel page2Label; // ��ǩ,һ���ı�
	JTextArea page3Text; // ���ж��е��ı�����
	JButton page3Top;
	JButton page3Bottom;

	public static void main(String args[]) {
		TestCardLayout frm = new TestCardLayout();
		frm.show();
	}

	public void mouseClicked(MouseEvent arg0) {
		layout.next(c);
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}

	public void show() {
		c = f.getContentPane();
		c.setLayout(layout); // ����ΪCardLayout
		// ��һ��Card����һ��JButton
		c.add(page1Button = new JButton("1st Card: Button page"), "page1Button");
		page1Button.addMouseListener(this); // ע�������
		// �ڶ���Card����һ��JLabel
		c.add(page2Label = new JLabel("2nd Card: Label page"), "page2Label");
		page2Label.addMouseListener(this); // ע�������

		// ������Card��һ��JPanel�������JPanel���ַ���һ��JTextArea������JButton
		JPanel pan = new JPanel();
		pan.setLayout(new BorderLayout());
		pan.add(page3Text = new JTextArea("3rd Card: Composite page"), "Center");
		page3Text.addMouseListener(this);
		pan.add(page3Top = new JButton("Top button"), "North");
		page3Top.addMouseListener(this);
		pan.add(page3Bottom = new JButton("Bottom button"), "South");
		page3Bottom.addMouseListener(this);
		c.add(pan, "panel");

		f.setSize(180, 120);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}

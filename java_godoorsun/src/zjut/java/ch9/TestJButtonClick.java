package zjut.java.ch9;

import java.awt.event.*;//�ڢٲ��������¼���
import java.awt.*;
import javax.swing.*;

//�ڢڲ���������implementsĳ���������ӿ�
public class TestJButtonClick implements ActionListener {// �¼����������¼�Դ����ͬһ����
	public TestJButtonClick() {
		JFrame f = new JFrame("������ť�¼�");
		Container c = f.getContentPane();
		JButton b = new JButton("Press Me!");
		b.addActionListener(this);// �ڢ۲���ע�������
		c.add(b, "Center");

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(200, 100);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {// �ڢܲ�����������μ���
		// e.getActionCommand()���������¼�Դ������
		JOptionPane.showMessageDialog(null, "�����˰�ť\"" + e.getActionCommand() + "\"", "��ʾ",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static void main(String args[]) {
		new TestJButtonClick();
	}
}

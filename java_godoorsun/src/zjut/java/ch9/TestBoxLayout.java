package zjut.java.ch9;

import java.awt.*;
import javax.swing.*;

public class TestBoxLayout {
	public static void main(String[] args) {
		JPanel jp = new JPanel();
		// ��岼������ΪBoxLayout����Y����ϵ�������
		jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
		// ��JTextArea��JButton��ӵ������
		JTextArea testArea = new JTextArea("This is a multiple text field", 4, 20);
		JButton button = new JButton("This is a button");
		jp.add(testArea);
		jp.add(button);
		// ����JTextArea���ұ���JButton����߶���
		testArea.setAlignmentX(Component.RIGHT_ALIGNMENT);
		button.setAlignmentX(Component.LEFT_ALIGNMENT);

		JFrame frm = new JFrame("JFrame with BoxLayout");
		frm.setContentPane(jp);// �滻��Ĭ�ϵ��������
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setSize(400, 200);
		frm.setVisible(true);
	}
}

package zjut.java.ch9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MousePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x_pos, y_pos;

	MousePanel() {
		// ע������¼���������������������ʵ���¼��������
		// ע�⣬����ʵ��(����)�ӿ��е�ȫ������������ʵ�ִ���һ��Ҳû��
		
		//�����̳�MouseAdapter��
		addMouseListener(new MouseAdapter(){
		public void mousePressed(MouseEvent e){
		x_pos=e.getX();
		y_pos=e.getY();
		repaint();
		}
		});
//		addMouseListener(new MouseListener() {
//			public void mouseClicked(MouseEvent e) {
//			}
//
//			public void mouseEntered(MouseEvent e) {
//			}
//
//			public void mouseExited(MouseEvent e) {
//			}
//
//			public void mouseReleased(MouseEvent e) {
//			}
//
//			public void mousePressed(MouseEvent e) {
//				x_pos = e.getX();
//				y_pos = e.getY();
//				repaint();// ���������Զ�����paintComponent����������
//			}
//		});
		
		// ע������ƶ��¼���������������������ʵ���¼��������
//		addMouseMotionListener(new MouseMotionListener() {
//			public void mouseDragged(MouseEvent e) {
//			}
//
//			public void mouseMoved(MouseEvent e) {
//				x_pos = e.getX();
//				y_pos = e.getY();
//				repaint();// ���������Զ�����paintComponent����������
//			}
//		});
		//�����̳�MouseMotionAdapter��
		addMouseMotionListener(new MouseMotionAdapter(){
		public void mouseMoved(MouseEvent e){
		x_pos=e.getX();
		y_pos=e.getY();
		repaint();
		}
		});

	}

	// ���Ǹ����paintComponent�����Ի��Ƶ�ǰ��������
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("��ǰλ�ã�[" + x_pos + ", " + y_pos + "]", x_pos, y_pos);
	}
}

public class TestMouseListener extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	TestMouseListener() {
		super("���λ��");
		setContentPane(new MousePanel());
	}

	public static void main(String args[]) {
		TestMouseListener f = new TestMouseListener();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300, 180);
		f.setVisible(true);
	}
}

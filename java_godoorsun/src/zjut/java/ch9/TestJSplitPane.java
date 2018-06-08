package zjut.java.ch9;

import java.awt.Container;

import javax.swing.*;

public class TestJSplitPane {
	public static void main(String args[]){
		JFrame fr = new JFrame("JFrame with JSplitPane");
		Container c = fr.getContentPane();		
		JPanel leftPane = new JPanel();//�����
		JPanel rightPane = new JPanel();//�����
		//����ˮƽ�ָ���������Ϊ����������
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,	leftPane,rightPane); 
		sp.setDividerSize(5);  //���÷ָ�������Ŀ��Ϊ5������	
		leftPane.add(new JButton("left button"));       //����ť��ӵ���ߵ����
		rightPane.add(new JButton("right button"));   //����ť��ӵ��ұߵ����
		c.add(sp);//���ָ���(��������������ť�����)��ӵ�������		
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setSize(400,300);	
		fr.setVisible(true);
		//������������setVisible֮�󣬷��򲻻���Ч��
		sp.setDividerLocation(0.3);  //���ռ0.3(30%)���ұ�ռ0.7(70%)
		}
}

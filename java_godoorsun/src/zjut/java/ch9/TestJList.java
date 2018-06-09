package zjut.java.ch9;

import java.awt.*;
import javax.swing.*;

public class TestJList extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// �����б�����
	JList<Object> listNames = new JList<Object>();

	TestJList(String sTitle) {
		super(sTitle);
		
		Container c = getContentPane();
		// ������䱣֤�б�����ݽ϶�ʱ����ֹ�����
		JScrollPane scrollPane = new JScrollPane(listNames);
		c.add(scrollPane);
		// ��ʼ���б��
		InitList();
		setSize(250, 150);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// ��ʼ���б��
	private void InitList() {
		String[] names = { "201126100101 - �ܵ���", "201126100111 - ���", "201126100128 - �컪��", "201126100131 - Ҧ��ƽ",
				"201126100202 - ��˼��", "201126100207 - ���", "201126100210 - ��һ��", "201126100211 - ����ΰ" };
		// ����������б��
		listNames.setListData(names);
		// ��1��3����(201126100111��201126100131)����Ϊѡ��״̬
		listNames.setSelectedIndices(new int[] { 1, 3 });
	}

	public static void main(String args[]) {
		TestJList frm = new TestJList("JFrame with JList");
		frm.setVisible(true);
	}
}

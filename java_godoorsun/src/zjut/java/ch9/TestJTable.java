package zjut.java.ch9;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.GridLayout;

public class TestJTable {
	public static void main(String[] args) {
		JTable table1 = new JTable(12, 6);// 12��6�еĿձ��
		// ���������������ݣ��������������final����
		final Object[] columnNames = { "����", "�Ա�", "��ͥ��ַ", "�绰����", "����" };
		Object[][] rowData = { { "�Ź�ΰ", "��", "�㽭����", "1378313210", "1985-03-24" },
				{ "Ҷ��", "Ů", "�㽭��", "13645181705", "1985-05-05" }, { "�̳�", "��", "�����Ͼ�", "13585331486", "1985-12-08" },
				{ "����", "Ů", "�㽭����", "81513779", "1986-10-01" }, { "����", "��", "�㽭����", "13651545936", "1985-12-25" } };
		// �������
		JTable table2 = new JTable(rowData, columnNames);
		// ���ñ������
		table2.setRowHeight(30);// ����ÿ�еĸ߶�Ϊ30
		table2.setRowHeight(0, 20);// ���õ�1�еĸ߶�Ϊ20����Ϊ����
		table2.setRowMargin(5);// �����������еľ���
		table2.setRowSelectionAllowed(true);// ���ÿɷ�ѡ��Ĭ��Ϊfalse
		table2.setSelectionBackground(Color.BLUE);// ������ѡ���еı�����ɫ
		table2.setSelectionForeground(Color.WHITE);// ������ѡ���е�ǰ��ɫ
		table2.setGridColor(Color.BLACK);// ���������ߵ���ɫ
		table2.setRowSelectionInterval(0, 2);// ���ó�ʼ��ѡ����(1��3��)
		table2.setShowHorizontalLines(false);// �Ƿ���ʾˮƽ��������
		table2.setShowVerticalLines(true);// �Ƿ���ʾ��ֱ��������
		table2.setValueAt("������", 0, 0);// ����ĳ����Ԫ���ֵ,���ֵ��һ������
		table2.doLayout();
		table2.setBackground(Color.lightGray);// ���ñ�񱳾�ɫ
		// ���ñ��Ĵ�С
		table2.setPreferredScrollableViewportSize(new Dimension(600, 100));
		// ���������н�Ҫ�õ������
		JScrollPane pane1 = new JScrollPane(table1);
		JScrollPane pane2 = new JScrollPane(table2);
		JPanel pan = new JPanel(new GridLayout(0, 1));
		pan.setPreferredSize(new Dimension(600, 250));
		pan.setBackground(Color.black);
		pan.add(pane1);
		pan.add(pane2);
		// ��������
		JFrame frm = new JFrame("JFrame with JTable");
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setContentPane(pan);
		frm.pack();
		frm.setVisible(true);
	}
}

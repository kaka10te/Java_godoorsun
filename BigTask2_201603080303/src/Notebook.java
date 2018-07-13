
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.URLDecoder;
import java.util.*;

import javax.swing.*;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.*;

public class Notebook extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -944866368833071815L;
	// **********************************************************
	static String[] columnNames = { "author", "title", "journal", "booktitle", "volume", "number", "pages", "year" };
	Object[][] rowData = new Object[150][8];
	static JTable table;
	static JScrollPane sp;
	static int rowNum;
	static JMenuBar mb = new JMenuBar();// �˵���
	static JToolBar mtb = new JToolBar();// ������
	static JMenuItem miOpen = new JMenuItem("��(O)...", KeyEvent.VK_O), miSave = new JMenuItem("����(S)", KeyEvent.VK_S);
	static FgMenu mFile = new FgMenu("�ļ�(F)", KeyEvent.VK_F);// "�ļ�"�˵�
	static HashMap<String, Integer> articleMap = new HashMap<String, Integer>();
	// ************************************************************

	Notebook(String sTitle) {

		super(sTitle);
		addMenus();
		try {
			articleMap.put("author", 0);
			articleMap.put("title", 1);
			articleMap.put("journal", 2);
			articleMap.put("booktitle", 3);
			articleMap.put("volume", 4);
			articleMap.put("number", 5);
			articleMap.put("pages", 6);
			articleMap.put("year", 7);

			miOpen.addActionListener(this);
			miSave.addActionListener(this);
			setSize(800, 600);
			centerWindow();
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		// �ڢܲ�����������μ���
		// e.getActionCommand()���������¼�Դ������
		if (e.getSource() == miOpen) {// �����˰�ťopen
			openBibFile();
		} else if (e.getSource() == miSave) {
			try {
				new ExcelWriter(rowData,columnNames,rowNum);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	//openѡ���bib�ļ�
	private void openBibFile() {
		JFileChooser fd = new JFileChooser();
		fd.showOpenDialog(null);
		File f = fd.getSelectedFile();
		String FileInputTrace = f.getAbsolutePath();
		try {
			BufferedReader readstufile = new BufferedReader(
					new InputStreamReader(new FileInputStream(FileInputTrace)));
			String aa;
			int i = 0;
			while ((aa = readstufile.readLine()) != null) {
				String a = URLDecoder.decode(aa, "utf-8");
				if (a.isEmpty())
					continue;
				String[] ss = a.split("\\{");
				if (ss[0].equals("@article") || ss[0].equals("@inproceedings")) {
					String b;
					for (int ii = 0; ii < 8; ii++) {// ��ʼ����һ��
						rowData[i][ii] = " ";
					}
					while ((b = readstufile.readLine()) != null) {
						if (b.equals("}"))
							break;
						String[] item = b.split("=");
						String item0 = item[0].trim();
						if (articleMap.containsKey(item0)) {
							int value = articleMap.get(item0);
							int begin = 1;
							if (value == 1)
								begin = 2;
							int end = item[1].lastIndexOf("}");
							if (value == 1)
								end = end - 1;
							rowData[i][value] = item[1].substring(begin + 1, end);
						}
					}
					i++;// i��¼������Ŀ��������
				}
			}
			rowNum = i;
			table = new JTable(rowData, columnNames);
			JScrollPane sp = new JScrollPane(table);
			sp.setViewportView(table);
			this.add(sp);
			this.setVisible(true);

			readstufile.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	// ���ھ���
	public void centerWindow() {
		// �����ʾ�����洰�ڵĴ�С
		Toolkit tk = getToolkit();
		Dimension dm = tk.getScreenSize();
		// �ô��ھ�����ʾ
		setLocation((int) (dm.getWidth() - getWidth()) / 2, (int) (dm.getHeight() - getHeight()) / 2);
	}

	// ��Ӳ˵�
	private void addMenus() {
		setJMenuBar(mb);
		mFile.add(miOpen);// ��
		mFile.addSeparator();// �ָ���
		mFile.add(miSave);// ����
		mb.add(mFile); // ��"�ļ�"�˵���ӵ��˵�����
	}
}
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URLDecoder;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class Notebook extends JFrame implements ActionListener{


	/**
	 * 
	 */
	private static final long serialVersionUID = -944866368833071815L;
	// **********************************************************
	// ����Ϊ��Ա���������󣩵Ķ���
	static FgButton[] btn = { new FgButton(new ImageIcon(ImageScaling.zoom("new.png", 0.1)), "�½��ļ�"),
			new FgButton(new ImageIcon(ImageScaling.zoom("open.png", 0.1)), "���ļ�"),
			new FgButton(new ImageIcon(ImageScaling.zoom("save.png", 0.2)), "�����ļ�") };

	static JMenuBar mb = new JMenuBar();// �˵���
	static JToolBar mtb = new JToolBar();// ������
	static FgMenu mFile = new FgMenu("�ļ�(F)", KeyEvent.VK_F);// "�ļ�"�˵�
	static JTextArea ta = new JTextArea();// �ı���
	static JMenuItem miNew = new JMenuItem("�½�(N)", KeyEvent.VK_N), miOpen = new JMenuItem("��(O)...", KeyEvent.VK_O),
			miSave = new JMenuItem("����(S)", KeyEvent.VK_S), miFont = new JMenuItem("��������ɫ(F)...", KeyEvent.VK_F),
			miQuit = new JMenuItem("�˳�(X)", KeyEvent.VK_X);
	static JScrollPane sp;
	static int flag = 0;
	// �٣��������ڶ���

	// ************************************************************

	Notebook(String sTitle) {

		super(sTitle);
		// �ڣ�������������ֱ����Ӳ˵���JTextArea
		addMenus();
		// ��Ӵ�������(JScrollPane)���ı��༭��JTextArea
		String stuFile = "ѧ����Ϣencoded.txt";
		readFile(stuFile);
		ta.setLineWrap(true);// �Զ�����
		sp = new JScrollPane(ta);
		add(sp);
		// �ۣ����ô��ڴ�С
		setSize(800, 600);
		// ����close��ť�Ĳ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ʹ��������ʾ��������ʾ
		centerWindow();
		addToolBar();
		// �ı䴰��ͼ��
		Toolkit tk = getToolkit(); // �õ�һ��Toolkit����
		Image icon = tk.getImage("online.gif"); // ��ȡͼ��
		setIconImage(icon);

		btn[0].addActionListener(this);
		btn[1].addActionListener(this);
		btn[2].addActionListener(this);
		miNew.addActionListener(this);
		miOpen.addActionListener(this);
		miSave.addActionListener(this);
		miFont.addActionListener(this);
		miQuit.addActionListener(this);
		ta.addKeyListener(new KeyAdapter() {// ����
			public void keyTyped(KeyEvent e) {
				flag = 1;
			}
		});
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "�Ƿ񽫸��ĵ��ļ����棿", "���±�",
						JOptionPane.YES_NO_CANCEL_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					miSave.doClick();
				} else if (result == JOptionPane.CANCEL_OPTION) {
					return;
				}

			}
		});
	}

	public void readFile(String FileTrace) {
		try {
			BufferedReader readstufile = new BufferedReader(new InputStreamReader(new FileInputStream(FileTrace)));
			String a;
			while ((a = readstufile.readLine()) != null) {
				String sd = URLDecoder.decode(a, "utf-8");
				ta.append(sd);
				ta.append("\n");
			}
			readstufile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		// �ڢܲ�����������μ���
		// e.getActionCommand()���������¼�Դ������
		if (e.getSource() == miQuit) {
			if (flag == 1) {

				flag = 0;// ��λflag
				int result = JOptionPane.showConfirmDialog(null, "�Ƿ񽫸��ĵ��ļ����棿", "���±�",
						JOptionPane.YES_NO_CANCEL_OPTION);

				if (result == JOptionPane.YES_OPTION) {
					miSave.doClick();
				} else if (result == JOptionPane.CANCEL_OPTION) {
					return;
				}
				System.exit(0);

			}
			System.exit(1);
		}
		if (e.getSource() == btn[0] || e.getSource() == miNew) {// �����˰�ťnew
			ta.setText("");
		} else if (e.getSource() == btn[1] || e.getSource() == miOpen) {// �����˰�ťopen
			JFileChooser fd = new JFileChooser();
			fd.showOpenDialog(null);
			File f = fd.getSelectedFile();
			String FileInputTrace = f.getAbsolutePath();
			try {
				BufferedReader readstufile = new BufferedReader(
						new InputStreamReader(new FileInputStream(FileInputTrace)));
				String a;
				ta.setText("");
				while ((a = readstufile.readLine()) != null) {
					String sd = URLDecoder.decode(a, "utf-8");
					ta.append(sd);
					ta.append("\n");
				}
				readstufile.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == btn[2] || e.getSource() == miSave) {// �����˰�ťsave
			JFileChooser fd = new JFileChooser();
			fd.showSaveDialog(null);
			File f = fd.getSelectedFile();
			String FileOutputTrace = f.getAbsolutePath();
			try {
				BufferedWriter Outfile = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(FileOutputTrace)));
				Outfile.write(ta.getText());
				Outfile.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == miFont) {
			new FontDialog("����ѡ��");
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

	private void addToolBar() {
		// ������
		Container c = getContentPane();
		c.add(BorderLayout.NORTH, mtb);
		mtb.setLayout(new FlowLayout(FlowLayout.LEFT));
		for (int i = 0; i < btn.length; i++) {
			btn[i].setBorder(BorderFactory.createEmptyBorder());
			mtb.add(btn[i]);
		}
		// ���ò��ɸ���
		mtb.setFloatable(false);
	}

	// ��Ӳ˵�
	private void addMenus() {
		setJMenuBar(mb);
		mFile.add(miNew);// �½�
		mFile.add(miOpen);// ��
		mFile.add(miSave);// ����
		mFile.addSeparator();// �ָ���
		mFile.add(miFont);// ��������ɫ�˵�
		mFile.addSeparator();// �ָ���
		mFile.add(miQuit);// �˳�
		mb.add(mFile); // ��"�ļ�"�˵���ӵ��˵�����
	}

	public static JTextArea getTa() {
		return ta;
	}

	public static void setTa(JTextArea ta) {
		Notebook.ta = ta;
	}
}

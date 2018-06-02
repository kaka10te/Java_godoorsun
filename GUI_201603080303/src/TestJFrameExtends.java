
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.URLDecoder;

import javax.swing.*;

public class TestJFrameExtends extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -944866368833071815L;
	// **********************************************************
	// ����Ϊ��Ա���������󣩵Ķ���
	static JMenuBar mb = new JMenuBar();// �˵���
	static JToolBar mtb = new JToolBar();// ������
	static FgMenu mFile = new FgMenu("�ļ�(F)", KeyEvent.VK_F);// "�ļ�"�˵�
	static JTextArea ta = new JTextArea();// �ı���
	static JMenuItem miNew = new JMenuItem("�½�(N)", KeyEvent.VK_N), miOpen = new JMenuItem("��(O)...", KeyEvent.VK_O),
			miSave = new JMenuItem("����(S)", KeyEvent.VK_S), miFont = new JMenuItem("��������ɫ(F)...", KeyEvent.VK_F),
			miQuit = new JMenuItem("�˳�(X)", KeyEvent.VK_X);
	// ************************************************************
	TestJFrameExtends(String sTitle){
		super(sTitle);
		// �ڣ�������������ֱ����Ӳ˵���JTextArea
		addMenus();
		// ��Ӵ�������(JScrollPane)���ı��༭��JTextArea
//		ta.append("hello world");
		readFile();
		ta.setLineWrap(true);//�Զ�����
		JScrollPane sp = new JScrollPane(ta);
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
	}

	private void readFile() {
		String stuFile = "ѧ����Ϣencoded.txt";
		try {
			BufferedReader readstufile = new BufferedReader(
					new InputStreamReader(new FileInputStream(stuFile)));
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
	private void addToolBar(){
		//������
		Container c=getContentPane();
		c.add(BorderLayout.NORTH, mtb);
						
		mtb.setLayout(new FlowLayout(FlowLayout.LEFT));
		FgButton[] btn={new FgButton(new ImageIcon (ImageScaling.zoom("new.png",0.1)),"�½��ļ�"),
		 new FgButton(new ImageIcon(ImageScaling.zoom("open.png",0.1)),"���ļ�"),
		 new FgButton(new ImageIcon(ImageScaling.zoom("save.png",0.1)),"�����ļ�")};
				
		for(int i=0;i<btn.length;i++){			
		btn[i].setBorder(BorderFactory.createEmptyBorder());
		mtb.add(btn[i]);
		}
		//���ò��ɸ���
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

	// ���ھ���
	public void centerWindow() {
		// �����ʾ�����洰�ڵĴ�С
		Toolkit tk = getToolkit();
		Dimension dm = tk.getScreenSize();
		// �ô��ھ�����ʾ
		setLocation((int) (dm.getWidth() - getWidth()) / 2, (int) (dm.getHeight() - getHeight()) / 2);
	}

	public static void main(String args[]) {
		// �٣��������ڶ���
		TestJFrameExtends frm = new TestJFrameExtends("���±�");
		// �ܣ���ʾ����
		frm.setVisible(true);
	}
}

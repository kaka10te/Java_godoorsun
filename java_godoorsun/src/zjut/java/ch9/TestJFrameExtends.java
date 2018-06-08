package zjut.java.ch9;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;


public class TestJFrameExtends extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ����Ϊ��Ա���������󣩵Ķ���
	// �˴�����˵�(��TestJFrameDirect.java��һ��)
	static JMenuBar mb = new JMenuBar();// �˵���
	static JToolBar	mtb=new JToolBar();//���ߙ�
	static FgMenu mFile = new FgMenu("�ļ�(F)", KeyEvent.VK_F);// "�ļ�"�˵�
	static JMenuItem miNew = new JMenuItem("�½�(N)", KeyEvent.VK_N), miOpen = new JMenuItem("��(O)...", KeyEvent.VK_O),
			miSave = new JMenuItem("����(S)", KeyEvent.VK_S), miFont = new JMenuItem("��������ɫ(F)...", KeyEvent.VK_F),
			miQuit = new JMenuItem("�˳�(X)", KeyEvent.VK_X);
	JTextArea ta = new JTextArea();// �ı���

	TestJFrameExtends(String sTitle) {
		super(sTitle);
		// �ڣ�������������ֱ����Ӳ˵���JTextArea
		addMenus();
		addToolBar();//���ߙ�
		// ��Ӵ�������(JScrollPane)���ı��༭��JTextArea
		JScrollPane sp = new JScrollPane(ta);
		add(sp);
		// �ۣ����ô��ڴ�С
		setSize(400, 300);
		// ����close��ť�Ĳ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ʹ��������ʾ��������ʾ
		centerWindow();
		// �ı䴰��ͼ��
		Toolkit tk = getToolkit(); // �õ�һ��Toolkit����
		Image icon = tk.getImage("car.gif"); // ��ȡͼ��
		setIconImage(icon);
	}
	
	private void addToolBar(){
		//������
		Container c=getContentPane();
		c.add(BorderLayout.NORTH, mtb);
						
		mtb.setLayout(new FlowLayout(FlowLayout.LEFT));
		FgButton[] btn={new FgButton(new ImageIcon ("new.png"),"�½��ļ�"),
		 new FgButton(new ImageIcon("open.png"),"���ļ�"),
		 new FgButton(new ImageIcon("save.png"),"�����ļ�")};
				
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
		TestJFrameExtends frm = new TestJFrameExtends("�����ҵ���һ��java���ڳ���");
		// �ܣ���ʾ����
		frm.setVisible(true);
	}
}
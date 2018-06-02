
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
	// 以下为成员变量（对象）的定义
	static JMenuBar mb = new JMenuBar();// 菜单栏
	static JToolBar mtb = new JToolBar();// 工具栏
	static FgMenu mFile = new FgMenu("文件(F)", KeyEvent.VK_F);// "文件"菜单
	static JTextArea ta = new JTextArea();// 文本框
	static JMenuItem miNew = new JMenuItem("新建(N)", KeyEvent.VK_N), miOpen = new JMenuItem("打开(O)...", KeyEvent.VK_O),
			miSave = new JMenuItem("保存(S)", KeyEvent.VK_S), miFont = new JMenuItem("字体与颜色(F)...", KeyEvent.VK_F),
			miQuit = new JMenuItem("退出(X)", KeyEvent.VK_X);
	// ************************************************************
	TestJFrameExtends(String sTitle){
		super(sTitle);
		// ②：添加组件。本例直接添加菜单与JTextArea
		addMenus();
		// 添加带滚动条(JScrollPane)的文本编辑框JTextArea
//		ta.append("hello world");
		readFile();
		ta.setLineWrap(true);//自动换行
		JScrollPane sp = new JScrollPane(ta);
		add(sp);
		// ③：设置窗口大小
		setSize(800, 600);
		// 设置close按钮的操作
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 使窗口在显示屏居中显示
		centerWindow();

		addToolBar();

		// 改变窗口图标
		Toolkit tk = getToolkit(); // 得到一个Toolkit对象
		Image icon = tk.getImage("online.gif"); // 获取图标
		setIconImage(icon);
	}

	private void readFile() {
		String stuFile = "学生信息encoded.txt";
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
		//工具条
		Container c=getContentPane();
		c.add(BorderLayout.NORTH, mtb);
						
		mtb.setLayout(new FlowLayout(FlowLayout.LEFT));
		FgButton[] btn={new FgButton(new ImageIcon (ImageScaling.zoom("new.png",0.1)),"新建文件"),
		 new FgButton(new ImageIcon(ImageScaling.zoom("open.png",0.1)),"打开文件"),
		 new FgButton(new ImageIcon(ImageScaling.zoom("save.png",0.1)),"保存文件")};
				
		for(int i=0;i<btn.length;i++){			
		btn[i].setBorder(BorderFactory.createEmptyBorder());
		mtb.add(btn[i]);
		}
		//设置不可浮动
		mtb.setFloatable(false);
		}

	// 添加菜单
	private void addMenus() {
		setJMenuBar(mb);
		mFile.add(miNew);// 新建
		mFile.add(miOpen);// 打开
		mFile.add(miSave);// 保存
		mFile.addSeparator();// 分割条
		mFile.add(miFont);// 字体与颜色菜单
		mFile.addSeparator();// 分割条
		mFile.add(miQuit);// 退出
		mb.add(mFile); // 将"文件"菜单添加到菜单栏上
	}

	// 窗口居中
	public void centerWindow() {
		// 获得显示屏桌面窗口的大小
		Toolkit tk = getToolkit();
		Dimension dm = tk.getScreenSize();
		// 让窗口居中显示
		setLocation((int) (dm.getWidth() - getWidth()) / 2, (int) (dm.getHeight() - getHeight()) / 2);
	}

	public static void main(String args[]) {
		// ①：创建窗口对象
		TestJFrameExtends frm = new TestJFrameExtends("记事本");
		// ④：显示窗口
		frm.setVisible(true);
	}
}

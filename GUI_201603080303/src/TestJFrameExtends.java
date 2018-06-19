
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.URLDecoder;

import javax.swing.*;

public class TestJFrameExtends extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -944866368833071815L;
	// **********************************************************
	// 以下为成员变量（对象）的定义
	static FgButton[] btn = { new FgButton(new ImageIcon(ImageScaling.zoom("new.png", 0.1)), "新建文件"),
			new FgButton(new ImageIcon(ImageScaling.zoom("open.png", 0.1)), "打开文件"),
			new FgButton(new ImageIcon(ImageScaling.zoom("save.png", 0.2)), "保存文件") };

	static JMenuBar mb = new JMenuBar();// 菜单栏
	static JToolBar mtb = new JToolBar();// 工具栏
	static FgMenu mFile = new FgMenu("文件(F)", KeyEvent.VK_F);// "文件"菜单
	static JTextArea ta = new JTextArea();// 文本框
	static JMenuItem miNew = new JMenuItem("新建(N)", KeyEvent.VK_N), miOpen = new JMenuItem("打开(O)...", KeyEvent.VK_O),
			miSave = new JMenuItem("保存(S)", KeyEvent.VK_S), miFont = new JMenuItem("字体与颜色(F)...", KeyEvent.VK_F),
			miQuit = new JMenuItem("退出(X)", KeyEvent.VK_X);
	static JScrollPane sp;
	static int flag = 0;
	// ①：创建窗口对象
	
	// ************************************************************
	public static void main(String args[]) {
		TestJFrameExtends frm = new TestJFrameExtends("记事本");
		// ④：显示窗口
		frm.setVisible(true);
	}

	TestJFrameExtends(String sTitle) {
		
		super(sTitle);
		// ②：添加组件。本例直接添加菜单与JTextArea
		addMenus();
		// 添加带滚动条(JScrollPane)的文本编辑框JTextArea
		String stuFile = "学生信息encoded.txt";
		readFile(stuFile);
		ta.setLineWrap(true);// 自动换行
		sp = new JScrollPane(ta);
		add(sp);
		// ③：设置窗口大小
		setSize(800, 600);
		// 设置close按钮的操作
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 使窗口在显示屏居中显示
		ta.addKeyListener(new KeyAdapter(){//匿名
			public void keyTyped(KeyEvent e){
				flag=1;
			}
			}); 
		centerWindow();
		addToolBar();
		// 改变窗口图标
		Toolkit tk = getToolkit(); // 得到一个Toolkit对象
		Image icon = tk.getImage("online.gif"); // 获取图标
		setIconImage(icon);
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
	// 窗口居中
	public void centerWindow() {
		// 获得显示屏桌面窗口的大小
		Toolkit tk = getToolkit();
		Dimension dm = tk.getScreenSize();
		// 让窗口居中显示
		setLocation((int) (dm.getWidth() - getWidth()) / 2, (int) (dm.getHeight() - getHeight()) / 2);
	}

	private void addToolBar() {
		// 工具条
		Container c = getContentPane();
		c.add(BorderLayout.NORTH, mtb);
		mtb.setLayout(new FlowLayout(FlowLayout.LEFT));
		btn[0].addActionListener(this);
		btn[1].addActionListener(this);
		btn[2].addActionListener(this);
		for (int i = 0; i < btn.length; i++) {
			btn[i].setBorder(BorderFactory.createEmptyBorder());
			mtb.add(btn[i]);
		}
		// 设置不可浮动
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
		miNew.addActionListener(this);
		miOpen.addActionListener(this);
		miSave.addActionListener(this);
		miFont.addActionListener(this);
		miQuit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {// 第④步，监听者如何监听
		// e.getActionCommand()方法返回事件源的名称
		if (e.getSource() == miQuit) {
			if(flag==1)JOptionPane.showConfirmDialog(null, "修改内容尚未保存，确认退出？", "提示" , JOptionPane.WARNING_MESSAGE,JOptionPane.OK_CANCEL_OPTION);
			System.exit(1);
		}
		if (e.getSource() == btn[0] || e.getSource() == miNew) {// 你点击了按钮new
			ta.setText("");
		} else if (e.getSource() == btn[1] || e.getSource() == miOpen) {// 你点击了按钮open
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
		} else if (e.getSource() == btn[2] || e.getSource() == miSave) {// 你点击了按钮save
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
		}
		else if(e.getSource()==miFont) {
			new TestJComboBox("字体选择");
		}
	}

	public static JTextArea getTa() {
		return ta;
	}

	public static void setTa(JTextArea ta) {
		TestJFrameExtends.ta = ta;
	}
}

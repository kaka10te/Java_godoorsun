package zjut.java.ch9;

import java.awt.*;

import javax.swing.*;

public class TestComplexLayout{

	public static void main(String args[]) {
		JFrame f = new JFrame("JFrame with CardLayout");
		//创建panel1
		JPanel panel1=new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel1.add(new JLabel("当前打印机: Canon LBP3410/3460"));

		//创建panel2
		JPanel panel2=new JPanel();
		panel2.setLayout(new GridLayout(4,1,15,15));
		JButton[] btn={new JButton("确定"), 
		                         new JButton("取消"),
		                         new JButton("设置..."),
		                         new JButton("帮助")};
		int maxWidth=0;
		int i;
		for(i=0;i<btn.length;i++)
		panel2.add(btn[i]);

		//创建panel3
		JPanel panel3=new JPanel();
		panel3.add(new JLabel("打印质量："));
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		JComboBox<String> jcb=new JComboBox<String>();
		jcb.addItem("高");
		jcb.addItem("中");
		jcb.addItem("低");
		jcb.setSelectedIndex(0);
		panel3.add(jcb);
		panel3.add(new JCheckBox("打印到文件"));
		
		//创建panel4
		JPanel panel4=new JPanel();
		panel4.setLayout(new GridLayout(3,1,15,15));
		panel4.add(new JCheckBox("图像"));
		panel4.add(new JCheckBox("文本",true));
		panel4.add(new JCheckBox("编码"));

		//创建panel5
		JPanel panel5=new JPanel();
		panel5.setLayout(new GridLayout(3,1,15,15));
		ButtonGroup bg=new ButtonGroup();
		JRadioButton[] rb={new JRadioButton("所选区域"),
		                                 new JRadioButton("全部",true),
		                                 new JRadioButton("Applet")};
		for(i=0;i<rb.length;i++){
		bg.add(rb[i]);
		panel5.add(rb[i]);
		}

		//创建panel6,
		//并将panel4、panel5添加到panel6上面
		JPanel panel6=new JPanel();
		panel6.setBackground(Color.WHITE);
		panel6.setLayout(new FlowLayout(FlowLayout.LEFT,30,5));
		panel6.add(panel4);
		panel6.add(panel5);

		//创建panel7,
		//并将panel1、panel3、panel6添加到 panel7中
		JPanel panel7=new JPanel();
		panel7.setLayout(new BorderLayout());
		panel7.add(panel1, "North");
		panel7.add(panel6, "Center");
		panel7.add(panel3, "South");
		panel7.setBorder(BorderFactory.createLineBorder(Color.RED, 2));//红色边框
		
		//创建panel8,
		//并将panel7、panel2添加到panel8中
		JPanel panel8=new JPanel();
		panel8.setLayout(new BorderLayout());
		panel8.add(panel7, "West");
		panel8.add(panel2, "Center");
		panel8.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));//蓝色边框

		//将默认的内容面板替换成panel8
		f.setContentPane(panel8);

		UIManager.LookAndFeelInfo[] ui=UIManager.getInstalledLookAndFeels();
		for(i=0;i<ui.length;i++)
		System.out.println((i+1)+" - "+ui[i].getName()+": "+ui[i].getClassName());

	}
	
}

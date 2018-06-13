package zjut.java.ch9;

import java.awt.*;

import javax.swing.*;

public class TestComplexLayout{

	public static void main(String args[]) {
		JFrame f = new JFrame("JFrame with CardLayout");
		//����panel1
		JPanel panel1=new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel1.add(new JLabel("��ǰ��ӡ��: Canon LBP3410/3460"));

		//����panel2
		JPanel panel2=new JPanel();
		panel2.setLayout(new GridLayout(4,1,15,15));
		JButton[] btn={new JButton("ȷ��"), 
		                         new JButton("ȡ��"),
		                         new JButton("����..."),
		                         new JButton("����")};
		int maxWidth=0;
		int i;
		for(i=0;i<btn.length;i++)
		panel2.add(btn[i]);

		//����panel3
		JPanel panel3=new JPanel();
		panel3.add(new JLabel("��ӡ������"));
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		JComboBox<String> jcb=new JComboBox<String>();
		jcb.addItem("��");
		jcb.addItem("��");
		jcb.addItem("��");
		jcb.setSelectedIndex(0);
		panel3.add(jcb);
		panel3.add(new JCheckBox("��ӡ���ļ�"));
		
		//����panel4
		JPanel panel4=new JPanel();
		panel4.setLayout(new GridLayout(3,1,15,15));
		panel4.add(new JCheckBox("ͼ��"));
		panel4.add(new JCheckBox("�ı�",true));
		panel4.add(new JCheckBox("����"));

		//����panel5
		JPanel panel5=new JPanel();
		panel5.setLayout(new GridLayout(3,1,15,15));
		ButtonGroup bg=new ButtonGroup();
		JRadioButton[] rb={new JRadioButton("��ѡ����"),
		                                 new JRadioButton("ȫ��",true),
		                                 new JRadioButton("Applet")};
		for(i=0;i<rb.length;i++){
		bg.add(rb[i]);
		panel5.add(rb[i]);
		}

		//����panel6,
		//����panel4��panel5��ӵ�panel6����
		JPanel panel6=new JPanel();
		panel6.setBackground(Color.WHITE);
		panel6.setLayout(new FlowLayout(FlowLayout.LEFT,30,5));
		panel6.add(panel4);
		panel6.add(panel5);

		//����panel7,
		//����panel1��panel3��panel6��ӵ� panel7��
		JPanel panel7=new JPanel();
		panel7.setLayout(new BorderLayout());
		panel7.add(panel1, "North");
		panel7.add(panel6, "Center");
		panel7.add(panel3, "South");
		panel7.setBorder(BorderFactory.createLineBorder(Color.RED, 2));//��ɫ�߿�
		
		//����panel8,
		//����panel7��panel2��ӵ�panel8��
		JPanel panel8=new JPanel();
		panel8.setLayout(new BorderLayout());
		panel8.add(panel7, "West");
		panel8.add(panel2, "Center");
		panel8.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));//��ɫ�߿�

		//��Ĭ�ϵ���������滻��panel8
		f.setContentPane(panel8);

		UIManager.LookAndFeelInfo[] ui=UIManager.getInstalledLookAndFeels();
		for(i=0;i<ui.length;i++)
		System.out.println((i+1)+" - "+ui[i].getName()+": "+ui[i].getClassName());

	}
	
}

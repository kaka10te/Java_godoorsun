
import java.awt.Container; 
import java.awt.Cursor;

import java.awt.Frame;

import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class about extends JDialog{
	
	
	 
	
	JButton bu;
	String zhuji;
	private Point fp; // ��ҷ����֮ǰ�����λ��
	 
	  
	 
	

	public about(Frame framee,String title, boolean b)
    {
			super(framee,title,b);
			
			int windowsWedth = 340;
			  int windowsHeight = 500;
			// �õ���ʾ����Ļ�Ŀ��
			  int width = Toolkit.getDefaultToolkit().getScreenSize().width;
			  int height = Toolkit.getDefaultToolkit().getScreenSize().height;
			//���ô�������ʾ��������ʾ
			  this.setBounds((width - windowsWedth) / 2,
			    (height - windowsHeight) / 2, windowsWedth, windowsHeight);
		
			 
	
		this.setTitle("��������");
		Container con=this.getContentPane();
		con.setLayout(null);
		
		
		this.setLocationRelativeTo(null);
		
		BackgroundPanel labe = new BackgroundPanel();// �����������
        labe.setImage(getToolkit().getImage(
                getClass().getResource("bg2.jpg")));// ������屳��ͼƬ
		
	    
		
		labe.setBounds(5, 5, 350,200);
		
		BackgroundPanel xiantiao = new BackgroundPanel();// �����������
        xiantiao.setImage(getToolkit().getImage(
                getClass().getResource("xiantiao.jpg")));// ������屳��ͼƬ
		xiantiao.setBounds(-5,210, 350,10);
		
		JPanel pane=new JPanel();
        pane.setOpaque(false);
        BackgroundPanel tubiao = new BackgroundPanel();// �����������
        tubiao.setImage(getToolkit().getImage(
                getClass().getResource("tubiao.jpg")));// ������屳��ͼƬ
		tubiao.setBounds(5,240,47,51);
		JLabel info=new JLabel("�㶫��óְҵ����ѧԺ ����� ���2�� ");
		JLabel info2=new JLabel("��Ȩ���� @ 2014 ������  ѧ��1313213");
		JLabel info3=new JLabel("                         �汾 2014.1  ");
		
		
		
		InetAddress a;
		try {
			a = InetAddress.getLocalHost();
			zhuji=("  ����Ʒʹ��Ȩ����:        " + a.getHostName());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		JLabel info4=new JLabel("                         "+zhuji);
	    LinkLabel l=new LinkLabel("�����ҵĿռ�","http://user.qzone.qq.com/1042492275");
		 bu=new JButton("ȷ��");
		
	    info.setBounds(65,240,280,50);
	    info2.setBounds(65,270,280,50);
	    info3.setBounds(65,288,280,50);
	    info4.setBounds(2,400,280,50);
	    bu.setBounds(230,470,100,20);
	    l.setBounds(130,350,280,30);
	    con.add(labe);
	    con.add(xiantiao);
	    con.add(tubiao);
	   con.add(info);
	    con.add(info2);
	    con.add(info3);
	    con.add(l);
	    con.add(info4);
	    con.add(bu);
	    this.setSize(340,500);
	    this.setAlwaysOnTop(true);
	     this.setUndecorated(true);
	     this.addMouseListener(new MouseAdapter() {
	            public void mousePressed(final MouseEvent e) {
	                fp = e.getPoint();
	                
	            }
	        });
	     
	        // ���������ҷ�¼����ƶ�����
	        this.addMouseMotionListener(new MouseMotionAdapter() {
	            public void mouseDragged(final MouseEvent e) {
	                JDialog frame = (JDialog) getRootPane().getParent();
	                Point point = e.getLocationOnScreen();
	                frame.setLocation(point.x - fp.x, point.y - fp.y);
	            }
	        });
	        
	        
	       bu.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e)
			 {     
				 dispose();
			 }
			 });
	    
	    
	    
	   
	}
	
	
	
}

package zjut.java.ch9;

import java.awt.Container;

import javax.swing.*;

public class TestJSplitPane {
	public static void main(String args[]){
		JFrame fr = new JFrame("JFrame with JSplitPane");
		Container c = fr.getContentPane();		
		JPanel leftPane = new JPanel();//左面板
		JPanel rightPane = new JPanel();//右面板
		//创建水平分割条，即分为左右两部分
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,	leftPane,rightPane); 
		sp.setDividerSize(5);  //设置分割条本身的宽度为5个像素	
		leftPane.add(new JButton("left button"));       //将按钮添加到左边的面板
		rightPane.add(new JButton("right button"));   //将按钮添加到右边的面板
		c.add(sp);//将分割条(含左右两个带按钮的面板)添加到窗口上		
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setSize(400,300);	
		fr.setVisible(true);
		//以下语句须放在setVisible之后，否则不会起到效果
		sp.setDividerLocation(0.3);  //左边占0.3(30%)，右边占0.7(70%)
		}
}

package richanglianxi;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class gui  extends WindowAdapter{
//	public void windowClosing(WindowEvent arg0) {
//		System.exit(0);
//	}
	public static void main(String... args) {
		JFrame fr1=new JFrame("���׻�ͼ����");
		JMenuBar br=new JMenuBar();
		JMenu j1=new JMenu("�ļ�");
		JMenu j2= new JMenu("�༭");
		JMenu j3 = new JMenu("����");
//		fr1.setLayout(new FlowLayout());
		fr1.setLayout(new BorderLayout());
//		fr1.setLayout(new GridLayout(0,2));
//		fr1.setLayout( new CardLayout());
//		fr1.setLayout(new GridBagLayout());
		fr1.add(BorderLayout.SOUTH,br);
		fr1.add(BorderLayout.CENTER,br);
		fr1.add("NORTH",br);
		
		fr1.add("NORTH",br);
		fr1.setSize(400,300);
		fr1.setVisible(true);
		JMenuItem t1=new JMenuItem("��");
		JMenuItem t2=new JMenuItem("�༭");
		JMenuItem t3=new JMenuItem("����");
		fr1.add(br);
		br.add(j1);
		br.add(j2);
		br.add(j3);
		j1.add(t1);
		j1.add(t2);
		j1.add(t3);
//		fr1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
				
	}
}

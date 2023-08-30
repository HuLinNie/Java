package wwxxhh;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.*;
import javax.swing.JFileChooser;
import javax.swing.JFileChooser.*;
import java.io.FileFilter;
import java.util.*;
public class menufrm {
	public static void main(String[] args) {
		JFrame frm= new JFrame("菜单测试程序");
		JMenuBar jmb = new JMenuBar();
		JMenu sys = new JMenu("系统");
		JMenuItem openitem = new JMenuItem("打开");
		openitem.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JFileChooser fdlg = new JFileChooser();
						fdlg.setDialogTitle("打开");
						FileNameExtensionFilter filter = new FileNameExtensionFilter("Txt Files","txt");
						int rval = fdlg.showOpenDialog(frm);
						if (rval == JFileChooser.APPROVE_OPTION) {
							try {
								int file = fdlg.getSelectedFiles().length;
								JOptionPane.showMessageDialog(null, "打开文件"+file);
							}catch (Exception ex) {
								
							}
						}	
					}
				});
		JMenuItem saveitem = new JMenuItem("保存");
		JMenuItem quititem = new JMenuItem("退出");
		sys.add(openitem);
		sys.add(saveitem);
		sys.addSeparator();
		sys.add(quititem);
		jmb.add(sys);
		frm.setJMenuBar(jmb);
		frm.setSize(400, 300);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLocationRelativeTo(frm.getOwner());
		frm.setVisible(true);
	};
}
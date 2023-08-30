package frame1;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.Frame;
import java.awt.Button;
//import java.awt.GridLayout;
//import java.awt.TextField;
public class FirstFrm {

	public static void main(String[] args) {
//		Frame frm = new Frame();
//		frm.setSize(800,600);
//		frm.setVisible(true);
		
		Frame frm = new Frame();
		frm.setSize(400,300);
		//frm.setLayout(null);
		//TextField tf = new TextField();
		//frm.add(tf);
		//tf.setBounds(50,50,120,50);
		
		//*Button bt1 =new Button("BT1");
		Button bt2 =new Button("Click me");
		bt2.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "Button Clicked!");
					}
				});
		//Button bt3 =new Button("BT3");
		//Button bt4 =new Button("BT4");
		//Button bt5 =new Button("BT5");
		
		///frm.add(bt1);
		frm.add(bt2);
		frm.add(BorderLayout.CENTER,bt2);
		//bt2.setBounds(150,130,120,25);
		//frm.add(bt3);
		//frm.add(bt4);
		//frm.add(bt5);
		frm.addWindowListener(new CloseFrameListener());
		frm.setVisible(true);
	}
}

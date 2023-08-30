package jisuanqi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dot1 implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		isResult=false;
		if(tf.getText().trim().indexOf(".")==-1) {
			tf.setText(tf.getText()+".");
		}
	}
}

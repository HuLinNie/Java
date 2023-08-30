package jisuanqi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpecialNum1 implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if(isResult) {
			tf.setText("");
			isResult = false;
		}
		if(str=="PI")
		{
			tf.setText(String.valueOf(Math.PI));
		}
		else if(str=="e") {
			tf.setText(String.valueOf(Math.E));
		}
		else {
			tf.setText(tf.getText().trim()+str);
			if(tf.getText().equals("0")) {
				tf.setText("0");
				isResult=true;
				flag=true;
			}
		}
	}
}

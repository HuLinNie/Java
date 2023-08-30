package jisuanqi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearArea1 implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String str=e.getActionCommand();
		if(str=="C") {
			tf.setText("0");
			isResult=true;
			result = 0;
		}else if(str =="-/+") {
			double i = (-1)*Double.parseDouble(tf.getText().trim());
			tf.setText(df.format(i));
		}
		else if(str == "Backspace") {
			if(Double.parseDouble(tf.getText())>0) {
				if(tf.getText().length()>1) {
					tf.setText(tf.getText().substring(0,tf.getText()-1));
				}else {
					tf.setText("0");
					isResult=true;
				}
			}else {
				if(tf.getText().length()>2) {
					tf.setText(tf.getText().substring(0,tf.getText().length()-1));
				}else {
					tf.setText("0");
					isResult = true;
				}
			}
		}else if (str =="CE") {
			tf.setText("0");
			isResult = true;
		}

	}

}

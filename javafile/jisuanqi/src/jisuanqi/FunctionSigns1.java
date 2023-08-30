package jisuanqi;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import jisuanqi.SmartCalculator;
public class FunctionSigns1 implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if(str.equals("sqrt")) {
			double i = Double.parseDouble(tf.getText());
			if(i>=0) {
				tf.setText(String.copyValueOf(df.format(Math.sqrt(i))));
			}
			else {
				tf.setText("负数不能开平方根");
			}
		}
		else if(str.equals("log")) {
			double i = Double.parseDouble(tf.getText());
			if(i>0) {
				tf.setText(String.valueOf(df.format(Math.log(i))));
			}
			else {
				tf.setText("负数不能求对数");
			}
		}
		else if(str.equal("%")) {
			tf.setText(df.format(Double.parseDouble(tf.getText())/100));
		}
		else if(str.equals("1/x")) {
			if(Double.parseDouble(tf.getText())==0) {
				tf.setText("除数不能为零");
			}
			else {
				tf.setText(df.format(1/Double.parseDouble(tf.getText())));
			}
		}
		else if(str.equals("sin")) {
			double i = Double.parseDouble(tf.getText());
			tf.setText(String.valueOf(df.format(Math.sin(i))));
		}
		else if(str.equals("cos")) {
			double i = Double.parseDouble(tf.getText());
			tf.setText(String.valueOf(df.format(Math.cos(i))));
			}
		else if(str.equals("tan")) {
			double i = Double.parseDouble(tf.getText());
			tf.setText(String.valueOf(df.format(Math.tan(i))));
			}
		else if(str.equals("n!")) {
			double i = Double.parseDouble(tf.getText());
			if((i%2==0)||(i%2==1)) 
			{
				int j=(int)i;
				int result=1;
				for (int k=1;k<=j;k++)
					result *=k;
				tf.setText(String.valueOf(result));
			}
			else 
			{
				tf.setText("无法进行阶乘");
			}
		}
		else if(str.equals("x^2")) {
			double i = Double.parseDouble(tf.getText());
			tf.setText(String.valueOf(df.format(i*i)));
		}
		else if(str.equals("x^2=3")) {
			double i = Double.parseDouble(tf.getText());
			tf.setText(String.valueOf(df.format(i*i*i)));
		}
		else if (str.equals("度边弧度")) {
			double i = Double.parseDouble(tf.getText());
			tf.setText(String.valueOf(i/180*Math.PI));
		}
		else {
			if(flag) {
				isResult = false;
			}
			if(isResult) {
				operator = str;
			}else {
				getResult(Double.parseDouble(tf.getText()));
				operator=str;
				isResult = true;
			}
		}
	}

}

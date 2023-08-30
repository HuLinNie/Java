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
				tf.setText("�������ܿ�ƽ����");
			}
		}
		else if(str.equals("log")) {
			double i = Double.parseDouble(tf.getText());
			if(i>0) {
				tf.setText(String.valueOf(df.format(Math.log(i))));
			}
			else {
				tf.setText("�������������");
			}
		}
		else if(str.equal("%")) {
			tf.setText(df.format(Double.parseDouble(tf.getText())/100));
		}
		else if(str.equals("1/x")) {
			if(Double.parseDouble(tf.getText())==0) {
				tf.setText("��������Ϊ��");
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
				tf.setText("�޷����н׳�");
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
		else if (str.equals("�ȱ߻���")) {
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

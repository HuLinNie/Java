package jisuanqi;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

@SuppressWarnings("serial")
public class SmartCalculator  extends JFrame {
	private JTextField tf;
	private JPanel panel1,panel2,panel3,panel4;
	private String back;
	private boolean isResult = true,flag=false;
	public String operator = "=";
	private  double result=0;
	private SpecialNum SpecialNumActionListener;
	private DecimalFormat df;
	public SmartCalculator() {
		super("简易计算器");
		df= new DecimalFormat("# . # # # #");
		this.setLayout(new BorderLayout(10,5));
		panel1 = new JPanel(new GridLayout(1,3,10,10));
		panel2 = new JPanel(new GridLayout(5,6,5,5));
		panel3 = new JPanel(new GridLayout(5,1,5,5));
		panel4 = new JPanel(new BorderLayout(5,5));
		SpecialNumActionListener=new SpecialNum();
		tf=new JTextField();
		tf.setEditable(true);
		tf.setBackground(Color.white);
		tf.setHorizontalAlignment(JTextField.RIGHT);
		tf.setText("0");
		tf.setBorder(BorderFactory.createLoweredBevelBorder());
		init();				
	}
	public void init() {
		addButton(panel1,"Backspace",new ClearArea(),Color.red);
		addButton(panel1,"CE",new ClearArea(),Color.red);
		addButton(panel1,"C",new ClearArea(),Color.red);
		
		addButton(panel2,"1/x",new FunctionSigns(),Color.magenta);
		addButton(panel2,"log",new FunctionSigns(),Color.magenta);
		addButton(panel2,"7",SpecialNumActionListener,Color.blue);
		addButton(panel2,"8",SpecialNumActionListener,Color.blue);
		addButton(panel2,"9",SpecialNumActionListener,Color.blue);
		addButton(panel2,"/",new FunctionSigns(),Color.red);
		
		addButton(panel2,"n!",new FunctionSigns(),Color.red);
		addButton(panel2,"sqrt",new FunctionSigns(),Color.red);
		addButton(panel2,"4",SpecialNumActionListener,Color.red);
		addButton(panel2,"5",SpecialNumActionListener,Color.red);
		addButton(panel2,"6",SpecialNumActionListener,Color.red);
		addButton(panel2,"*",new FunctionSigns(),Color.red);
		
		addButton(panel2,"sin",new FunctionSigns(),Color.magenta);
		addButton(panel2,"x^2",new FunctionSigns(),Color.magenta);
		addButton(panel2,"1",SpecialNumActionListener,Color.blue);
		addButton(panel2,"2",SpecialNumActionListener,Color.blue);
		addButton(panel2,"3",SpecialNumActionListener,Color.blue);
		addButton(panel2,"-",new FunctionSigns(),Color.red);
		
		addButton(panel2,"cos",new FunctionSigns(),Color.magenta);
		addButton(panel2,"x^3",new FunctionSigns(),Color.magenta);
		addButton(panel2,"0",SpecialNumActionListener,Color.blue);
		addButton(panel2,"-/+",new ClearArea(),Color.blue);
		addButton(panel2,".",new Dot(),Color.blue);
		addButton(panel2,"+",new FunctionSigns(),Color.red);
		
		addButton(panel2,"tan",new FunctionSigns(),Color.magenta);
		addButton(panel2,"%",new FunctionSigns(),Color.magenta);
		addButton(panel2,"PI",SpecialNumActionListener,Color.gray);
		addButton(panel2,"e",SpecialNumActionListener,Color.gray);
		addButton(panel2,"度变弧度",new FunctionSigns(),Color.gray);
		addButton(panel2,"=",new FunctionSigns(),Color.red);
		
		JButton btns = new JButton("记忆区");
		btns.setBorder(BorderFactory.createLoweredBevelBorder());
		btns.setEnabled(false);
		btns.setPreferredSize(new Dimension(20,20));
		
		panel3.add(btns);
		addButton(panel3,"MC",null,Color.red);
		addButton(panel3,"MR",null,Color.red);
		addButton(panel3,"MS",null,Color.red);
		addButton(panel3,"M+",null,Color.red);
		
		panel4.add(panel1,BorderLayout.NORTH);
		panel4.add(panel2,BorderLayout.CENTER);
		this.add(tf,BorderLayout.NORTH);
		this.add(panel3,BorderLayout.WEST);
		this.add(panel4);
		
		pack();
		this.setResizable(false);
		this.setLocation(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
	}
	private void addButton(JPanel panel,String name,ActionListener action,Color color) {
		JButton bt=new JButton(name);
		panel.add(bt);
		bt.setForeground(color);
		bt.addActionListener(action);
	}
	private void getResult(double x) {
		if(operator =="+") {result += x;}
		else if(operator =="-") {result -= x;}
		else if(operator =="*") {result *= x;}
		else if(operator =="/") {result /= x;}
		else if(operator =="=") {result = x;}
		tf.setText(df.format(result));	
	}



class FunctionSigns implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if(str.equals("sqrt")) {
			double i = Double.parseDouble(tf.getText());
			if(i>=0) {
				tf.setText(String.valueOf(df.format(Math.sqrt(i))));
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
		else if(str.equals("%")) {
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
		else if(str.equals("x^3")) {
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




class ClearArea implements ActionListener {


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
					tf.setText(tf.getText().substring(0,tf.getText().length()-1));
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




class SpecialNum implements ActionListener {

	
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



class Dot implements ActionListener {

	
	public void actionPerformed(ActionEvent e) {
		isResult=false;
		if(tf.getText().trim().indexOf(".")==-1) {
			tf.setText(tf.getText()+".");
		}
	}
}

public static void main(String[] args) {
	new SmartCalculator().setVisible(true);
//	System.out.println("result:");

}
}


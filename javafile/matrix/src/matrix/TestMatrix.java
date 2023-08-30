package matrix;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import tools.Helper;

public class TestMatrix {
	public static void main(String[] args) throws Exception {
		if (args.length < 2) {
			System.out.println("请重新运行程序，并输入【 输入文件与输出文件】 的文件名");
			return;
		}
		//打开文件args[0]， 准备输入，默认输入文件中存在两行数据，分别为两个计算用矩阵
		InputStream is = new FileInputStream(args[0]);
		Scanner scr = new Scanner(is);//创建Scanner类对象，用于整行读取数据
		
		String mStr1 = scr.nextLine();//读取数据存入mStr1，自行实现并处理异常
		String mStr2 = scr.nextLine();//读取数据存入mStr2，自行实现并处理异常
		scr.close();	//读取结束后关闭流
		
		int[][] mArray1 = Helper.toIntArray(mStr1); //将串解析为数组
		int[][] mArray2 = Helper.toIntArray(mStr2); //将串解析为数组
		
		Matrix m1 = new Matrix(mArray1);//创建矩阵对象
		Matrix m2 = new Matrix(mArray2);
		Matrix m3 = m1.multi(m2); 	//进行矩阵运算，Matrix m4 = m1.add(m2);
		
		//输出运算数及结果
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(m3.toString());
		
		OutputStream os = new FileOutputStream(args[1]);//打开文件args[1]，准备输出
		PrintWriter ps = new PrintWriter(os);//创建一个字符处理流，方便将字符串整体输出
		ps.println(m3.toString());//将 m3.toString() 写入文件args[1]
		ps.close();//输出结束后，关闭流
	}
}

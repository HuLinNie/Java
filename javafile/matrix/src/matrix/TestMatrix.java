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
			System.out.println("���������г��򣬲����롾 �����ļ�������ļ��� ���ļ���");
			return;
		}
		//���ļ�args[0]�� ׼�����룬Ĭ�������ļ��д����������ݣ��ֱ�Ϊ���������þ���
		InputStream is = new FileInputStream(args[0]);
		Scanner scr = new Scanner(is);//����Scanner������������ж�ȡ����
		
		String mStr1 = scr.nextLine();//��ȡ���ݴ���mStr1������ʵ�ֲ������쳣
		String mStr2 = scr.nextLine();//��ȡ���ݴ���mStr2������ʵ�ֲ������쳣
		scr.close();	//��ȡ������ر���
		
		int[][] mArray1 = Helper.toIntArray(mStr1); //��������Ϊ����
		int[][] mArray2 = Helper.toIntArray(mStr2); //��������Ϊ����
		
		Matrix m1 = new Matrix(mArray1);//�����������
		Matrix m2 = new Matrix(mArray2);
		Matrix m3 = m1.multi(m2); 	//���о������㣬Matrix m4 = m1.add(m2);
		
		//��������������
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(m3.toString());
		
		OutputStream os = new FileOutputStream(args[1]);//���ļ�args[1]��׼�����
		PrintWriter ps = new PrintWriter(os);//����һ���ַ������������㽫�ַ����������
		ps.println(m3.toString());//�� m3.toString() д���ļ�args[1]
		ps.close();//��������󣬹ر���
	}
}

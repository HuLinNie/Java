package richanglianxi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class idfolw {
	public  static void main(String[]args) throws IOException  {
//		File file = new File("C:\\Users\\harry\\Desktop\\java实验参考代码\\Matrix.java");
//		File file2 = new File("C:\\Users\\harry\\Desktop\\java实验参考代码","123.java");
//		boolean c= file.canRead();
//		boolean b= file2.canWrite();
//		boolean e= file.exists();
//		String d = file.getPath();
//		String s= file.getName();
//		String s1 = file2.getParent();
//		
//		System.out.println(c);
//		System.out.println(b);
//		System.out.println(e);
//		System.out.println(d);
//		System.out.println(c);
//		System.out.println(s1);
//		long i = file.length();
//		System.out.println(i);
		
//		RandomAccessFile fil= new RandomAccessFile("C:\\Users\\harry\\Desktop\\java实验参考代码\\Matrix.java","rw");
//		fil.setLength(45);
//		long c=fil.length();
//		fil.seek(5);
//		long b =fil.getFilePointer();
//		
//		
//		System.out.println(c);
//		System.out.println(b);

//		try{FileReader file = new FileReader("C:\\Users\\harry\\Desktop\\java实验参考代码\\Matrix.java");
//		BufferedReader br = new BufferedReader(file);
//		
//		FileWriter fos =new FileWriter("C:\\Users\\harry\\Desktop\\java实验参考代码\\123.java");
//		BufferedWriter bw = new BufferedWriter(fos);
//		String c;
//		while((c=br.readLine())!=null) {
//			bw.write(c);
//		}
//		file.close();
//		bw.close();}
//	catch (FileNotFoundException e) {
//		// TODO Auto-generated catch block
//		System.out.println("sdf");
//	}
		try{FileInputStream file = new FileInputStream("C:\\Users\\harry\\Desktop\\java实验参考代码\\Matrix.java");
		InputStreamReader fr = new InputStreamReader(file);
		
//		BufferedReader br = new BufferedReader(fr);
//		DataInputStream di = new DataInputStream(file);
//		
//		int i=di.readByte();
//		System.out.println(i);
//		long hu=System.in.skip(2);
//		System.out.println(hu);
		FileOutputStream fos =new  FileOutputStream("C:\\Users\\harry\\Desktop\\java实验参考代码\\345.java");
		ObjectOutputStream fis = new ObjectOutputStream(fos);
		int c;
		while((c=fr.read())!=-1) {
			fis.write(c);
			
			
		}
		fis.close();
		fos.close();
		fr.close();
		file.close();
//		DataOutputStream ti = new DataOutputStream(fos);
		}
////		BufferedWriter bw = new BufferedWriter(fos);
//		
//		while((i=di.read())!=-1) {
//			ti.write(i);
//		}
//		ti.flush();
//		file.close();
//		ti.close();}
	catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("sdf");
	}

	}	
}

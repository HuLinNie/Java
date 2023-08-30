package ioflow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestIO {
	public static void main(String []args) {
		try {
			FileReader reader = new FileReader(args[0]);
			BufferedReader br = new BufferedReader(reader);
			String strArray1 = br.readLine();
			String strArray2 = br.readLine();
			br.close();
			int [][]iArray1 =Helper.toIntArray(strArray1);
			int [][]iArray2 = Helper.toIntArray(strArray2);
			Matrix m1 = new Matrix(iArray1);
			Matrix m2 = new Matrix(iArray2);
			Matrix m3 = m1.multi(m2);
			Matrix m4 = m1.add(m2);
			FileWriter writer = new FileWriter(args[1]);
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write(m1.toString());
			bw.write("*");
			bw.write(m2.toString());
			bw.write("=");
			bw.write(m3.toString());
			bw.newLine();
	
			bw.write(m1.toString());
			bw.write("+");
			bw.write(m2.toString());
			bw.write("=");
			bw.write(m4.toString());
			bw.close();			
		}catch (IOException e) {
			e.printStackTrace();
			}		
	}

}
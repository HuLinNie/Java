package matrixexception;

import java.io.IOException;

public class TestMatrixException {
	public static void main(String[] args)  throws IOException{
		try {
			int[][] mArray1 = { { 1, 2, 3 }, { 4, 3 }, { 5, 3, 1 } };
			//int[][] mArray2 = { { 1,  1 }, { 1, 1 }, { 1, 1 } };

			//int[][] mArray2 = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 3 ,1} };
			int[][] mArray2 = {{ 1, 1, 1 }, { 1, 1, 1 },{5,5,5}};
			
			Matrix m1 = new Matrix(mArray1);// �����������
			Matrix m2 = new Matrix(mArray2);
			Matrix m3 = m1.multi(m2); // ���о������㣬Matrix m4 = m1.add(m2);

			// ��������������
			System.out.println(m1.toString());
			System.out.println(m2.toString());
			System.out.println(m3.toString());
		} catch (MatrixException ex ) {
			System.out.print("abc");
		}catch(Exception e) {
			System.out.print("dsf");
		}
		
			
		
	
	}
}

package matrix;

public class TestMatrix1 {
	public static void main(String[] args) {

		int[][] mArray1 = { { 1, 2, 3 }, { 4, 3, 2 }, { 5, 3, 1 } };
		int[][] mArray2 = { { 1, 2, 3 }, { 4, 3, 2 }, { 5, 3, 1 } };

		Matrix m1 = new Matrix(mArray1);// �����������
		Matrix m2 = new Matrix(mArray2);
		Matrix m3 = m1.multi(m2); // ���о������㣬Matrix m4 = m1.add(m2);

		// ��������������
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(m3.toString());
	}
}

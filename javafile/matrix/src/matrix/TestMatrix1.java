package matrix;

public class TestMatrix1 {
	public static void main(String[] args) {

		int[][] mArray1 = { { 1, 2, 3 }, { 4, 3, 2 }, { 5, 3, 1 } };
		int[][] mArray2 = { { 1, 2, 3 }, { 4, 3, 2 }, { 5, 3, 1 } };

		Matrix m1 = new Matrix(mArray1);// 创建矩阵对象
		Matrix m2 = new Matrix(mArray2);
		Matrix m3 = m1.multi(m2); // 进行矩阵运算，Matrix m4 = m1.add(m2);

		// 输出运算数及结果
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(m3.toString());
	}
}

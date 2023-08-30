package ioflow;
public class Matrix {
	private int[][] matArray;

	public Matrix(int[][] mArray) {
		if (mArray != null)
			matArray = mArray.clone();
		else
			matArray = new int[0][0];
	}
	
	public String toString() {
		return Helper.toIntArrayString(this.matArray);
	}
	
	public int count_row() { // 返回矩阵行数
		return matArray.length;
	}

	public int count_column() { // 返回矩阵列数，默认每行元素相同
		return matArray[0].length;
	}

	public Matrix add(Matrix m) {
		if (isNull() || m.isNull())
			return null;
		
		if (!isRegular() || !m.isRegular()) //两个矩阵是否都是规则的
			return null;

		if (count_row() != m.count_row()) // 检测 两个矩阵行数是否一致
			return null;

		if (count_column() != m.count_column()) // 检测 两个矩阵列数是否一致
			return null;

		final int row_count = count_row(); // 新矩阵的行数
		final int col_count = count_column(); // 新矩阵的列数

		int[][] c = new int[row_count][col_count];
		for (int i = 0; i < row_count; i++) {
			for (int j = 0; j < col_count; j++) {
				c[i][j] = matArray[i][j] + m.matArray[i][j];
			}
		}
		return new Matrix(c);
	}

	public Matrix multi(Matrix m) {
		if (isNull() || m.isNull())
			return null;

		if (!isRegular() || !m.isRegular())
			return null;

		if (count_column() != m.count_row()) // 检测此矩阵列数是否与另一个矩阵的行数一致
			return null;
		
		final int row_count = this.count_row(); // 新矩阵的行数
		final int col_count = m.count_column(); // 新矩阵的列数
		final int countK = m.count_row(); // 行与列元素相乘 累加 时的计数值

		int[][] c = new int[row_count][col_count];
		for (int i = 0; i < row_count; i++) {
			for (int j = 0; j < col_count; j++) {
				c[i][j] = 0;
				for (int k = 0; k < countK; k++)
					c[i][j] += matArray[i][k] * m.matArray[k][j];
			}
		}
		return new Matrix(c);
	}

	/**************************************************************/
	private boolean isNull() {// 检测矩阵是否为空
		if (matArray == null)
			return true;

		if (matArray.length == 0)
			return true;

		if (matArray[0].length == 0)
			return true;

		return false;
	}

	/**************************************************************/
	private boolean isRegular() { // 检测是否每行元素数量一致，默认每行元素相同
		for (int i = 0; i < matArray.length - 1; i++)
			if (matArray[i].length != matArray[i + 1].length)
				return false;
		return true;
	}
}


package matrix;

public class Matrix2 {

	public int[][] add(int[][] a, int[][] b) {
		if (a == null || b == null)
			return null;

		if (a.length == 0 || b.length == 0)
			return null;

		if (a.length != b.length) // 检测 两个矩阵行数是否一致
			return null;

		for (int i = 0; i < a.length; i++) // 检测 两个矩阵列数是否一致
			if (a[i].length != b[i].length)
				return null;

		for (int i = 0; i < a.length - 1; i++) // 检测矩阵是否每行的列数一致
			if (a[i].length != a[i + 1].length)
				return null;
		/*****************************************************/
		final int row_count = a.length; // 新矩阵的行数
		final int col_count = a[0].length; // 新矩阵的列数

		int[][] c = new int[row_count][col_count];
		for (int i = 0; i < row_count; i++) {
			for (int j = 0; j < col_count; j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		/*****************************************************/
		return c;
	}

	public int[][] mul(int[][] a, int[][] b) {
		if (a == null || b == null)
			return null;

		if (a.length == 0 || b.length == 0)
			return null;

		for (int i = 0; i < a.length - 1; i++) // 检测矩阵是否每行的列数一致
			if (a[i].length != a[i + 1].length)
				return null;

		for (int i = 0; i < b.length - 1; i++) // 检测矩阵是否每行的列数一致
			if (b[i].length != b[i + 1].length)
				return null;

		if (a[0].length != b.length) // 检测a的列数 是否 与 b 的行数一致
			return null;
		/*****************************************************/
		final int row_count = a.length; // 新矩阵的行数
		final int col_count = b[0].length; // 新矩阵的列数
		final int countK = b.length; // 行与列元素相乘 累加 时的计数值

		int[][] c = new int[row_count][col_count];
		for (int i = 0; i < row_count; i++) {
			for (int j = 0; j < col_count; j++) {
				c[i][j] = 0;
				for (int k = 0; k < countK; k++)
					c[i][j] += a[i][k] * b[k][j];
			}
		}
		/*****************************************************/
		return c;
	}
}

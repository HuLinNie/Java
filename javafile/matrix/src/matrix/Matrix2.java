package matrix;

public class Matrix2 {

	public int[][] add(int[][] a, int[][] b) {
		if (a == null || b == null)
			return null;

		if (a.length == 0 || b.length == 0)
			return null;

		if (a.length != b.length) // ��� �������������Ƿ�һ��
			return null;

		for (int i = 0; i < a.length; i++) // ��� �������������Ƿ�һ��
			if (a[i].length != b[i].length)
				return null;

		for (int i = 0; i < a.length - 1; i++) // �������Ƿ�ÿ�е�����һ��
			if (a[i].length != a[i + 1].length)
				return null;
		/*****************************************************/
		final int row_count = a.length; // �¾��������
		final int col_count = a[0].length; // �¾��������

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

		for (int i = 0; i < a.length - 1; i++) // �������Ƿ�ÿ�е�����һ��
			if (a[i].length != a[i + 1].length)
				return null;

		for (int i = 0; i < b.length - 1; i++) // �������Ƿ�ÿ�е�����һ��
			if (b[i].length != b[i + 1].length)
				return null;

		if (a[0].length != b.length) // ���a������ �Ƿ� �� b ������һ��
			return null;
		/*****************************************************/
		final int row_count = a.length; // �¾��������
		final int col_count = b[0].length; // �¾��������
		final int countK = b.length; // ������Ԫ����� �ۼ� ʱ�ļ���ֵ

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

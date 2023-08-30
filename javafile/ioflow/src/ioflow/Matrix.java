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
	
	public int count_row() { // ���ؾ�������
		return matArray.length;
	}

	public int count_column() { // ���ؾ���������Ĭ��ÿ��Ԫ����ͬ
		return matArray[0].length;
	}

	public Matrix add(Matrix m) {
		if (isNull() || m.isNull())
			return null;
		
		if (!isRegular() || !m.isRegular()) //���������Ƿ��ǹ����
			return null;

		if (count_row() != m.count_row()) // ��� �������������Ƿ�һ��
			return null;

		if (count_column() != m.count_column()) // ��� �������������Ƿ�һ��
			return null;

		final int row_count = count_row(); // �¾��������
		final int col_count = count_column(); // �¾��������

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

		if (count_column() != m.count_row()) // ���˾��������Ƿ�����һ�����������һ��
			return null;
		
		final int row_count = this.count_row(); // �¾��������
		final int col_count = m.count_column(); // �¾��������
		final int countK = m.count_row(); // ������Ԫ����� �ۼ� ʱ�ļ���ֵ

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
	private boolean isNull() {// �������Ƿ�Ϊ��
		if (matArray == null)
			return true;

		if (matArray.length == 0)
			return true;

		if (matArray[0].length == 0)
			return true;

		return false;
	}

	/**************************************************************/
	private boolean isRegular() { // ����Ƿ�ÿ��Ԫ������һ�£�Ĭ��ÿ��Ԫ����ͬ
		for (int i = 0; i < matArray.length - 1; i++)
			if (matArray[i].length != matArray[i + 1].length)
				return false;
		return true;
	}
}


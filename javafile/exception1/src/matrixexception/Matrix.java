package matrixexception;


public class Matrix {
	private int[][] matArray;

	public Matrix(int[][] mArray) throws MatrixException {
		
		if(mArray==null)
			throw new MatrixException("init Array is Null!");
		
		if(mArray.length==0)
			throw new MatrixException("Array'length is zero!");
		
		if(!(mArray instanceof int[][]))
			throw new MatrixException("Array is not 2 D !");
		
		if(!ArrayHelper.isRegular(mArray))
				throw new MatrixException("Array is not regular!");
		
		matArray = mArray.clone();
		
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

	public Matrix add(Matrix m) throws MatrixException {
		
		if (count_row() != m.count_row()) // ��� �������������Ƿ�һ��
			throw new MatrixException("the count of  row is not equal!");

		if (count_column() != m.count_column()) // ��� �������������Ƿ�һ��
			throw new MatrixException("the count of column is not equal!");

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

	public Matrix multi(Matrix m) throws MatrixException {

		if (count_column() != m.count_row()) // ���˾��������Ƿ�����һ�����������һ��
			throw new MatrixException("the count of the first Matrix's column is"
					+ "not equal to the count of the second Matrix's row!");
		
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

}

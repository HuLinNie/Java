package ioflow;

public class ArrayHelper {
	public static boolean isRegular(int[][] array) { // ����Ƿ�ÿ��Ԫ������һ�£�Ĭ��ÿ��Ԫ����ͬ
		for (int i = 0; i < array.length - 1; i++)
			if (array[i].length != array[i + 1].length)
				return false;
		return true;
	}
}

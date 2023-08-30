package ioflow;

public class ArrayHelper {
	public static boolean isRegular(int[][] array) { // 检测是否每行元素数量一致，默认每行元素相同
		for (int i = 0; i < array.length - 1; i++)
			if (array[i].length != array[i + 1].length)
				return false;
		return true;
	}
}

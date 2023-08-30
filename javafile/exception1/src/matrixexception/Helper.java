package matrixexception;

import java.io.OutputStream;
import java.io.PrintStream;

public class Helper {
	public static void main(String[] args) {
		String str = "{{1,2,3},{4,5,6},{7,2,2}}";
		int[][] iarr = toIntArray(str);
		for (int i = 0; i < iarr.length; i++) {
			for (int j = 0; j < iarr[i].length; j++) {
				System.out.print(iarr[i][j]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}

	public static void outTo(int[][] iarr,OutputStream os) {
		PrintStream ps =(os instanceof PrintStream)? (PrintStream)os : new PrintStream(os);
		for (int i = 0; i < iarr.length; i++) {
			for (int j = 0; j < iarr[i].length; j++) {
				ps.print(iarr[i][j]);
				ps.print(" ");
			}
			ps.print("\n");
		}
	}
	/*
	 * 字符串： {{a,b,c},{d,e,f},{g,h,i}} ==> 字符串数组 ： {"a,b,c","d,e,f","g,h,i"}
	 */
	public static String[] toStringArray(String arrString) {
		// dArrString ==> {a,b,c},{d,e,f},{g,h,i}
		String tmp = Helper.trimBrace(arrString);

		// 使用"},{"对字符串分割，将字符按行串拆分成一个字符串数组,特殊字符需要转义 "\\}\\,\\{"
		// dArrString ==> 字符串数组： { "{a,b,c" , "d,e,f", "g,h,i}" }
		String[] rows = tmp.split("\\}\\,\\{");
		for (int i = 0; i < rows.length; i++) {
			// 将两端大括号去掉
			rows[i] = Helper.trimBrace(rows[i]);
		}
		return rows;
	}

	/*
	 * dArrString : {{a,b,c},{d,e,f},{g,h,i}}
	 */
	public static int[][] toIntArray(String dArrString) {
		try {
			// dArrString ==> 字符串数组： { "a,b,c" , "d,e,f", "g,h,i" }
			String[] rows = Helper.toStringArray(dArrString);

			int[][] iArray = new int[rows.length][];
			// 按行处理
			for (int i = 0; i < rows.length; i++) {
				// String： "a,b,c" ==> 字符串数组： {"a", "b", "c"}
				String[] strColumn = rows[i].split(",");
				// 按每行元素个数，创建整数数组
				iArray[i] = new int[strColumn.length];
				for (int j = 0; j < strColumn.length; j++) {
					// 字符串 转换为 数字 存入
					iArray[i][j] = Integer.parseInt(strColumn[j].trim());
				}
			}
			return iArray;
		} catch (Exception ex) {

		}
		return null;
	}

	public static String toIntArrayString(int[][] arr) {
		StringBuilder builder = new StringBuilder();
		builder.append("{");

		if (arr != null) {
			for (int i = 0; i < arr.length; i++) {
				builder.append("{");

				for (int j = 0; j < arr[i].length; j++) {
					builder.append(arr[i][j]);
					if (j != arr[i].length - 1)
						builder.append(',');
				}

				builder.append("}");
				if (i != arr.length - 1)
					builder.append(",");
			}
		}
		builder.append("}");
		return builder.toString();
	}

	public static String toIntArrayString(int[] arr) {
		StringBuilder builder = new StringBuilder();
		builder.append("{");

		if (arr != null) {
			for (int j = 0; j < arr.length; j++) {
				builder.append(arr[j]);
				if (j != arr.length - 1)
					builder.append(',');
			}
		}

		builder.append("}");
		return builder.toString();
	}

	public static String trimBrace(String str) {
		final char leftBrace = '{';
		final char rightBrace = '}';

		int begin = 0;
		int end = str.length();
		if (str.charAt(begin) == leftBrace)
			begin = begin + 1;
		if (str.charAt(end - 1) == rightBrace)
			end = end - 1;
		return str.substring(begin, end);
	}

	public static String trimLeftBrace(String str) {
		final char leftBrace = '{';
		int begin = 0;
		if (str.charAt(begin) == leftBrace)
			begin = begin + 1;
		return str.substring(begin);
	}

	public static String trimRightBrace(String str) {
		final char rightBrace = '}';
		int end = str.length();
		if (str.charAt(end - 1) == rightBrace)
			end = end - 1;
		return str.substring(0, end);
	}
}

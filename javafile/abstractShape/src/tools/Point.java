package tools;
public class Point {
	public int x;
	public int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "{" + x + "," + y + "}";
	}

	// **********************************************************************//
	// **********************************************************************//
	// { 3, 4 }
	public static Point fromString(String ptStr) {
		try {
			String str = Helper.trimBrace(ptStr);
			String[] array = str.split(",");
			int x = Integer.parseInt(array[0]);
			int y = Integer.parseInt(array[1]);
			return new Point(x, y);
		} catch (Exception ex) {
			return null;
		}
	}



	// 将坐标数组转换为每行两个元素的二维数组格式的字符串，如："{{3,4},{5,7},{3,9}}"
	public static String toString(Point[] ptArray) {
		StringBuilder builder = new StringBuilder();
		builder.append('{');

		if (ptArray != null) {
			for (int i = 0; i < ptArray.length; i++) {
				builder.append(ptArray[i].toString());
				if (i != ptArray.length - 1)
					builder.append(',');
			}
		}

		builder.append('}');
		return builder.toString();
	}
	// 每行两个元素的二维数组格式的字符串，字符串中间不包含空格，如： "{{3,4},{5,7},{3,9}}"
	public static Point[] fromArrayString(String ptStrs) {
		try {
			String[] ptStrings = Helper.toStringArray(ptStrs);
			Point[] ptArray = new Point[ptStrings.length];
			for (int i = 0; i < ptStrings.length; i++) {
				ptArray[i] = Point.fromString(ptStrings[i]);
			}
			return ptArray;
		} catch (Exception ex) {

		}
		return null;
	}
	//
	// 每行2个元素，例如：{ { 3, 4 }, {5, 7},{ 3, 9 } }
	public static Point[] fromArray(int[][] iArray) {
		try {
			Point[] ptArray = new Point[iArray.length];
			for (int i = 0; i < iArray.length; i++) {
				ptArray[i] = new Point(iArray[i][0], iArray[i][1]);
			}
			return ptArray;
		} catch (Exception ex) {

		}
		return null;
	}

	// public static int[][] toArray(ShapePoint[] ptArray)

	/******************************************************/
}

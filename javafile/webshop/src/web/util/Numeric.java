package web.util;


public class Numeric {
	public static String toFixedDecimalString(double value, int len) {
		StringBuilder builder = new StringBuilder();
		builder.append('.');
		for(int i = 0 ; i < len ; i++)
			builder.append('0');
		
		java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat(builder.toString());//构�?�方法的字符格式这里如果小数不足2�?,会以0补足.
		String amount = decimalFormat.format(value);//format 返回的是字符�?
		return amount;

	}
}

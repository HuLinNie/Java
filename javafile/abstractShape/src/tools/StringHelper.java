package tools;

import java.util.List;
import java.util.Vector;

public class StringHelper {
	
	public static List<Integer> indexof(String str, String s) {
		Vector<Integer> ilist = new Vector<Integer>();
		int len_substr = s.length();
		int i = -1;
		int begin = 0;
		do {
			i = str.indexOf(s,begin);
			if (i != -1) {
				ilist.add(i);
				begin = i + len_substr;
			}
		} while (i != -1);

		return ilist;
	}
	
	public static void main(String[] args) {
		String s1 = "abcdefabcedf asss";
		String s2 = "ab";
		System.out.println(s1.replace("ab", "12"));
	}

}

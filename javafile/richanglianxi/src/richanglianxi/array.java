package richanglianxi;
import java.io.IOException;
import java.util.Scanner;
public class array {
	public static void main(String[] args) throws IOException {
//		Scanner scr = new Scanner(System.in);
//		String tmp=scr.nextLine();
//		scr.close();
//		String[]array=tmp.split(",");
////		首先要将输入的字符串转化为字符串数组，
////		对输入的逗号进行处理
////		然后进行类型转化
//		int [] a = new int[array.length];
//		for(int m=0;m<a.length;m++){ 
//			a[m]=Integer.parseInt(array[m]);
//		}
//			
////		String str = Helper.trimBrace(ptStr);
////		String[] array = str.split(",");
////		int x = Integer.parseInt(array[0]);
////		int y = Integer.parseInt(array[1]);
////		return new Point(x, y);
//		for(int i=0;i<a.length;i++) {
//			int min=a[i];
//			int m_pos=i;
//			for (int j=i+1;j<a.length;j++)
//			{if(min>a[j]) {
//				min=a[j];
//				m_pos=j;
//			}	
//		
//			}
//			if(m_pos!=i) {
//				a[m_pos]=a[i];
//				a[i]=min;
//			}
//			System.out.println(a[i]);
//		}
		Scanner scr = new Scanner (System.in) ;
		String tmp= scr.nextLine();
		scr.close();
		String [] arr = tmp.split(",");
		int [] a = new int[arr.length];
		for (int i=0;i<a.length;i++) {
			a[i]=Integer.parseInt(arr[i]);
		}
		for(int j=0;j<a.length;j++) {
			int min = a[j];
			int m_pos = j;
			for (int z=j+1;z<a.length;z++) {
				if(min>a[z]) {
					min = a[z];
					m_pos=z;
				}
				}
				if(m_pos != j) {
					a[m_pos]=a[j];
					a[j]=min;
				}
				System.out.println(a[j]);		
		}		
	
	}
}

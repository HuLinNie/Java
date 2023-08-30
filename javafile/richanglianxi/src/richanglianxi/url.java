package richanglianxi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;



public class url {
	public static void main(String ...args) {
	try{URL ur=new URL("http://www.neuq.edu.cn");
		URLConnection conn = ur.openConnection();
		
		OutputStream in = conn.getOutputStream();
		int c;
//		while((c=((InputStream) in).read())!=-1) {
//			System.out.print(c);
//		}
	
	}catch(IOException e){
		e.printStackTrace();
	}

	

}
}
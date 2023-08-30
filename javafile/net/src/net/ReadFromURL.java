package net;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
public class ReadFromURL {
	public static void main(String[] args) {
		try {
			URL u = new URL("http://mail.neuq.edu.cn");
			try(InputStream in = u.openStream()){
				int c ;
				while((c=in.read())!=-1) System.out.write(c);
			}
		}catch(IOException ex) {
			
		}
	}
}

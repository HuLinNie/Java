package richanglianxi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class socket {
	public  static void main(String... args) {
	try{ServerSocket str = new ServerSocket(9999);
		Socket soc = str.accept();
		
	
	}
	catch(IOException e) {
		e.printStackTrace();
	}
	System.out.println("successssss");
	
	}
}

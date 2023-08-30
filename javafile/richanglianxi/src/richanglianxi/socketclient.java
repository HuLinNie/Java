package richanglianxi;

import java.io.IOException;
import java.net.Socket;

public class socketclient {
	public static void main(String ...args) {
		try {
			Socket soc = new Socket("129.0.0.1",9999);
		}catch(IOException e){
			e.printStackTrace();
			
		}
		System.out.print("success");
		
		
		
		
		
	}

}

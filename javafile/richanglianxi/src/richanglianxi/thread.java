package richanglianxi;

public class thread extends Thread {
	public void run() {
		int i=0;
		while(i<100) {
			System.out.println("threat:"+i);
			i++;
		}
	}
	public static void main(String... args)
	{ thread t1= new thread();
	 Thread t =new Thread(t1); 
	
	t.start();
	int i=0;
	for( i=0;i<20;i++){
		System.out.println("main thread :"+i);
	}		
	}

}

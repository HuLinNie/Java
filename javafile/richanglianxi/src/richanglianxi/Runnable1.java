package richanglianxi;

public class Runnable1 implements  Runnable {
	public synchronized void  run() {
		int i=0;
		while(i<100) {
			System.out.println("threat:"+i);
			i++;
		}
	}
	
	public static void main(String... args)
	{ Runnable1 t1= new Runnable1 ();
	 Thread t =new Thread(t1); 
	 t.setPriority(Thread.MAX_PRIORITY);
	 t.setDaemon(true);
	t.start();
	int i=0;
	for( i=0;i<20;i++){
		System.out.println("main thread :"+i);
	}		
	}
}

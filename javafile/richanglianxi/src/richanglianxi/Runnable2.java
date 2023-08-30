package richanglianxi;

public class Runnable2 {
	@SuppressWarnings("static-access")
	public static void main(String... args) 
	{ 
		Runnable r=()-> {
			
				int i=0;
				while(i<100) {
					System.out.println("threat:"+i);
					i++;
				}
				
			

	};
	 Thread t =new Thread(r); 
	 t.setPriority(Thread.MAX_PRIORITY);
	 t.setDaemon(true);
	 t.start();
	int i=0;
	for( i=0;i<20;i++){
		System.out.println("main thread :"+i);
	}		
	}
}

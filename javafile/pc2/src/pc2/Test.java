package pc2;
public class Test {
	public static void main(String[] args) {
		Buffer di = new Buffer(4);
		
		Producer p = new Producer(di);
		Consumer c = new Consumer(di,50);
		
		Thread tProd1 = new Thread(p,"Prod1");
		tProd1.setDaemon(true);
		tProd1.start();
		
		Thread tCust1 = new Thread(c,"Cust1");
		tCust1.start();
	}
}


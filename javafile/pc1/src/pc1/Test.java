package pc1;


public class Test {
	public static void main(String[] args) {
		Buffer di = new Buffer(4);
		
		Producer p = new Producer(di);
		Consumer c = new Consumer(di);
		
		Thread tProd1 = new Thread(p,"Prod1");
		tProd1.start();
		
		Thread tProd2 = new Thread(p,"Prod2");
		tProd2.start();
		
		Thread tCust1 = new Thread(c,"Cust1");
		tCust1.start();
		
		Thread tCust2 = new Thread(c,"Cust2");
		tCust2.start();
	}
}

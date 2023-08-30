package saleticket;
public class SaleTicket4 implements Runnable {
	private int i = 1;
	private int getATicket() {
		int ret = 0;
		if (i <= 20) {
			ret = i;
			i++;
		} 
		return ret;
	}
	public void run() {
		Thread current = Thread.currentThread();
		while (true) {
			int ticket = getATicket();
			if (ticket == 0) 
				break;
			System.out.println(current.getName() + " saleTicket:" + ticket);
			Thread.yield();
		}
	}
	public static void main(String[] args) {
		Runnable st = new SaleTicket4();
		Thread t1 = new Thread(st, "Terminal1");
		Thread t2 = new Thread(st, "Terminal2");
		Thread t3 = new Thread(st, "Terminal3");
		t1.start();
		t2.start();
		t3.start();
	}
}



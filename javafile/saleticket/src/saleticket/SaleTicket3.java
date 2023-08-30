package saleticket;
public class SaleTicket3 {
	public static void main(String[] args) {
		Runnable st = new Runnable() {
			private int i = 1;

			public void run() {
				Thread current = Thread.currentThread();
				while (true) {
					synchronized (this) {
						if (i > 20)
							break;
						System.out.println(current.getName() + " saleTicket:" + i++);
						Thread.yield();
					}
				}
			}
		};

		Thread t1 = new Thread(st, "Terminal1");
		Thread t2 = new Thread(st, "Terminal2");
		Thread t3 = new Thread(st, "Terminal3");
		t1.start();
		t2.start();
		t3.start();
	}
}


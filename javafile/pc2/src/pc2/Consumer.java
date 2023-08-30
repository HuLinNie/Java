package pc2;

public class Consumer implements Runnable {
	private Buffer di;
	private int count;
	public Consumer(Buffer di,int count) {
		this.di = di;
		this.count = count;
	}
	public void run() {
		try {
			int consumed = 0;
			while (true) {
				if(consumed >= count)
					break;
				int val = di.getValue();
				//。处理数据val，模拟消费过程
				consumed++;
				System.out.println(consumed + " have been consumed");
				int rnd_sleep = (int) (Math.random() * 1000);
				Thread.sleep(rnd_sleep);
			}
		} catch (InterruptedException e) {
		}
	}
}


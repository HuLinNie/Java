package pc1;

public class Consumer implements Runnable {
	private Buffer di;

	public Consumer(Buffer di) {
		this.di = di;
	}
	public void run() {
		try {
			while (true) {
				int val = di.getValue();
				//处理数据val，模拟消费过程
				int rnd_sleep = (int) (Math.random() * 1000);
				Thread.sleep(rnd_sleep);
			}
		} catch (InterruptedException e) {
		}
	}
}


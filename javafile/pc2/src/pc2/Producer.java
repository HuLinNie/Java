package pc2;

public class Producer implements Runnable {
	private Buffer di;
	public Producer(Buffer di) {
		this.di = di;
	}
	public void run() {
		try {
			while(true) {
				int rnd = (int) (Math.random() * 100);
				di.setValue(rnd);
				int rnd_sleep = (int) (Math.random() * 1000);
				Thread.sleep(rnd_sleep);
			}
		} catch (InterruptedException e) {
		}
	}
}

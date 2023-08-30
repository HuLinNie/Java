package pc1;
public class Buffer {
	private int[] dArray;
	/**
	 * 缓冲区中数据数量
	 */
	private int count = 0;
	/**
	 * 用于记录下一个可放置数据的位置
	 */
	int next_pos_set = 0;
	/**
	 * 用于记录下一个可以取数据的位置
	 */
	int next_pos_get = 0;
	/**
	 * 
	 * @param len 设定数组长度，即缓冲区的大小
	 */
	public Buffer(int len) {
		dArray = new int[len];
	}

	public synchronized void setValue(int val) throws InterruptedException {
		
		while (isFull()) 
			wait();

		dArray[next_pos_set] = val;
		System.out.println(Thread.currentThread().getName() + " put value: " + val + "@" + next_pos_set);
		
		next_pos_set = (next_pos_set + 1) % dArray.length;
		count++;
		display();

		notifyAll();
	}

	public synchronized int getValue() throws InterruptedException {
		while (isEmpty()) {
			wait();
		}
		int val = dArray[this.next_pos_get];
		System.out.println(Thread.currentThread().getName() + " take value: " + val + "@" + next_pos_get);
		
		next_pos_get = (next_pos_get + 1) % dArray.length;
		count--;
		display();

		notifyAll();
		
		return val;
	}
	/**
	 * 判断缓冲区是否为空
	 * @return
	 */
	private boolean isEmpty() {
		return count == 0;
	}
	/**
	 * 判断缓冲区是否为满
	 * @return
	 */
	private boolean isFull() {
		return count == dArray.length;
	}
	/**
	 * 辅助方法，用于屏幕显示缓冲区中的数据
	 */
	private void display() {
		System.out.print("{");
		
		for (int pos = this.next_pos_get,i = 0; i < count; i++,pos = (pos+1) % dArray.length) {
			
			System.out.print(dArray[pos]);
			if (i < count - 1)
				System.out.print(",");
		}
		
		System.out.println("}");
	}
}


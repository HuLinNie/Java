package testthread;
public class TestThread5 extends Thread    {
    private String flag;
    public TestThread5(String flag)    {
        this.flag = flag;
    }
    public void run()    {
        int i = 0;
        while(true)     {
            System.out.print(flag + ":" + i + " ");
            yield();
            i++;
            if(i > 100)    {
                break;
            }
        }
    }
    public static void main(String[] args)    {
        TestThread5 tt1 = new TestThread5("A");
        TestThread5 tt2 = new TestThread5("B");
        TestThread5 tt3 = new TestThread5("C");
        tt1.start();
        tt2.start();
        tt3.start();

        for(int i = 0; i <= 100; i++)    {
            System.out.print("M:" + i + " ");
            Thread.yield();
        }
    }
}

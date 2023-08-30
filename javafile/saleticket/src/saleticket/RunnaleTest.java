package saleticket;
class SaleTicketRunnable1 implements Runnable
{
    public void run()
    {
    	Thread current = Thread.currentThread();  
        int i = 1;
        while(i<=20)
        {
            System.out.println(current.getName() + " saleTicket:" + i);
            i++;
        }
    }
}
public class RunnaleTest {
    public static void main(String[] args)
    {
        Runnable st = new SaleTicketRunnable1();
        Thread t1 = new  Thread(st);
        Thread t2 = new Thread(st);
        Thread t3= new Thread(st);
        t1.start();
        t2.start();
        t3.start();
        for(int i = 0; i < 100; i++)
        {
            System.out.println("Main Thread:" + i);
        }
    }
}



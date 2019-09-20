package CompareCode;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main
{
    public static void main(String[] args)
    {
        //Runnable wypisanie = new WypisanieRunnable();

       /* Object lock = new Object();

        Thread watek = new Thread(new WypisanieRunnable(lock), "Watek 1");
        Thread watek2 = new Thread(new WypisanieRunnable(lock), "Watek 2");

        watek.start();
        watek2.start();*/

        Counter licznik = new Counter();
        //Runnable costam = new CounterRunnable(licznik, false);

        Thread watek3 = new Thread(new CounterRunnable(licznik, false), "Maleje");
        Thread watek4 = new Thread(new CounterRunnable(licznik, true), "Rośnie");

        watek3.start();
        watek4.start();

        ////////////////////////////////////////

        Object lock = new Object();

        Thread watek = new Thread(new WypisanieRunnable(lock), "Watek 1");
        Thread watek2 = new Thread(new WypisanieRunnable(lock), "Watek 2");
        Thread watekX = new Thread(new WypisanieRunnableX(lock), "Watek X1");
        Thread watekX2 = new Thread(new WypisanieRunnableX(lock), "Watek X2");

        watek.start();

        try {
            watek.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
        System.out.println("cos tu sie dzieje OD RAZU po skonczonym watku watek");

        watek2.start();

        watekX.start();

        try {
            watekX.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
        System.out.println("To jest wątek X");

        watekX2.start();


        ///////////////////////////////

        Lock lock2 = new ReentrantLock();

        Thread watek5 = new Thread(new WypisanieRunnable2(lock2), "Watek 5");
        Thread watek6 = new Thread(new WypisanieRunnable2(lock2), "Watek 6");

        watek5.start();

        //watek.join();
        System.out.println(Thread.currentThread().getName());
        System.out.println("zawartość z klasy LOCK");

        watek6.start();



    }
}

class WypisanieRunnable implements Runnable
{
    public WypisanieRunnable(Object lock)
    {
        this.lock = lock;
    }
    static String msg[] = {"To", "jest", "synchronicznie", "wypisana", "wiadomosc"};
    public void run()
    {
        display(Thread.currentThread().getName());
    }

    public void display(String threadName)
    {
        synchronized(lock)
        {
            for(int i = 0; i < msg.length; i++)
            {
                System.out.println(threadName+": "+msg[i]);

                try
                {
                    Thread.sleep(1);
                }
                catch(InterruptedException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private Object lock;
}

class Counter
{
    public void increaseCounter()
    {
        counter++;
        System.out.println(Thread.currentThread().getName()+": "+counter);
    }
    public void decreaseCounter()
    {
        counter--;
        System.out.println(Thread.currentThread().getName()+": "+counter);
    }
    private int counter = 50;
}
class CounterRunnable implements Runnable
{
    public CounterRunnable(Counter licznik, boolean increase)
    {
        this.licznik = licznik;
        this.increase = increase;

    }
    public void run()
    {
        synchronized(licznik)
        {
            for (int i = 0; i < 500; i++)
            {
                if (increase)
                    licznik.increaseCounter();
                else
                    licznik.decreaseCounter();
                try
                {
                    Thread.sleep(10);
                }
                catch(InterruptedException e)
                {
                    System.out.println(e.getMessage());
                }

            }
        }
    }
    boolean increase;
    Counter licznik;
}

class WypisanieRunnableX implements Runnable
{
    public WypisanieRunnableX(Object lock)
    {
        this.lock = lock;
    }
    static String msg[] = {"To", "jest", "synchronicznie", "wypisana", "wiadomosc"};
    public void run()
    {
        display(Thread.currentThread().getName());
    }

    public void display(String threadName)
    {
        synchronized(lock)
        {
            for(int i = 0; i < msg.length; i++)
            {
                System.out.println(threadName+": "+msg[i]);

                try
                {
                    Thread.sleep(100);
                }
                catch(InterruptedException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private Object lock;

}


class WypisanieRunnable2 implements Runnable
{
    public WypisanieRunnable2(Lock lock)
    {
        this.lock = lock;
    }
    static String msg[] = {"To", "jest", "synchronicznie", "wypisana", "wiadomosc"};
    public void run()
    {
        display(Thread.currentThread().getName());
    }

    public void display(String threadName)
    {
        lock.lock();
        try
        {
            for(int i = 0; i < msg.length; i++)
            {
                System.out.println(threadName+": "+msg[i]);

                try
                {
                    Thread.sleep(100);
                }
                catch(InterruptedException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
        finally
        {
            lock.unlock();
        }

    }

    private Lock lock;

}
/*
 * counter = 5
 * Thread 1 - pobiera wartosc countera
 * Thread 2 - pobiera wartosc countera
 * Thread 1 - powieksza wartosc o 1
 * Thread 2 - pomniejsza wartosc o 1
 * Thread 1 - zapisuje counter 6 -- NIE ZAPAMIETANE!!!
 * Thread 2 - zapisuje w te SAME miejsce counter 4
 * */


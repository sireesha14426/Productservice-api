package threads;

public class Printnumber implements Runnable{
    private int number;
    public Printnumber(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("we are printing" + this.number + "the thread number " + Thread.currentThread().getName());
    }
}

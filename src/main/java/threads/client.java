package threads;

public class client {
    public static void main(String[] args) {
        for(int i=0; i<100; i++){
            Printnumber p= new Printnumber(i);
            Thread t = new Thread(p);
            t.start();
        }
    }

}

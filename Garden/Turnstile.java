public class Turnstile extends Thread {
//    public Counter count;
    int i=0;
    String direction;
    Turnstile(String direction) {
        this.direction = direction;
    }
    public void run() {
        while(i < 100) {
            System.out.println("Thread-"+direction+": "+i);
            i++;
            yield();
        }

    }
//    public static void main(String[] args) {
//        for(int i = 0; i < 3; i++) {
//            new Turnstile(i).start();
//        }
//    }

}

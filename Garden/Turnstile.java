public class Turnstile extends Thread {
   public Counter count;
    int i=0;
    String direction;
    Turnstile(String direction,Counter count) {
        this.direction = direction;
        this.count = count;
    }
    public void run() {
        while(i < 50) {
          count.readValue();
          System.out.print("Thread-"+direction+": ");
          count.writeValue();
          i++;
        }
    }
}

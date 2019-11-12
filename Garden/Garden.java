public class Garden {

  public static Counter count;

  public Turnstile turnstile;



  public static void main(String[] args){
    Counter count = new Counter();
    Turnstile west = new Turnstile("west",count);
    Turnstile east = new Turnstile("east",count);
    west.start();
    east.start();
    System.out.println(count.readValue());
  }
}

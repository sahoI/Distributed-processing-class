public class Garden {    public Counter count;	public Turnstile turnstile_west;	public Turnstile turnstile_east;	public static void main(String[] args) {		System.out.println("Garden");		// 2つのスレッドの実行を開始//		for(int i = 0; i < 2; i++){//			new Turnstile().start();//		}		Turnstile west = new Turnstile("0 ");		Turnstile east = new Turnstile("1 ");//		Turnstile north = new Turnstile("north");//		Turnstile south = new Turnstile("south");		west.start();		east.start();//		north.start();//		south.start();//		this.count.readValue(1);//		turnstile_e.myThread(1);//		turnstile_e.run("east");//		turnstile_east;	}}
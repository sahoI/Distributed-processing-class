public class Arrivals extends Thread {

	public CarparkControl control;

	public int waitTime;

	private CarparkControl carparkControl;
	int i=0;
	public Arrivals(CarparkControl control) {
		this.control = control;
	}

	public void run() {
		while(i < 50) {
			try {
				control.arrive();
				break;
				// Thread.sleep(2000);
			} catch(Exception e) {
				System.out.println("例外が発生しました。: "+e);
			}
			System.out.println(i);
			i++;
		}
	}
}

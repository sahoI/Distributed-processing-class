public class Arrivals extends Thread {

	public CarparkControl control;

	public int waitTime;

	private CarparkControl carparkControl;

	public Arrivals(CarparkControl control) {
		this.control = control;
	}

	public void run() {
		for(;;){
			control.arrive();
			try {
				Thread.sleep(2000);
			} catch(Exception e) {
				System.out.println("例外が発生しました。: "+e);
			}
		}
	}
}

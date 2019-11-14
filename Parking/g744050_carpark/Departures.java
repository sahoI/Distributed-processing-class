public class Departures extends Thread {

	public CarparkControl control;

	public int waitTime;

	private CarparkControl carparkControl;

	public Departures(CarparkControl control) {
		this.control = control;
	}

	public void run() {
		for(;;){
			control.depart();
			try {
				Thread.sleep(5000);
			} catch(Exception e) {
				System.out.println("例外が発生しました。: "+e);
			}
		}
	}

}

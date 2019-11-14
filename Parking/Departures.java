public class Departures extends Thread {

	public CarparkControl control;

	public int waitTime;

	private CarparkControl carparkControl;
	int i=0;
	public Departures(CarparkControl control) {
		this.control = control;
	}

	public void run() {
		while(i < 50) {
			try {
				control.depart();
				break;
			} catch(Exception e) {
				System.out.println("例外が発生しました。: "+e);
			}
			System.out.println(i);
			i++;
		}
	}

}

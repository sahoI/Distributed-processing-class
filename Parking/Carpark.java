public class Carpark {

	public CarparkControl control;

	private CarparkControl carparkControl;

	public static void main(String[] args) {
		System.out.println(args[0]);
		CarparkControl control = new CarparkControl();
		control.CarparkControl(Integer.parseInt(args[0]));
		Arrivals arrive = new Arrivals(control);
		Departures depart = new Departures(control);
		arrive.start();
		// depart.sleep(300);
		depart.start();
	}
}

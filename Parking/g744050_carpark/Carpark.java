public class Carpark {

	public CarparkControl control;

	private CarparkControl carparkControl;

	public static void main(String[] args) {
		CarparkControl control = new CarparkControl();
		control.CarparkControl(Integer.parseInt(args[0]));

		Arrivals arrive = new Arrivals(control);
		Departures depart = new Departures(control);
		arrive.start();
		depart.start();
	}
}

public class CarparkControl {

	public int spaces;

	public int capacity;

	public void CarparkControl(int value) {
		 this.spaces = value;
		 this.capacity = value;
		 System.out.println("最初の駐車スペースは"+this.capacity+"です。");
	}

	public synchronized void arrive() {
		if(this.spaces != 0) {
			this.spaces = this.spaces - 1;
			System.out.println("車が到着。spaces = "+this.spaces+"台");
		}
		notify();
	}

	public synchronized void depart() {
		if(this.spaces != this.capacity) {
			this.spaces = this.spaces + 1;
			System.out.println("車が発車。spaces = "+this.spaces+"台");
		}
		notify();
	}

}

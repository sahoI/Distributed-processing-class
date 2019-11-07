public class Counter {

	private int value;

	public int readValue(int num) {
		this.value = num;
		writeValue();
		return this.value;
	}

	public void writeValue() {
		System.out.println("Counter");

	}

}

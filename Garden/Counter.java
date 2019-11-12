public class Counter {

	private int value = 0;

	public int readValue() {
		return this.value;
	}

	public void writeValue() {
        value = value + 1;
        System.out.println(this.value);
	}
}

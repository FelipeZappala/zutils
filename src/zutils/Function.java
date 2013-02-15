package zutils;

public abstract class Function implements Runnable {

	public final Parameters results;
	public final Parameters params;
	
	public Function() {
		this.results = new Parameters();
		this.params = new Parameters();
	}

}

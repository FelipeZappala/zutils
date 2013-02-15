package zutils;

public abstract class Func implements Runnable {

	public final Parameters results;
	public final Parameters params;
	
	public Func() {
		this.results = new Parameters();
		this.params = new Parameters();
	}

}

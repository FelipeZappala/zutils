package zutils.support;

public class IntegerSequence implements Sequence<Integer> {

	private int current;
	private int start;
	private int end;
	private int step;
	
	public IntegerSequence() {
		init(0, 10);
	}
	
	public void init(Integer start, Integer end, Integer step) {
		this.start = start;
		this.end = end;
		this.step = step;
	}

	public void init(Integer start, Integer end) {
		init(start, end, 1);
	}

	public boolean hasNext() {
		return current < end;
	}

	public Integer next() {
		if (hasNext()) {
			if (current == 0)
				return current = start;
			
			return current = current + step;
				
		}
		return null;
	}

	public Integer current() {
		return current;
	}
	
}

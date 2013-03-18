package zutils.support;

public class IntegerSequence implements Sequence<Integer> {

	private Integer current;
	private Integer start;
	private Integer end;
	private Integer step;
	
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
		return current == null || current < end;
	}

	public Integer next() {
		if (hasNext()) {
			if (current == null) {
				return current = start;
			}
			return current = current + step;
		}
		return null;
	}

	public Integer current() {
		return current;
	}
	
}

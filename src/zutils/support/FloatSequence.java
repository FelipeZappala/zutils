package zutils.support;

public class FloatSequence implements Sequence<Float> {

	private Float current;
	private Float start;
	private Float end;
	private Float step;
	
	public FloatSequence() {
		init(0F, 1F);
	}
	
	public void init(Float start, Float end, Float step) {
		this.start = start;
		this.end = end;
		this.step = step;
	}

	public void init(Float start, Float end) {
		init(start, end, 0.1F);
	}

	public boolean hasNext() {
		return current == null || current < end;
	}

	public Float next() {
		if (hasNext()) {
			if (current == null) {
				return current = start;
			}
			return current = current + step;
		}
		return null;
	}

	public Float current() {
		return current;
	}
	
}

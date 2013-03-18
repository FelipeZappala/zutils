package zutils.support;

public interface Sequence<T> {
	
	void init(T start, T end, T step);
	
	void init(T start, T end);
	
	boolean hasNext();
	
	T next();

	T current();
}

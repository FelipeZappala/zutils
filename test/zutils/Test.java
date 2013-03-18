package zutils;

import java.math.BigDecimal;

import zutils.support.FloatSequence;
import zutils.support.IntegerSequence;
import zutils.support.Sequence;

public class Test {

	public static void main(String[] args) {
		Sequence<Float> seq = new FloatSequence();
		seq.init(-4f, 16f, 1f);
		
		while (seq.hasNext()) {
			System.out.println(seq.next());
			System.out.println(seq.current()  + " - " + seq.current() );
		}
		System.out.println(seq.next()  + " - " + seq.current() );
		System.out.println(seq.next()  + " - " + seq.current() );
	}
	
	public static <T> T cast(Class<T> c, Object o) {
		return c.cast(o);
	}
	
	public static <T> T cast(Object o) {
		return (T) o;
	}
	
	public static <T extends Number> int sum(T... numbers) {
		BigDecimal total = BigDecimal.ZERO;
		
		for (T t : numbers) {
			total = total.add(new BigDecimal(t.toString()));
		}
		return total.intValue();
	}
	
}

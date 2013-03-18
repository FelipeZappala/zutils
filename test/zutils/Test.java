package zutils;

import java.math.BigDecimal;

public class Test {

	public static void main(String[] args) {
		Object o = new Object();
		
		o = (int) 1;
		System.out.println(o instanceof Number);
		
		o = (short) 1;
		System.out.println(o instanceof Number);
		
		o = (double) 1.1;
		System.out.println(o instanceof Number);
		
		o = (char) 1;
		System.out.println(o instanceof Number);
		
		o = "4";
		System.out.println(o instanceof Number);
	}
	
	public static <T extends Number> int sum(T... numbers) {
		BigDecimal total = BigDecimal.ZERO;
		
		for (T t : numbers) {
			total = total.add(new BigDecimal(t.toString()));
		}
		return total.intValue();
	}
	
}

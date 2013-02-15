package zutils.core;

public interface ConversionHandler {
	
	ConversionHandler elements(Object[] elements);
	
	String toString();
	
	String[] toStrings();
	
	int toInteger();
	
	int[] toIntegers();
	//TODO
}

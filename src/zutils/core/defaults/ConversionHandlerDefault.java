package zutils.core.defaults;

import java.util.ArrayList;
import java.util.List;

import zutils.core.ConversionHandler;
import zutils.core.functions.Function;
import zutils.core.functions.Function0;

class ConversionHandlerDefault implements ConversionHandler {

	private Object[] elements;
	
	public ConversionHandler elements(Object[] elements) {
		this.elements = elements;
		return this;
	}

	@Override
	public String toString() {
		return elements[0].toString();
	}
	
	public String[] toStrings() {
		List<String> list = new ArrayList<String>(elements.length);
		
		for (Object element : elements) {
			list.add(element.toString());
		}
		
		return list.toArray(new String[0]);
	}

	public int toInteger() {
		return elements[0] instanceof Integer 
				? (Integer) elements[0]
				: Integer.parseInt(elements[0].toString());
	}

	public int[] toIntegers() {
		int[] array = new int[elements.length];
		
		for (int i = 0; i < elements.length; ++i) {
			array[i] = Integer.parseInt(elements[i].toString());
		}
		
		return array;
	}

}

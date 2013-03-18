package zutils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import zutils.core.ConversionHandler;
import zutils.core.LogHandler;

class ZUtilsDefault extends ZUtils {

	//
	// Attributes //////////////////////////////////////////
	//
	private List<Object> elements;
	
	
	//
	// Constructor //////////////////////////////////////////
	//
	public ZUtilsDefault(Object[] elements) {
		this.elements = new LinkedList<Object>(Arrays.asList(elements));
	}

	//
	// Methods //////////////////////////////////////////////
	//
	
	@Override
	public int length() {
		return elements.size();
	}

	@Override
	public ConversionHandler convert() {
		ConversionHandler converter = ZUtils.factory().create(ConversionHandler.class);
		converter.elements(elements.toArray());
		
		return converter;
	}

	@Override
	public ZUtils log() {
		ZUtils.factory().create(LogHandler.class).log(elements.toArray());
		
		return this;
	}
	
	@Override
	public ZUtils log(LogHandler.Level level) {
		ZUtils.factory().create(LogHandler.class).log(level, elements.toArray());
		
		return this;
	}

	@Override
	public ZUtils each(Function function) {
		if (function != null && !this.elements.isEmpty()) {
			int counter = 0;
			for (Object element : elements) {
				function.params.set("index", counter++);
				function.params.set(element);
				function.run();
				//function.results;
			}
			
		}
		return this;
	}

	@Override
	public ZUtils filter(Function function) {
		if (function != null && !this.elements.isEmpty()) {
			int counter = 0;
			Iterator<?> it = iterator();
			
			while (it.hasNext()) {
				function.params.set(it.next());
				function.params.set("index", counter++);
				function.run();
				
				boolean found = function.results.get();
				if (!found)
					it.remove();
			}
		}
		return this;
	}
	
	@Override
	public boolean has(Object object) {
		return elements.contains(object);
	}

	@Override
	public Iterator<?> iterator() {
		return elements.iterator();
	}

	@Override
	public Enumeration<?> enumerator() {
		return Collections.enumeration(elements);
	}

	@Override
	public boolean isEmpty() {
		return elements.isEmpty();
	}

	@Override
	public boolean contains(Object object) {
		return has(object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T first() {
		if (!elements.isEmpty())
			return (T) elements.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T last() {
		if (!elements.isEmpty())
			return (T) elements.get(elements.size() -1);
		
		return null;
	}

}

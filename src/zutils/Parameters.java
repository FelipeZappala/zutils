package zutils;

import java.util.HashMap;
import java.util.Map;

public final class Parameters {
	
	private Map<Object, Object> elements;
	
	public Parameters() {
		this.elements = new HashMap<Object, Object>();
	}
	
	@SuppressWarnings("unchecked")
	private <T> T getElement(Object key) {
		return (T) elements.get(key);
	}
	
	public <T> T get() {
		return getElement("");
	}
	
	public <T> T get(String key) {
		return getElement(key);
	}
	
	public <T> T get(int index) {
		return getElement(index);
	}
	
	public Parameters set(Object object) {
		elements.put("", object);
		return this;
	}
	
	public Parameters set(String key, Object object) {
		elements.put(key, object);
		return this;
	}
	
	public Parameters set(int index, Object object) {
		elements.put(index, object);
		return this;
	}
	
}

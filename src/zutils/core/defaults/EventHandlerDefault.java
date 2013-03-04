package zutils.core.defaults;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import zutils.Function;
import zutils.core.EventHandler;

public class EventHandlerDefault implements EventHandler {

	private Map<String, List<Function>> events;
	
	public EventHandlerDefault() {
		events = new HashMap<String, List<Function>>();
	}
	
	private List<Function> event(String name) {
		if (!events.containsKey(name)) 
			events.put(name, new LinkedList<Function>());
		
		return events.get(name);
	}

	public EventHandler bind(String name, Function funcion) {
		event(name).add(funcion);
		
		return this;
	}

	public EventHandler unbind(String name) {
		events.remove(name);
		
		return this;
	}

	public EventHandler unbind(String name, Function funcion) {
		event(name).remove(funcion);
		
		return this;
	}
	

	public EventHandler notify(String name, Object... parameters) {
		if (events.containsKey(name)) {
			for (Function observer : events.get(name)) {
				observer.params.set(name);
				
				int i = 0;
				for (Object object : parameters) {
					observer.params.set(i++, object);	
				}
				
				observer.run();	
			}
		}
		return this;
	}
	
}

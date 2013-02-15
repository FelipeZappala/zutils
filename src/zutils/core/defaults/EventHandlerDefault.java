package zutils.core.defaults;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import zutils.Func;
import zutils.core.EventHandler;

public class EventHandlerDefault implements EventHandler {

	private Map<String, Object> events;
	private Map<String, List<Func>> observers;
	
	public EventHandlerDefault() {
		events = new HashMap<String, Object>();
		observers = new HashMap<String, List<Func>>();
	}

	public EventHandler add(String name, Object notifier) {
		events.put(name, notifier);
		return this;
	}

	public EventHandler remove(String name) {
		events.remove(name);
		return this;
	}

	public EventHandler observer(String name, Func funcion) {
		if (!observers.containsKey(name)) 
			observers.put(name, new LinkedList<Func>());
		
		observers.get(name).add(funcion);
			
		return this;
	}

	public EventHandler notify(String name, Object... parameters) {
		if (events.containsKey(name)) {
			for (Func observer : observers.get(name)) {
				observer.params.set("observable", events.get(name));
				
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

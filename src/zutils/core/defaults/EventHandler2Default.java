package zutils.core.defaults;

import java.util.LinkedList;
import java.util.List;

import zutils.Function;
import zutils.core.EventHandler2;

public class EventHandler2Default implements EventHandler2 {

	private Object target;
	private List<Function> observers;
	
	public EventHandler2Default() {
		this.observers = new LinkedList<Function>();
		this.target = new Object();
	}
	
	public EventHandler2 on(Object target) {
		this.target = target;
		return this;
	}

	public EventHandler2 bind(Function observer) {
		this.observers.add(observer);
		return this;
	}

	public EventHandler2 remove(Function observer) {
		this.observers.remove(observer);
		return this;
	}

	public EventHandler2 notify(Object observable, Object... parameters) {
		for (Function observer : observers) {
			observer.params.set(observable);
			observer.params.set("observable", observable);
			observer.params.set("event", target);
			
			if (parameters != null) {
				for (int i = 0; i < parameters.length; ++i) {
					observer.params.set(i, parameters[i]);
				}
			}
			observer.run();
		}
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof EventHandler2Default) {
			EventHandler2Default another = (EventHandler2Default) obj;
			return this.target.equals(another.target);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.target.hashCode();
	}
	
}

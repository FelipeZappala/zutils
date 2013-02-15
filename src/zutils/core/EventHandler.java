package zutils.core;

import zutils.Function;


public interface EventHandler {
	
	EventHandler add(String name, Object notifier);
	
	EventHandler remove(String name);

	EventHandler observer(String name, Function funcion);
	
	EventHandler notify(String name, Object... parameters);
	
}

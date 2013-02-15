package zutils.core;

import zutils.Func;


public interface EventHandler {
	
	EventHandler add(String name, Object notifier);
	
	EventHandler remove(String name);

	EventHandler observer(String name, Func funcion);
	
	EventHandler notify(String name, Object... parameters);
	
}

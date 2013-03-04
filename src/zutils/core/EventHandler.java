package zutils.core;

import zutils.Function;


public interface EventHandler {
	
	EventHandler bind(String name, Function funcion);
	
	EventHandler unbind(String name);
	
	EventHandler unbind(String name, Function funcion);
	
	EventHandler notify(String name, Object... parameters);
	
}

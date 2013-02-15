package zutils.core;

import zutils.Function;

public interface EventHandler2 {

	EventHandler2 event(Object target);
	
	EventHandler2 add(Function observer);
	
	EventHandler2 remove(Function observer);
	
	EventHandler2 notify(Object observable, Object...parameters);
	
}
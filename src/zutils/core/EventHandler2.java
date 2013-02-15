package zutils.core;

import zutils.Func;

public interface EventHandler2 {

	EventHandler2 event(Object target);
	
	EventHandler2 add(Func observer);
	
	EventHandler2 remove(Func observer);
	
	EventHandler2 notify(Object observable, Object...parameters);
	
}
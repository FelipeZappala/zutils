package zutils.core;

import zutils.core.exceptions.ZUtilsException;

public interface ExceptionHandler {
	
	boolean has();
	
	int length();
	
	ZUtilsException[] exceptions();
	
	ZUtilsException get(int index);
	
	ZUtilsException last();
	
	ExceptionHandler clear();
	
	ExceptionHandler add(ZUtilsException error);
	
}

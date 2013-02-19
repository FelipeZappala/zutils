package zutils.core;

public interface LogHandler {
	
	enum Level {
		INFO, DEBUG, WARN, ERROR, NONE, ALL
	}
	
	LogHandler log(Object... objects);
	
	LogHandler log(Level level, Object... objects);
	
	LogHandler log(Throwable error, Object... objects);
	
}

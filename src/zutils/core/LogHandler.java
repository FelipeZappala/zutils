package zutils.core;

import java.util.logging.Level;

public interface LogHandler {

	LogHandler log(Object... objects);
	
	LogHandler log(Level level, Object... objects);
	
	LogHandler log(Throwable error, Object... objects);
	
}

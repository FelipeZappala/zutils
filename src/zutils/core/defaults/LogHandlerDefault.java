package zutils.core.defaults;

import java.util.logging.Level;
import java.util.logging.Logger;

import zutils.core.LogHandler;

class LogHandlerDefault implements LogHandler {

	private Logger logger; 
	
	public LogHandlerDefault() {
		logger = Logger.getLogger("ZUtils");
	}
	
	private LogHandler log(Level level, Throwable error, Object... objects) {
		if (objects != null) {
			StringBuilder sb = new StringBuilder();
			
			for (Object object : objects) {
				sb.append(object);
			}
			
			if (error != null) {
				logger.log(Level.SEVERE, sb.toString(), error);
			} else {
				logger.log(level, sb.toString());
			}
		}
		return this;
	}

	public LogHandler log(Object... objects) {
		return log(Level.INFO, null, objects);
	}
	
	public LogHandler log(Level level, Object... objects) {
		return log(level, null, objects);
	}

	public LogHandler log(Throwable error, Object... objects) {
		return log(Level.SEVERE, error, objects);
	}

}

package zutils.core.defaults;

import java.util.logging.Logger;

import zutils.core.LogHandler;

class LogHandlerDefault implements LogHandler {

	private Logger logger; 
	
	public LogHandlerDefault() {
		logger = Logger.getLogger("ZUtils");
	}
	
	public LogHandler log(Object... objects) {
		if (objects != null) {
			StringBuilder sb = new StringBuilder();
			
			for (Object object : objects) {
				sb.append(object);
			}
			
			logger.info(sb.toString());
			
		}
		return this;
	}

}

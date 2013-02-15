package zutils.core;

import zutils.Function;

public interface ThreadHandler {
 //TODO pool...
	
	ThreadHandler run(Function function);
}

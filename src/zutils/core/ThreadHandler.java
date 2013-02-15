package zutils.core;

import zutils.Func;

public interface ThreadHandler {
 //TODO pool...
	
	ThreadHandler run(Func function);
}

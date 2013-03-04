package zutils.core;

public interface ThreadHandler {
	
	ThreadHandler execute(Runnable function);
	
	ThreadHandler await(Runnable function);
	
}

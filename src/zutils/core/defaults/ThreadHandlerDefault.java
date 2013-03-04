package zutils.core.defaults;

import zutils.core.ThreadHandler;
import zutils.core.exceptions.ZUtilsException;

class ThreadHandlerDefault implements ThreadHandler {

	public ThreadHandler execute(Runnable function) {
		return execute(function, false);
	}

	public ThreadHandler await(Runnable function) {
		return execute(function, true);
	}

	private ThreadHandler execute(Runnable function, boolean await) {
		try {
			if (function != null) {
				Thread thread = new Thread(function);
				thread.start();
				
				if (await) {
					thread.join();
				}
			}
		} catch (Exception e) {
			throw new ZUtilsException(e);
		}
		return this;
	}
	
}

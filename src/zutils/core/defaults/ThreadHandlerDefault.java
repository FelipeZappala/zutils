package zutils.core.defaults;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import zutils.core.ThreadHandler;
import zutils.core.exceptions.ZUtilsException;

class ThreadHandlerDefault implements ThreadHandler {

	private ExecutorService pool;
	
	public ThreadHandlerDefault() {
		this.pool = Executors.newFixedThreadPool(10);
	}
	
	public ThreadHandler execute(Runnable function) {
		//return execute(function, false);
		
		this.pool.execute(function);
		return this;
	}

	public ThreadHandler await(Runnable function) {
		//return execute(function, true);
		
		try {
			this.pool.submit(function).get();
		} catch (Exception e) {
			throw new ZUtilsException(e);
		}
		return this;
	}

//	private ThreadHandler execute(Runnable function, boolean await) {
//		try {
//			if (function != null) {
//				Thread thread = new Thread(function);
//				thread.start();
//				
//				if (await) {
//					thread.join();
//				}
//			}
//		} catch (Exception e) {
//			throw new ZUtilsException(e);
//		}
//		return this;
//	}
	
}

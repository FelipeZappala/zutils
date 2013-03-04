package zutils;

import java.util.Enumeration;
import java.util.Iterator;

import zutils.core.ConversionHandler;
import zutils.core.EventHandler;
import zutils.core.ExceptionHandler;
import zutils.core.FactoryHander;
import zutils.core.LogHandler;
import zutils.core.ThreadHandler;
import zutils.core.defaults.FactoryHanderDefault;

public abstract class ZUtils {

	// User para fazer chaves que se apagam sozinhas com o tempo
				// java.util.WeakHashMap<K, V>
	
	interface IPlugin {
		void doing();
	}
	
	class Plugin implements IPlugin {
		public void faz() {
			//
		}

		public void doing() {
			// TODO Auto-generated method stub
		}
		
	}
	
	// 
	// Attributes //////////////////////////////////////////
	//

	
	// 
	// Static methods //////////////////////////////////////
	//

	private static FactoryHander factory = new FactoryHanderDefault();
	public static FactoryHander factory() {
		return factory;
	}
	
	// http://www.javacodegeeks.com/2011/04/java-generics-quick-tutorial.html
	public static <P extends IPlugin> P plugin(String clazz) {
		clazz.isEmpty();
		return null;
	}
	
	public static <P extends IPlugin> P plugin(Class<P> clazz) {
		clazz.isAnonymousClass();
		return null;
	}

	public static ZUtils from(Object... objects) {
		ZUtils instance = new ZutilsDefault(objects);
		
		return instance;
	}
	
	public static ConversionHandler convert(Object... objects) {
		return factory().create(ConversionHandler.class).elements(objects);
	}
	
	public static LogHandler log(Object... objects) {
		return factory().create(LogHandler.class).log(objects);
	}
	
	public static LogHandler log(LogHandler.Level level, Object... objects) {
		return factory().create(LogHandler.class).log(level, objects);
	}
	
	public static LogHandler log(Throwable error, Object... objects) {
		return factory().create(LogHandler.class).log(error, objects);
	}
	
	public static ExceptionHandler errors() {
		return factory().create(ExceptionHandler.class);
	}
	
	public static EventHandler events() {
		return factory().create(EventHandler.class);
	}
	
	public static ThreadHandler run(Function function) {
		return factory().create(ThreadHandler.class).run(function);
	}
	
	// 
	// Instance methods ////////////////////////////////////
	//
	
	public abstract boolean isEmpty(); 
	
	public abstract int length();
	
	public abstract boolean has(Object object);
	
	public abstract boolean contains(Object object);

	public abstract Iterator<?> iterator();
	
	public abstract Enumeration<?> enumerator();
	
	public abstract ZUtils each(Function function);
	
	public abstract ConversionHandler convert();
	
	public abstract ZUtils log();
	
	public abstract ZUtils log(LogHandler.Level level);
		
}

package zutils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;

import zutils.core.ConversionHandler;
import zutils.core.EventHandler;
import zutils.core.EventHandler2;
import zutils.core.ExceptionHandler;
import zutils.core.FactoryHander;
import zutils.core.LogHandler;
import zutils.core.ThreadHandler;
import zutils.core.defaults.EventHandler2Default;
import zutils.core.defaults.FactoryHanderDefault;

public abstract class ZUtils {

	
	interface IPlugin {
		void doing();
	}
	
	class Plugin implements IPlugin {
		public void faz() {}

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
		return null;
	}
	
	public static <P extends IPlugin> P plugin(Class<P> clazz) {
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
	
	public static LogHandler log(Level level, Object... objects) {
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
	
	public abstract ZUtils log(Level level);

	
	private static Map<Object, EventHandler2> events = new HashMap<Object, EventHandler2>();
	
	
	private static EventHandler2 eventSender(Object target) {
		if (!events.containsKey(target)) {
			events.put(target, new EventHandler2Default().event(target));
		}
		return events.get(target);
	}
	
	public static EventHandler2 event(Object instance) {
		return eventSender(instance);
	}
	
	public static EventHandler2 event(String name) {
		return eventSender(name);
	}
	
	public static EventHandler2 event(Class<?> clazz) {
		return eventSender(clazz);
	}
	
	public static ThreadHandler run(Function function) {
		return factory().create(ThreadHandler.class).run(function);
	}
}

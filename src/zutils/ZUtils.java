package zutils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import zutils.core.CommandHandler;
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
	
	private static ZUtils currentInstance;
	
	public static ZUtils current() {
		return currentInstance;
	}
	
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

	
	private static Map<String, FactoryHander> factories;
	static {
		factories = new HashMap<String, FactoryHander>();
		setFactory("");
	}
	
	private static void setFactory(String context) {
		try {
			String factoryName;
			if (context != null && context.isEmpty())
				factoryName = System.getProperty("ZUtils.factory." + context);
			else
				factoryName = System.getProperty("ZUtils.factory");
				
			Class<?> factoryClass = Class.forName(factoryName);
			factories.put(context, (FactoryHander) factoryClass.newInstance());
			
		} catch (Exception e) {
			factories.put(context, new FactoryHanderDefault()); //TODO: Refatorar
		}
	}
	
	private static FactoryHander getFactory(String context) {
		if (!factories.containsKey(context))
			setFactory(context);
		
		return factories.get(context);
	}
	
	public static FactoryHander factory() {
		return getFactory("");
	}
	
	public static FactoryHander factory(String context) {
		return getFactory(context);
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
		currentInstance = new ZUtilsDefault(objects); //TODO: Refatorar
		return currentInstance;
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
	
	public static CommandHandler commands() {
		return factory().create(CommandHandler.class);
	}
	
	public static ThreadHandler theads() {
		return factory().create(ThreadHandler.class);
	}
	
	public static ThreadHandler run(Function function) {
		return factory().create(ThreadHandler.class).execute(function);
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
	
	public abstract <T> T first();
	
	public abstract <T> T last();
	
	public abstract ZUtils each(Function function);
	
	public abstract ZUtils filter(Function function);
	
	public abstract ConversionHandler convert();
	
	public abstract ZUtils log();
	
	public abstract ZUtils log(LogHandler.Level level);
		
}

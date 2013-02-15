package zutils.core.defaults;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import zutils.core.ConversionHandler;
import zutils.core.EventHandler;
import zutils.core.FactoryHander;
import zutils.core.LogHandler;
import zutils.core.exceptions.ZUtilsException;

public final class FactoryHanderDefault implements FactoryHander {

	private Map<Class<?>, Class<?>> registers;
	
	public FactoryHanderDefault() {
		registers = new HashMap<Class<?>, Class<?>>();
		
		// Autoregistros
		register(ConversionHandler.class, ConversionHandlerDefault.class);
		register(LogHandler.class, LogHandlerDefault.class);
		register(EventHandler.class, EventHandlerDefault.class);
	}
	
	
	public <I, C extends I> FactoryHander register(Class<I> interfaceClass, Class<C> implementationClass) {
		registers.put(interfaceClass, implementationClass);
		
		return this; //fluent interface
	}

	public <I, C extends I> FactoryHander deregister(Class<I> interfaceClass, Class<C> implementationClass) {
		if (registers.get(interfaceClass) == implementationClass)
			registers.remove(interfaceClass);
		
		return this; //fluent interface
	}

	@SuppressWarnings("unchecked")
	public <I, C extends I> C create(Class<I> interfaceClass, Object... parameters) {
		try {
			if (registers.containsKey(interfaceClass)) {
				if (parameters != null && parameters.length > 0) {
					return (C) getConstructor(interfaceClass, getTypes(parameters)).newInstance(parameters);
				}
				return (C) registers.get(interfaceClass).newInstance();
			}
			throw new ZUtilsException("Class not registred for [" + interfaceClass.getName() + "]");

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private Constructor<?> getConstructor(Class<?> interfaceClass, Class<?>[] parameterClasses) {
		Class<?> redistredClass = registers.get(interfaceClass);
		if (redistredClass == null)
			throw new ZUtilsException("Class not registred for [" + interfaceClass.getName() + "]");
			
		Constructor<?>[] constructors = redistredClass.getConstructors();
		Constructor<?> constructorFound = null;
		
		for (Constructor<?> constructor : constructors) {
			Class<?>[] parametersConstructor = constructor.getParameterTypes();
			
			boolean found = true;
			
			for (int i = 0; i < parametersConstructor.length; ++i) {
				Class<?> parameterConstructor = parametersConstructor[i]; 
				
				if (parameterConstructor.isPrimitive())
					parameterConstructor = primitiveMap.get(parameterConstructor);
				
				found &= parameterClasses.length > i && (parameterClasses[i] == parameterConstructor);
			}
			
			if (found) {
				constructorFound = constructor;
				break;
			}
		}
		
		if (constructorFound == null)
			throw new ZUtilsException("Constructor not found in class [" 
					+ redistredClass.getName() + "] to types: " + Arrays.toString(parameterClasses));
		
		return constructorFound;
	}

	private Class<?>[] getTypes(Object... objects) {
		if (objects != null) {
			Class<?>[] classes = new Class[objects.length];
			for (int i = 0; i < objects.length; i++) {
				if (classes[i] == Long.class)
					classes[i] = Long.TYPE;
				else
					classes[i] = objects[i].getClass();
			}
			return classes;
		}
		return new Class[0];
	}

	@SuppressWarnings("serial")
	private static Map<Class<?>, Class<?>> primitiveMap = new HashMap<Class<?>, Class<?>>(9) 
	{
		{
			put(boolean.class, Boolean.class);
			put(int.class, Integer.class);
			put(long.class, Long.class);
			put(short.class, Short.class);
			put(byte.class, Byte.class);
			put(char.class, Character.class);
			put(float.class, Float.class);
			put(double.class, Double.class);
			put(void.class, Void.class);
		}
	};
}

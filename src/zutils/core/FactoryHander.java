package zutils.core;

public interface FactoryHander {

	<I, C extends I> 
	FactoryHander register(Class<I> interfaceClass, Class<C> implementationClass);
	
	<I, C extends I> 
	FactoryHander deregister(Class<I> interfaceClass, Class<C> implementationClass);
	
	<I, C extends I> 
	C create(Class<I> interfaceClass, Object... parameters);
	
}

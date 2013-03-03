package zutils.core.functions;

public interface Function1<R, T> extends Function {

	R invoke(T t);
	
}

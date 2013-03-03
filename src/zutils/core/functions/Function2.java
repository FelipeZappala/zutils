package zutils.core.functions;

public interface Function2<R, T1, T2> extends Function {

	R invoke(T1 t1, T2 t2);
	
}

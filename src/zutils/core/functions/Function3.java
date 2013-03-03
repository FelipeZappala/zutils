package zutils.core.functions;

public interface Function3<R, T1, T2, T3> extends Function {

	R invoke(T1 t1, T2 t2, T3 t3);
	
}

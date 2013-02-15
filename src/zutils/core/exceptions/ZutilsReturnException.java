package zutils.core.exceptions;

public class ZutilsReturnException extends ZUtilsException {

	private static final long serialVersionUID = -1308262592131212727L;

	public ZutilsReturnException(String returnType) {
		super(returnType);
	}

	public ZutilsReturnException(Throwable cause) {
		super(cause);
	}
	
	public ZutilsReturnException(String returnType, Throwable cause) {
		super(returnType, cause);
	}
	
}

package zutils.core.exceptions;

public class ZUtilsReturnException extends ZUtilsException {

	private static final long serialVersionUID = -1308262592131212727L;

	public ZUtilsReturnException(String returnType) {
		super(returnType);
	}

	public ZUtilsReturnException(Throwable cause) {
		super(cause);
	}
	
	public ZUtilsReturnException(String returnType, Throwable cause) {
		super(returnType, cause);
	}
	
}

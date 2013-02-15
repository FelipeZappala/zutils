package zutils.core.exceptions;

public class ZutilsOperationException extends ZUtilsException {

	private static final long serialVersionUID = 7677528577214177775L;

	public ZutilsOperationException(String operation) {
		super(operation);
	}

	public ZutilsOperationException(Throwable cause) {
		super(cause);
	}
	
	public ZutilsOperationException(String operation, Throwable cause) {
		super(operation, cause);
	}
	
}

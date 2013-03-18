package zutils.core.exceptions;

public class ZUtilsOperationException extends ZUtilsException {

	private static final long serialVersionUID = 7677528577214177775L;

	public ZUtilsOperationException(String operation) {
		super(operation);
	}

	public ZUtilsOperationException(Throwable cause) {
		super(cause);
	}
	
	public ZUtilsOperationException(String operation, Throwable cause) {
		super(operation, cause);
	}
	
}

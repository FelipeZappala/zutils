package zutils.core.exceptions;

public class ZUtilsWarningException extends ZUtilsException {

	private static final long serialVersionUID = -4700710074525304046L;

	public ZUtilsWarningException(String message) {
		super(message);
	}

	public ZUtilsWarningException(Throwable cause) {
		super(cause);
	}
	
	public ZUtilsWarningException(String message, Throwable cause) {
		super(message, cause);
	}
	
}

package zutils.core.exceptions;

public class ZutilsWarningException extends ZUtilsException {

	private static final long serialVersionUID = -4700710074525304046L;

	public ZutilsWarningException(String message) {
		super(message);
	}

	public ZutilsWarningException(Throwable cause) {
		super(cause);
	}
	
	public ZutilsWarningException(String message, Throwable cause) {
		super(message, cause);
	}
	
}

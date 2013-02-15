package zutils.core.exceptions;

public class ZUtilsException extends RuntimeException {

	private static final long serialVersionUID = 4862325418835961197L;
	
	protected ZUtilsException() {
		super();
	}
	
	public ZUtilsException(String message) {
		super(message);
	}
	
	public ZUtilsException(Throwable cause) {
		super(cause);
	}
	
	public ZUtilsException(String message, Throwable cause) {
		super(message, cause);
	}

}

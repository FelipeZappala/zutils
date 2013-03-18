package zutils.core.exceptions;

public class ZUtilsArgumentException extends ZUtilsException {

	private static final long serialVersionUID = 1631744369381068850L;

	public ZUtilsArgumentException(String argName) {
		super(argName);
	}

	public ZUtilsArgumentException(Throwable cause) {
		super(cause);
	}
	
	public ZUtilsArgumentException(String argName, Throwable cause) {
		super(argName, cause);
	}
	
}

package zutils.core.exceptions;

public class ZutilsArgumentException extends ZUtilsException {

	private static final long serialVersionUID = 1631744369381068850L;

	public ZutilsArgumentException(String argName) {
		super(argName);
	}

	public ZutilsArgumentException(Throwable cause) {
		super(cause);
	}
	
	public ZutilsArgumentException(String argName, Throwable cause) {
		super(argName, cause);
	}
	
}

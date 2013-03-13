package zutils.core;

import zutils.Function;

public interface CommandHandler {

	CommandHandler add(String name, Function function);
	
	CommandHandler remove(String name);
	
	CommandHandler execute(String name, Object... params);
	
}

package zutils.core.defaults;

import java.util.HashMap;
import java.util.Map;

import zutils.Function;
import zutils.core.CommandHandler;

class CommandHandlerDefault implements CommandHandler {

	private Map<String, Function> commands;
	
	public CommandHandlerDefault() {
		this.commands = new HashMap<String, Function>();
	}
	
	public CommandHandler add(String name, Function function) {
		commands.put(name, function);
		return this;
	}

	public CommandHandler execute(String name, Object... params) {
		if (commands.containsKey(name)) {
			Function func = commands.get(name);
			func.params.set(name);
			
			if (params != null) {
				for (int i = 0; i < params.length; ++i) {
					func.params.set(i, params[i]);
				}
			}
			
			func.run();
		}
		return this;
	}

	public CommandHandler remove(String name) {
		if (commands.containsKey(name))
			commands.remove(name);
		
		return this;
	}

}

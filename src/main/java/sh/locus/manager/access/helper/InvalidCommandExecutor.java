package sh.locus.manager.access.helper;

import sh.locus.manager.access.dto.ExecutionResult;

public class InvalidCommandExecutor extends AbstractCommandExecutor {

	public InvalidCommandExecutor() {
		
	}

	@Override
	public ExecutionResult execute(String[] commandTokens) {
		printAvailableCommandsHelp();
		return new ExecutionResult(true, "", false);
	}
}

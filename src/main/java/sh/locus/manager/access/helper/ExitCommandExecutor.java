package sh.locus.manager.access.helper;

import org.apache.commons.cli.ParseException;

import sh.locus.manager.access.dto.ExecutionResult;

public class ExitCommandExecutor extends AbstractCommandExecutor {

	public ExitCommandExecutor() {
		
	}

	@Override
	public ExecutionResult execute(String[] commandTokens) throws ParseException {
		return new ExecutionResult(true, "Exit requested", true);
	}
}

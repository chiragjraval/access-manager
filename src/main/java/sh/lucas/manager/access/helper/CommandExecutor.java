package sh.lucas.manager.access.helper;

import org.apache.commons.cli.ParseException;

import sh.lucas.manager.access.dto.ExecutionResult;

public interface CommandExecutor {

	ExecutionResult execute(String[] commandTokens) throws ParseException;
	
}

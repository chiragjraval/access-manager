package sh.locus.manager.access.helper;

import org.apache.commons.cli.ParseException;

import sh.locus.manager.access.dto.ExecutionResult;

public interface CommandExecutor {

	ExecutionResult execute(String[] commandTokens) throws ParseException;
	
}

package sh.locus.manager.access.helper;

import java.text.MessageFormat;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;

import sh.locus.manager.access.dto.ExecutionResult;
import sh.locus.manager.access.manager.AccessManager;

public class VerifyCommandExecutor extends AbstractCommandExecutor {

	public VerifyCommandExecutor(AccessManager accessManager) {
		this.accessManager = accessManager;
	}

	@Override
	public ExecutionResult execute(String[] commandTokens) throws ParseException {
		CommandLine verifyCommandLine = parser.parse(getVerifyCommandOptions(), commandTokens);
		String userId = verifyCommandLine.getOptionValue(USER_ARG_NAME);
		String actionType = verifyCommandLine.getOptionValue(ACION_TYPE_ARG_NAME);
		String resourceId = verifyCommandLine.getOptionValue(RESOURCE_ARG_NAME);
		boolean status = accessManager.verify(userId, actionType, resourceId);
		if (status) {
			String msg = MessageFormat.format("User {0} can take {1} action on resource {2}", userId, actionType, resourceId);
			return new ExecutionResult(status, msg, false);
		}
		else {
			String msg = MessageFormat.format("User {0} cannot take {1} action on resource {2}", userId, actionType, resourceId);
			return new ExecutionResult(status, msg, false);
		}
	}
}

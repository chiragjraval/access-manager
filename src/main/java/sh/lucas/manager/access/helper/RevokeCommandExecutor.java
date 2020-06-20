package sh.lucas.manager.access.helper;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;

import sh.lucas.manager.access.dto.ExecutionResult;
import sh.lucas.manager.access.manager.AccessManager;

public class RevokeCommandExecutor extends AbstractCommandExecutor {

	public RevokeCommandExecutor(AccessManager accessManager) {
		this.accessManager = accessManager;
	}

	@Override
	public ExecutionResult execute(String[] commandTokens) throws ParseException {
		CommandLine revokeCommandLine = parser.parse(getGrantRevokeCommandOptions(), commandTokens);
		String userId = revokeCommandLine.getOptionValue(USER_ARG_NAME);
		List<String> roleIds = Arrays.asList(revokeCommandLine.getOptionValues(ROLE_ARG_NAME));
		boolean status = accessManager.revoke(userId, roleIds);
		if (status) {
			String msg = MessageFormat.format("Roles {0} revoked for {1}", roleIds, userId);
			return new ExecutionResult(status, msg, false);
		}
		else {
			String msg = MessageFormat.format("Roles {0} could not be revoked for {1}", roleIds, userId);
			return new ExecutionResult(status, msg, false);
		}
	}
}

package sh.locus.manager.access.helper;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;

import sh.locus.manager.access.dto.ExecutionResult;
import sh.locus.manager.access.manager.AccessManager;

public class GrantCommandExecutor extends AbstractCommandExecutor {

	public GrantCommandExecutor(AccessManager accessManager) {
		this.accessManager = accessManager;
	}

	@Override
	public ExecutionResult execute(String[] commandTokens) throws ParseException {
		CommandLine grantCommandLine = parser.parse(getGrantRevokeCommandOptions(), commandTokens);
		String userId = grantCommandLine.getOptionValue(USER_ARG_NAME);
		List<String> roleIds = Arrays.asList(grantCommandLine.getOptionValues(ROLE_ARG_NAME));
		boolean status = accessManager.grant(userId, roleIds);
		if (status) {
			String msg = MessageFormat.format("Roles {0} granted to {1}", roleIds, userId);
			return new ExecutionResult(status, msg, false);
		}
		else {
			String msg = MessageFormat.format("Roles {0} could not be granted to {1}", roleIds, userId);
			return new ExecutionResult(status, msg, false);
		}
	}
}

package sh.lucas.manager.access.helper;

import java.util.Objects;

import sh.lucas.manager.access.dto.ExecutionResult;
import sh.lucas.manager.access.manager.AccessManager;
import sh.lucas.manager.access.manager.DefaultAccessManager;

public class CommandHelper {

	private static final String GRANT_COMMAND = "grant";
	private static final String REVOKE_COMMAND = "revoke";
	private static final String VERIFY_COMMAND = "verify";
	private static final String EXIT_COMMAND = "exit";

	private AccessManager accessManager = new DefaultAccessManager();
	private GrantCommandExecutor grantCommandExecutor = new GrantCommandExecutor(accessManager);
	private RevokeCommandExecutor revokeCommandExecutor = new RevokeCommandExecutor(accessManager);
	private VerifyCommandExecutor verifyCommandExecutor = new VerifyCommandExecutor(accessManager);
	private ExitCommandExecutor exitCommandExecutor = new ExitCommandExecutor();
	private InvalidCommandExecutor invalidCommandExecutor = new InvalidCommandExecutor();

	public ExecutionResult execute(String[] commandTokens) {
		try {
			String commandName = "";
			if (Objects.nonNull(commandTokens) && commandTokens.length > 0) {
				commandName = commandTokens[0];
			}
			CommandExecutor commandExecutor = getCommandExecutor(commandName);
			return commandExecutor.execute(commandTokens);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return invalidCommandExecutor.execute(commandTokens);
	}

	private CommandExecutor getCommandExecutor(String commandName) {
		CommandExecutor commandExecutor = null;
		switch (commandName) {
		case GRANT_COMMAND:
			commandExecutor = grantCommandExecutor;
			break;
		case REVOKE_COMMAND:
			commandExecutor = revokeCommandExecutor;
			break;
		case VERIFY_COMMAND:
			commandExecutor = verifyCommandExecutor;
			break;
		case EXIT_COMMAND:
			commandExecutor = exitCommandExecutor;
			break;
		default:
			commandExecutor = invalidCommandExecutor;
			break;
		}
		return commandExecutor;
	}
}

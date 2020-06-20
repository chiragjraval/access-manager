package sh.locus.manager.access.helper;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import sh.locus.manager.access.manager.AccessManager;

public abstract class AbstractCommandExecutor implements CommandExecutor {

	public static final String GRANT_COMMAND = "grant";
	public static final String REVOKE_COMMAND = "revoke";
	public static final String VERIFY_COMMAND = "verify";
	public static final String EXIT_COMMAND = "exit";

	public static final String USER_ARG_NAME = "user";
	public static final String USER_ARG_DESC = "<User ID>";
	public static final String ROLE_ARG_NAME = "role";
	public static final String ROLE_ARG_DESC = "<Role ID>";
	public static final String ACION_TYPE_ARG_NAME = "actiontype";
	public static final String ACION_TYPE_ARG_DESC = "<Action Type>";
	public static final String RESOURCE_ARG_NAME = "resource";
	public static final String RESOURCE_ARG_DESC = "<Resource ID>";
	
	protected AccessManager accessManager;
	protected CommandLineParser parser = new BasicParser();
	
	protected Options getGrantRevokeCommandOptions() {
		Options options = new Options();
		options.addOption(getUserOption());
		options.addOption(getRoleOption());
		return options;
	}

	protected Options getVerifyCommandOptions() {
		Options options = new Options();
		options.addOption(getUserOption());
		options.addOption(getActionTypeOption());
		options.addOption(getResourceOption());
		return options;
	}

	protected void printAvailableCommandsHelp() {
		printGrantCommandHelp();
		printRevokeCommandHelp();
		printVerifyCommandHelp();
	}

	protected void printGrantCommandHelp() {
		HelpFormatter helpFormatter = new HelpFormatter();
		helpFormatter.printHelp(GRANT_COMMAND, getGrantRevokeCommandOptions());
	}

	protected void printRevokeCommandHelp() {
		HelpFormatter helpFormatter = new HelpFormatter();
		helpFormatter.printHelp(REVOKE_COMMAND, getGrantRevokeCommandOptions());
	}

	protected void printVerifyCommandHelp() {
		HelpFormatter helpFormatter = new HelpFormatter();
		helpFormatter.printHelp(VERIFY_COMMAND, getVerifyCommandOptions());
	}

	protected Option getUserOption() {
		Option option = new Option(USER_ARG_NAME, USER_ARG_NAME, true, USER_ARG_DESC);
		option.setRequired(true);
		return option;
	}

	protected Option getRoleOption() {
		Option option = new Option(ROLE_ARG_NAME, ROLE_ARG_NAME, true, ROLE_ARG_DESC);
		option.setArgs(Option.UNLIMITED_VALUES);
		option.setRequired(true);
		return option;
	}

	protected Option getActionTypeOption() {
		Option option = new Option(ACION_TYPE_ARG_NAME, ACION_TYPE_ARG_NAME, true, ACION_TYPE_ARG_DESC);
		option.setRequired(true);
		return option;
	}

	protected Option getResourceOption() {
		Option option = new Option(RESOURCE_ARG_NAME, RESOURCE_ARG_NAME, true, RESOURCE_ARG_DESC);
		option.setRequired(true);
		return option;
	}
}

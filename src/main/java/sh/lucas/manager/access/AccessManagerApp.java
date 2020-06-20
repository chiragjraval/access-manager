package sh.lucas.manager.access;

import java.util.Scanner;

import org.apache.commons.lang3.*;

import sh.lucas.manager.access.dto.ExecutionResult;
import sh.lucas.manager.access.helper.CommandHelper;

public class AccessManagerApp {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CommandHelper commandHelper = new CommandHelper();
		boolean exitRequested = false;

		while (!exitRequested) {
			System.out.println("");
			System.out.print("$");
			String userCommand = scanner.nextLine();

			if (StringUtils.isNotBlank(userCommand)) {
				String[] userCommandTokens = StringUtils.split(userCommand, " ");
				ExecutionResult executionResult = commandHelper.execute(userCommandTokens);
				System.out.println(executionResult.getMsg());
				exitRequested = executionResult.isTerminate();
			}
		}
		
		scanner.close();
	}
}

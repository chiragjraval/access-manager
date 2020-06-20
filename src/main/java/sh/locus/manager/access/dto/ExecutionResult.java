package sh.locus.manager.access.dto;

public class ExecutionResult {

	boolean status;
	String msg;
	boolean terminate;

	public ExecutionResult(boolean status, String msg, boolean terminate) {
		super();
		this.status = status;
		this.msg = msg;
		this.terminate = terminate;
	}

	public boolean isStatus() {
		return status;
	}

	public String getMsg() {
		return msg;
	}

	public boolean isTerminate() {
		return terminate;
	}
}

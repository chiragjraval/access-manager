package sh.locus.manager.access.entity;

import java.util.List;
import java.util.Map;

public class Role {

	private String roleId;
	private String roleDesc;
	private Map<Environment, List<ActionType>> allowedEnvActions;
	
	public Role(String roleId, String roleDesc, Map<Environment, List<ActionType>> allowedEnvActions) {
		super();
		this.roleId = roleId;
		this.roleDesc = roleDesc;
		this.allowedEnvActions = allowedEnvActions;
	}

	public String getRoleId() {
		return roleId;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public Map<Environment, List<ActionType>> getAllowedEnvActions() {
		return allowedEnvActions;
	}
}

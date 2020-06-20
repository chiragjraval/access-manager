package sh.locus.manager.access.entity;

import java.util.List;

public class User {

	private String userId;
	private List<Role> assignedRoles;
	
	public User(String userId, List<Role> assignedRoles) {
		super();
		this.userId = userId;
		this.assignedRoles = assignedRoles;
	}

	public String getUserId() {
		return userId;
	}
	
	public List<Role> getAssignedRoles() {
		return assignedRoles;
	}
}

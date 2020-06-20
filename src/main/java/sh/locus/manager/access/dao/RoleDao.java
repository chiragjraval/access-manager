package sh.locus.manager.access.dao;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import sh.locus.manager.access.constants.DaoConstants;
import sh.locus.manager.access.entity.ActionType;
import sh.locus.manager.access.entity.Environment;
import sh.locus.manager.access.entity.Role;

public class RoleDao implements BaseDao<String, Role> {

	private Map<String, Role> roles = new HashMap<>();

	public RoleDao() {
		Map<Environment, List<ActionType>> roleMemberEnvActionsMap = new EnumMap<>(Environment.class);
		roleMemberEnvActionsMap.put(Environment.DEV, DaoConstants.ROLE_MEMBER_ENV_DEV_ALLOWED_ACTIONS);
		roleMemberEnvActionsMap.put(Environment.QA, DaoConstants.ROLE_MEMBER_ENV_QA_ALLOWED_ACTIONS);
		roleMemberEnvActionsMap.put(Environment.PROD, DaoConstants.ROLE_MEMBER_ENV_PROD_ALLOWED_ACTIONS);
		roles.put(DaoConstants.ROLE_MEMBER,
				new Role(DaoConstants.ROLE_MEMBER, DaoConstants.ROLE_MEMBER_DESC, roleMemberEnvActionsMap));
		
		Map<Environment, List<ActionType>> roleManagerEnvActionsMap = new EnumMap<>(Environment.class);
		roleManagerEnvActionsMap.put(Environment.DEV, DaoConstants.ROLE_MGR_ENV_DEV_ALLOWED_ACTIONS);
		roleManagerEnvActionsMap.put(Environment.QA, DaoConstants.ROLE_MGR_ENV_QA_ALLOWED_ACTIONS);
		roleManagerEnvActionsMap.put(Environment.PROD, DaoConstants.ROLE_MGR_ENV_PROD_ALLOWED_ACTIONS);
		roles.put(DaoConstants.ROLE_MGR,
				new Role(DaoConstants.ROLE_MGR, DaoConstants.ROLE_MGR_DESC, roleManagerEnvActionsMap));
		
		Map<Environment, List<ActionType>> roleAdminEnvActionsMap = new EnumMap<>(Environment.class);
		roleAdminEnvActionsMap.put(Environment.DEV, DaoConstants.ROLE_ADMIN_ENV_DEV_ALLOWED_ACTIONS);
		roleAdminEnvActionsMap.put(Environment.QA, DaoConstants.ROLE_ADMIN_ENV_QA_ALLOWED_ACTIONS);
		roleAdminEnvActionsMap.put(Environment.PROD, DaoConstants.ROLE_ADMIN_ENV_PROD_ALLOWED_ACTIONS);
		roles.put(DaoConstants.ROLE_ADMIN,
				new Role(DaoConstants.ROLE_ADMIN, DaoConstants.ROLE_ADMIN_DESC, roleAdminEnvActionsMap));
	}

	public Role create(Role role) {
		if (!roles.containsKey(role.getRoleId())) {
			roles.put(role.getRoleId(), role);
			return role;
		}
		return null;
	}

	public Role read(String id) {
		return roles.get(id);
	}

	public List<Role> read(List<String> ids) {
		return ids.stream().map(id -> roles.get(id)).collect(Collectors.toList());
	}

	public Role update(Role role) {
		if (roles.containsKey(role.getRoleId())) {
			roles.put(role.getRoleId(), role);
			return role;
		}
		return null;
	}

	public Role delete(Role role) {
		if (roles.containsKey(role.getRoleId())) {
			return roles.remove(role.getRoleId());
		}
		return null;
	}
}

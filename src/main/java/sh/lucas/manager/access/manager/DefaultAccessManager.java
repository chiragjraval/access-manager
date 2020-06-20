package sh.lucas.manager.access.manager;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.apache.commons.lang3.EnumUtils;

import sh.lucas.manager.access.dao.ResourceDao;
import sh.lucas.manager.access.dao.RoleDao;
import sh.lucas.manager.access.dao.UserDao;
import sh.lucas.manager.access.entity.ActionType;
import sh.lucas.manager.access.entity.Environment;
import sh.lucas.manager.access.entity.Resource;
import sh.lucas.manager.access.entity.Role;
import sh.lucas.manager.access.entity.User;

public class DefaultAccessManager implements AccessManager {

	private UserDao userDao = new UserDao();
	private RoleDao roleDao = new RoleDao();
	private ResourceDao resourceDao = new ResourceDao(roleDao);

	public boolean grant(String userId, List<String> roleIds) {
		User user = userDao.read(userId);
		List<Role> roles = roleDao.read(roleIds);
		user.getAssignedRoles().addAll(roles);
		userDao.update(user);
		return true;
	}

	public boolean revoke(String userId, List<String> roleIds) {
		User user = userDao.read(userId);
		List<Role> roles = roleDao.read(roleIds);
		user.getAssignedRoles().removeAll(roles);
		userDao.update(user);
		return true;
	}

	public boolean verify(String userId, String actionTypeStr, String resourceId) {
		User user = userDao.read(userId);
		Resource resource = resourceDao.read(resourceId);
		if (Objects.nonNull(user) && Objects.nonNull(resource)
				&& EnumUtils.isValidEnum(ActionType.class, actionTypeStr)) {
			ActionType actionType = ActionType.valueOf(actionTypeStr);
			Environment resourceEnv = resource.getResourceEnv();
			List<Role> userRoles = user.getAssignedRoles();

			Set<ActionType> userAllowedActionsInResourceEnv = new HashSet<>();
			for (Role userRole : userRoles) {
				userAllowedActionsInResourceEnv.addAll(userRole.getAllowedEnvActions().get(resourceEnv));
			}

			if (userAllowedActionsInResourceEnv.contains(actionType)) {
				return true;
			}
		}
		return false;
	}
}

package sh.lucas.manager.access.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import sh.lucas.manager.access.constants.DaoConstants;
import sh.lucas.manager.access.entity.User;

public class UserDao implements BaseDao<String, User> {

	private Map<String, User> users = new HashMap<>();
	
	public UserDao() {
		users.put(DaoConstants.USER_CHIRAG, new User(DaoConstants.USER_CHIRAG, new ArrayList<>()));
		users.put(DaoConstants.USER_LUCAS, new User(DaoConstants.USER_LUCAS, new ArrayList<>()));
	}

	public User create(User user) {
		if (!users.containsKey(user.getUserId())) {
			users.put(user.getUserId(), user);
			return user;
		}
		return null;
	}

	public User read(String id) {
		return users.get(id);
	}
	
	public List<User> read(List<String> ids) {
		return ids.stream().map(id -> users.get(id)).collect(Collectors.toList());
	}

	public User update(User user) {
		if (users.containsKey(user.getUserId())) {
			users.put(user.getUserId(), user);
			return user;
		}
		return null;
	}

	public User delete(User user) {
		if (users.containsKey(user.getUserId())) {
			return users.remove(user.getUserId());
		}
		return null;
	}

}

package sh.lucas.manager.access.manager;

import java.util.List;

public interface AccessManager {

	boolean grant(String userId, List<String> roleIds);
	
	boolean revoke(String userId, List<String> roleIds);
	
	boolean verify(String userId, String actionType, String resourceId);
	
}

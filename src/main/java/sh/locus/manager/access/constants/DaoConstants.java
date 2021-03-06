package sh.locus.manager.access.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sh.locus.manager.access.entity.ActionType;
import sh.locus.manager.access.entity.Environment;

public interface DaoConstants {

	// User Constants
	String USER_CHIRAG = "chirag";
	String USER_LOCUS = "locus";

	// Role Constants
	String ROLE_MEMBER = "member";
	String ROLE_MEMBER_DESC = "Team Member";
	List<ActionType> ROLE_MEMBER_ENV_DEV_ALLOWED_ACTIONS = Arrays.asList(ActionType.READ, ActionType.ADD, ActionType.WRITE, ActionType.DELETE);
	List<ActionType> ROLE_MEMBER_ENV_QA_ALLOWED_ACTIONS = Arrays.asList(ActionType.READ);
	List<ActionType> ROLE_MEMBER_ENV_PROD_ALLOWED_ACTIONS = new ArrayList<>();
	
	
	String ROLE_MGR = "mgr";
	String ROLE_MGR_DESC = "Manager";
	List<ActionType> ROLE_MGR_ENV_DEV_ALLOWED_ACTIONS = Arrays.asList(ActionType.READ, ActionType.ADD, ActionType.WRITE, ActionType.DELETE);
	List<ActionType> ROLE_MGR_ENV_QA_ALLOWED_ACTIONS = Arrays.asList(ActionType.READ, ActionType.ADD, ActionType.WRITE);
	List<ActionType> ROLE_MGR_ENV_PROD_ALLOWED_ACTIONS = Arrays.asList(ActionType.READ);
	
	String ROLE_ADMIN = "admin";
	String ROLE_ADMIN_DESC = "Administrator";
	List<ActionType> ROLE_ADMIN_ENV_DEV_ALLOWED_ACTIONS = Arrays.asList(ActionType.READ, ActionType.ADD, ActionType.WRITE, ActionType.DELETE);
	List<ActionType> ROLE_ADMIN_ENV_QA_ALLOWED_ACTIONS = Arrays.asList(ActionType.READ, ActionType.ADD, ActionType.WRITE, ActionType.DELETE);
	List<ActionType> ROLE_ADMIN_ENV_PROD_ALLOWED_ACTIONS = Arrays.asList(ActionType.READ, ActionType.ADD, ActionType.WRITE, ActionType.DELETE);
	
	// Resource Constants
	String RESOURCE_DEV_DB_ID = "locusDevDb";
	String RESOURCE_DEV_DB_DESC = "Locus DEV DB";
	Environment RESOURCE_DEV_DB_ENV = Environment.DEV;
	
	String RESOURCE_QA_DB_ID = "locusQaDb";
	String RESOURCE_QA_DB_DESC = "Locus QA DB";
	Environment RESOURCE_QA_DB_ENV = Environment.QA;
	
	String RESOURCE_PROD_DB_ID = "locusProdDb";
	String RESOURCE_PROD_DB_DESC = "Locus PROD DB";
	Environment RESOURCE_PROD_DB_ENV = Environment.PROD;
}

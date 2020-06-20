package sh.locus.manager.access.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import sh.locus.manager.access.constants.DaoConstants;
import sh.locus.manager.access.entity.Resource;

public class ResourceDao implements BaseDao<String, Resource> {

	private Map<String, Resource> resources = new HashMap<>();

	public ResourceDao(RoleDao roleDao) {
		resources.put(DaoConstants.RESOURCE_DEV_DB_ID, new Resource(DaoConstants.RESOURCE_DEV_DB_ID,
				DaoConstants.RESOURCE_DEV_DB_DESC, DaoConstants.RESOURCE_DEV_DB_ENV));

		resources.put(DaoConstants.RESOURCE_QA_DB_ID, new Resource(DaoConstants.RESOURCE_QA_DB_ID,
				DaoConstants.RESOURCE_QA_DB_DESC, DaoConstants.RESOURCE_QA_DB_ENV));
		
		resources.put(DaoConstants.RESOURCE_PROD_DB_ID, new Resource(DaoConstants.RESOURCE_PROD_DB_ID,
				DaoConstants.RESOURCE_PROD_DB_DESC, DaoConstants.RESOURCE_PROD_DB_ENV));
	}

	public Resource create(Resource resource) {
		if (!resources.containsKey(resource.getResourceId())) {
			resources.put(resource.getResourceId(), resource);
			return resource;
		}
		return null;
	}

	public Resource read(String id) {
		return resources.get(id);
	}

	public List<Resource> read(List<String> ids) {
		return ids.stream().map(id -> resources.get(id)).collect(Collectors.toList());
	}

	public Resource update(Resource resource) {
		if (resources.containsKey(resource.getResourceId())) {
			resources.put(resource.getResourceId(), resource);
			return resource;
		}
		return null;
	}

	public Resource delete(Resource resource) {
		if (resources.containsKey(resource.getResourceId())) {
			return resources.remove(resource.getResourceId());
		}
		return null;
	}

}

package sh.lucas.manager.access.entity;

public class Resource {

	private String resourceId;
	private String resourceDesc;
	private Environment resourceEnv;

	public Resource(String resourceId, String resourceDesc, Environment resourceEnv) {
		super();
		this.resourceId = resourceId;
		this.resourceDesc = resourceDesc;
		this.resourceEnv = resourceEnv;
	}

	public String getResourceId() {
		return resourceId;
	}

	public String getResourceDesc() {
		return resourceDesc;
	}

	public Environment getResourceEnv() {
		return resourceEnv;
	}
}

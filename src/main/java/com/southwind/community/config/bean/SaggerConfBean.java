package com.southwind.community.config.bean;

/**
 * swagger configuration
 */
public final class SaggerConfBean {

	private String title;
	private String description;
	private String version;
	private String basePackage;
	private Boolean enable;
	private Boolean useDefaultResponseMessages;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getBasePackage() {
		return basePackage;
	}

	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public Boolean getUseDefaultResponseMessages() {
		return useDefaultResponseMessages;
	}

	public void setUseDefaultResponseMessages(Boolean useDefaultResponseMessages) {
		this.useDefaultResponseMessages = useDefaultResponseMessages;
	}
}

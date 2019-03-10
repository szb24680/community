package com.southwind.community.config.bean;

/**
 * Created by fzxs on 17-3-14.
 */


public final class MyBatisConfBean {

    private String typeAliasesPackage;

    private String mapperLocations;

    private String configLocation;
    
    public String getTypeAliasesPackage() {
        return typeAliasesPackage;
    }

    public void setTypeAliasesPackage(String typeAliasesPackage) {
        this.typeAliasesPackage = typeAliasesPackage;
    }

    public String getMapperLocations() {
        return mapperLocations;
    }

    public void setMapperLocations(String mapperLocations) {
        this.mapperLocations = mapperLocations;
    }

	public String getConfigLocation() {
		return configLocation;
	}

	public void setConfigLocation(String configLocation) {
		this.configLocation = configLocation;
	}
    
    
}

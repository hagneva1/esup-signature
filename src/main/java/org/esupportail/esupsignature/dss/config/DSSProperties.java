package org.esupportail.esupsignature.dss.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="dss")
public class DSSProperties {

    private String cacheUsername;
    private String cachePassword;
    private String cacheDataSourceUrl;
    private String cacheDataSourceDriverClassName;
    private String defaultValidationPolicy;
    private String tspServer;
    private String serverSigningKeystoreType;
    private String serverSigningKeystoreFilename;
    private String serverSigningKeystorePassword;
    private String lotlUrl;
    private String lotlCountryCode;
    private String ojUrl;

    public String getCacheUsername() {
        return cacheUsername;
    }

    public void setCacheUsername(String cacheUsername) {
        this.cacheUsername = cacheUsername;
    }

    public String getCachePassword() {
        return cachePassword;
    }

    public void setCachePassword(String cachePassword) {
        this.cachePassword = cachePassword;
    }

    public String getCacheDataSourceUrl() {
        return cacheDataSourceUrl;
    }

    public void setCacheDataSourceUrl(String cacheDataSourceUrl) {
        this.cacheDataSourceUrl = cacheDataSourceUrl;
    }

    public String getCacheDataSourceDriverClassName() {
        return cacheDataSourceDriverClassName;
    }

    public void setCacheDataSourceDriverClassName(String cacheDataSourceDriverClassName) {
        this.cacheDataSourceDriverClassName = cacheDataSourceDriverClassName;
    }

    public String getDefaultValidationPolicy() {
        return defaultValidationPolicy;
    }

    public void setDefaultValidationPolicy(String defaultValidationPolicy) {
        this.defaultValidationPolicy = defaultValidationPolicy;
    }

    public String getTspServer() {
        return tspServer;
    }

    public void setTspServer(String tspServer) {
        this.tspServer = tspServer;
    }

    public String getServerSigningKeystoreType() {
        return serverSigningKeystoreType;
    }

    public void setServerSigningKeystoreType(String serverSigningKeystoreType) {
        this.serverSigningKeystoreType = serverSigningKeystoreType;
    }

    public String getServerSigningKeystoreFilename() {
        return serverSigningKeystoreFilename;
    }

    public void setServerSigningKeystoreFilename(String serverSigningKeystoreFilename) {
        this.serverSigningKeystoreFilename = serverSigningKeystoreFilename;
    }

    public String getServerSigningKeystorePassword() {
        return serverSigningKeystorePassword;
    }

    public void setServerSigningKeystorePassword(String serverSigningKeystorePassword) {
        this.serverSigningKeystorePassword = serverSigningKeystorePassword;
    }

    public String getLotlUrl() {
        return lotlUrl;
    }

    public void setLotlUrl(String lotlUrl) {
        this.lotlUrl = lotlUrl;
    }

    public String getLotlCountryCode() {
        return lotlCountryCode;
    }

    public void setLotlCountryCode(String lotlCountryCode) {
        this.lotlCountryCode = lotlCountryCode;
    }

    public String getOjUrl() {
        return ojUrl;
    }

    public void setOjUrl(String ojUrl) {
        this.ojUrl = ojUrl;
    }

}

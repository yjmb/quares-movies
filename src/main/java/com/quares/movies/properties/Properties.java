package com.quares.movies.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Properties {
    @Value("${apiKey}")
    private String apiKey;
    @Value("${uriOMBDApi}")
    private String uriOMBDApi;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getUriOMBDApi() {
        return uriOMBDApi;
    }

    public void setUriOMBDApi(String uriOMBDApi) {
        this.uriOMBDApi = uriOMBDApi;
    }
}

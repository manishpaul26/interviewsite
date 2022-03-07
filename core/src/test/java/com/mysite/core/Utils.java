package com.mysite.core;

import com.mysite.core.configs.SalesforceServiceConfig;

import java.util.HashMap;
import java.util.Map;

import static com.mysite.core.beans.ContactForm.Constants.*;
import static org.mockito.Mockito.when;

public class Utils {

    public static Map<String, Object> generateParameters() {
        Map<String, Object> params = new HashMap<>();

        params.put(PARAM_FIRST_NAME, "John");
        params.put(PARAM_LAST_NAME, "Smith");
        params.put(PARAM_QUERY, "Hello, can I please request a callback? Thanks");

        return params;

    }

    public static void mockConfig(SalesforceServiceConfig config) {
        // mock config- adding dummy username and password
        when(config.endpoint_url()).thenReturn(SalesforceServiceConfig.SALESFORCE_ENDPOINT_URL);
        when(config.username()).thenReturn("salesforce_username");
        when(config.password()).thenReturn("salesforce_password");


    }
}

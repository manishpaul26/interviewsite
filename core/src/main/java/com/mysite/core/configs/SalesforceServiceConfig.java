package com.mysite.core.configs;


import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Salesforce Config Class", description = "Configuration for Salesforce URL")
public @interface SalesforceServiceConfig {

    String SALESFORCE_ENDPOINT_URL = "http://localhost:3000/salesforce/contactus";

    @AttributeDefinition(name = "Endpoint URL")
    String endpoint_url() default SALESFORCE_ENDPOINT_URL;

    @AttributeDefinition(name = "Encrypted Username", description = "Use crypto support to encrypt the username")
    String username() default "";

    @AttributeDefinition(name = "Encrypted Username", description = "Use crypto support to encrypt the password")
    String password() default "";
}

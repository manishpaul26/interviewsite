package com.mysite.core.beans;

import com.mysite.core.configs.SalesforceServiceConfig;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

import static com.mysite.core.beans.ContactForm.Constants.*;

public class RequestDetails {

    private final String username;
    private final String password;
    private final String endpointUrl;

    private final List<NameValuePair> params = new ArrayList<NameValuePair>();

    public RequestDetails(SalesforceServiceConfig configuration, ContactForm contactForm) {

        this.username = configuration.username();
        this.password = configuration.password();
        this.endpointUrl = configuration.endpoint_url();

        this.params.add(new BasicNameValuePair(PARAM_FIRST_NAME, contactForm.getFirstName()));
        this.params.add(new BasicNameValuePair(PARAM_LAST_NAME, contactForm.getLastName()));
        this.params.add(new BasicNameValuePair(PARAM_QUERY, contactForm.getQuery()));
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEndpointUrl() {
        return endpointUrl;
    }

    public List<NameValuePair> getParams() {
        return params;
    }
}

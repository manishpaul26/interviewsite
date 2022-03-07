package com.mysite.core.services;


import com.mysite.core.Utils;
import com.mysite.core.beans.ContactForm;
import com.mysite.core.beans.HttpClientResponse;
import com.mysite.core.beans.RequestDetails;
import com.mysite.core.configs.SalesforceServiceConfig;
import io.wcm.testing.mock.aem.junit5.AemContext;
import org.apache.sling.api.SlingHttpServletResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static junitx.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class HttpClientServiceImplTest {

    @InjectMocks
    private HttpClientServiceImpl httpClientService = new HttpClientServiceImpl();


    private final AemContext context = new AemContext();


    /**
     * Based on dummmy response from the service right now.
     */
    @Test
    public void testHttpClient() {

        context.request().setParameterMap(Utils.generateParameters());

        SalesforceServiceConfig config = mock(SalesforceServiceConfig.class);
        Utils.mockConfig(config);


        ContactForm contactForm = new ContactForm(context.request());
        RequestDetails requestDetails = new RequestDetails(config, contactForm);

        HttpClientResponse response = httpClientService.httpPost(requestDetails);
        assertEquals(SlingHttpServletResponse.SC_OK, response.getCode());
    }

    /**
     * Based on dummmy response from the service right now.
     */
    @Test
    public void testHttpClient_whenErrorThrowInternalServerError() {

        context.request().setParameterMap(Utils.generateParameters());

        SalesforceServiceConfig config = mock(SalesforceServiceConfig.class);
        Utils.mockConfig(config);


        ContactForm contactForm = new ContactForm(context.request());
        RequestDetails requestDetails = new RequestDetails(config, contactForm);

        HttpClientResponse response = httpClientService.httpPost(requestDetails);
        assertEquals(SlingHttpServletResponse.SC_OK, response.getCode());
    }


}

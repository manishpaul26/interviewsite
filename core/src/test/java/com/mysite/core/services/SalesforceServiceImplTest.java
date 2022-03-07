package com.mysite.core.services;


import com.mysite.core.Utils;
import com.mysite.core.beans.ContactForm;
import com.mysite.core.beans.HttpClientResponse;
import com.mysite.core.configs.SalesforceServiceConfig;
import io.wcm.testing.mock.aem.junit5.AemContext;
import org.apache.sling.api.SlingHttpServletResponse;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Test case for the @{@link SalesforceServiceImpl} service.
 */
@ExtendWith(MockitoExtension.class)
public class SalesforceServiceImplTest {


    @InjectMocks
    private SalesforceServiceImpl salesforceService = new SalesforceServiceImpl();


    private final AemContext context = new AemContext();


    @Mock
    private HTTPClientService clientService;

    /**
     * When form data is incomplete, then bad request error should be thrown.
     */
    @Test
    public void testSalesforceResponse_whenIncompleteFormData() {

        ContactForm contactForm = new ContactForm(context.request());
        HttpClientResponse response = salesforceService.submitContactUsForm(contactForm);
        assertThat("The response code should be bad request : ", response.getCode(), CoreMatchers.is(SlingHttpServletResponse.SC_BAD_REQUEST));

    }


    /**
     * When form data is complete, invoke the response from http client service and return.
     */
    @Test
    public void testSalesforceResponse_whenCorrectForm() {

        context.request().setParameterMap(Utils.generateParameters());
        ContactForm contactForm = new ContactForm(context.request());

        SalesforceServiceConfig config = mock(SalesforceServiceConfig.class);

        this.mockService();
        Utils.mockConfig(config);

        salesforceService.activate(config);


        HttpClientResponse response = salesforceService.submitContactUsForm(contactForm);
        assertThat("The response code should be 200 OK: ", response.getCode(), CoreMatchers.is(SlingHttpServletResponse.SC_OK));

    }

    private void mockService() {
        when(clientService.httpPost(any())).thenReturn(new HttpClientResponse("Successfully updated", SlingHttpServletResponse.SC_OK));


    }




}

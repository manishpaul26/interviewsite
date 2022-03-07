package com.mysite.core.servlets;


import com.google.gson.Gson;
import com.mysite.core.Utils;
import com.mysite.core.beans.HttpClientResponse;
import com.mysite.core.services.SalesforceService;
import io.wcm.testing.mock.aem.junit5.AemContext;
import org.apache.sling.api.SlingHttpServletResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static junitx.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ContactUsServletTest {


    private final String SUCCESS_MESSAGE = "Contact request submitted";

    @InjectMocks
    private ContactUsServlet contactUsServlet = new ContactUsServlet();

    private final AemContext context = new AemContext();

    @Mock
    SalesforceService salesforceService;

    @Test
    public void testWhenServletReturnsCorrectResponse() throws IOException {


        context.request().setContent(new Gson().toJson(Utils.generateParameters()).getBytes());
        context.request().setParameterMap(Utils.generateParameters());

        when(salesforceService.submitContactUsForm(any())).thenReturn(new HttpClientResponse(SUCCESS_MESSAGE, SlingHttpServletResponse.SC_OK));

        contactUsServlet.doPost(context.request(), context.response());

        assertEquals(SUCCESS_MESSAGE, context.response().getOutputAsString());
        assertEquals(SlingHttpServletResponse.SC_OK, context.response().getStatus());
    }


}

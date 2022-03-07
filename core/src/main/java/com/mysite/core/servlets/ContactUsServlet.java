package com.mysite.core.servlets;

import com.google.gson.Gson;
import com.mysite.core.beans.ContactForm;
import com.mysite.core.beans.HttpClientResponse;
import com.mysite.core.services.SalesforceService;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import java.io.IOException;


@Component(
        service = Servlet.class,
        property = {
                "sling.servlet.extensions=json",
                "sling.servlet.selectors=form",
                "sling.servlet.methods=POST",
                "sling.servlet.resourceTypes=interviewsite/components/contactus"
        }
)
public class ContactUsServlet extends SlingAllMethodsServlet {

    private static final Logger LOG = LoggerFactory.getLogger(ContactUsServlet.class);

    @Reference
    private SalesforceService salesforceService;

    @Override
    public void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {

        ContactForm contactForm = new Gson().fromJson(request.getReader(), ContactForm.class);

        if (StringUtils.isAnyEmpty(contactForm.getFirstName(), contactForm.getLastName(), contactForm.getQuery())) {
            LOG.error("Contact form does not have all the required fields: {}.", contactForm.toString());

            response.getWriter().write("Incomplete form data.");
            response.sendError(SlingHttpServletResponse.SC_BAD_REQUEST);
            return;
        }


        HttpClientResponse salesforceResponse = salesforceService.submitContactUsForm(contactForm);
        response.getWriter().write(new Gson().toJson(salesforceResponse.getResponseBody()));
        response.setStatus(SlingHttpServletResponse.SC_OK);

    }
}

package com.mysite.core.services;


import com.mysite.core.beans.ContactForm;
import com.mysite.core.beans.HttpClientResponse;
import com.mysite.core.beans.RequestDetails;
import com.mysite.core.configs.SalesforceServiceConfig;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletResponse;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true, service = SalesforceService.class, name = "Salesforce Service")
@Designate(ocd = SalesforceServiceConfig.class)
public class SalesforceServiceImpl implements SalesforceService {


    private static Logger LOG = LoggerFactory.getLogger(SalesforceService.class);

    private SalesforceServiceConfig configuration;

    @Reference
    private HTTPClientService httpClientService;

    @Activate
    protected void activate(SalesforceServiceConfig configuration) {
        this.configuration = configuration;
    }

    @Override
    public HttpClientResponse submitContactUsForm(ContactForm contactForm) {


        // Some repeat logic to show some processing
        if (StringUtils.isAnyEmpty(contactForm.getFirstName(), contactForm.getLastName(), contactForm.getQuery())) {
            LOG.error("Contact form does not have all the required fields: {}.", contactForm.toString());
            return new HttpClientResponse("Incomplete form data.", SlingHttpServletResponse.SC_BAD_REQUEST);
        }


        HttpClientResponse response = httpClientService.httpPost(new RequestDetails(configuration, contactForm));
        return response;
    }
}

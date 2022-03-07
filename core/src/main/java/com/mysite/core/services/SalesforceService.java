package com.mysite.core.services;

import com.mysite.core.beans.ContactForm;
import com.mysite.core.beans.HttpClientResponse;

public interface SalesforceService {

    HttpClientResponse submitContactUsForm(ContactForm contactForm);

}

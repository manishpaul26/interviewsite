package com.mysite.core.beans;

import com.google.gson.annotations.SerializedName;
import org.apache.sling.api.SlingHttpServletRequest;

import static com.mysite.core.beans.ContactForm.Constants.*;

public class ContactForm {

    public class Constants {

        public static final String PARAM_FIRST_NAME = "firstname";
        public static final String PARAM_LAST_NAME = "lastname";
        public static final String PARAM_QUERY = "query";

    }


    @SerializedName(value = "firstname")
    private final String firstName;

    @SerializedName(value = "lastname")
    private final String lastName;
    private final String query;

    public ContactForm(SlingHttpServletRequest request) {

        this.firstName = request.getParameter(PARAM_FIRST_NAME);
        this.lastName = request.getParameter(PARAM_LAST_NAME);
        this.query = request.getParameter(PARAM_QUERY);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getQuery() {
        return query;
    }

    @Override
    public String toString() {
        return "ContactForm{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", query='" + query + '\'' +
                '}';
    }
}

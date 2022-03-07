package com.mysite.core.services;


import com.mysite.core.beans.HttpClientResponse;
import com.mysite.core.beans.RequestDetails;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.sling.api.SlingHttpServletResponse;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Component(immediate = true, service = HTTPClientService.class, name = "HTTP Client Service")
public class HttpClientServiceImpl implements HTTPClientService {


    @Override
    public HttpClientResponse httpPost(RequestDetails requestDetails) {

        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(requestDetails.getEndpointUrl());

            UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(requestDetails.getUsername(), requestDetails.getPassword());


            httpPost.addHeader(new BasicScheme().authenticate(credentials, httpPost, null));
            httpPost.setEntity(new UrlEncodedFormEntity(requestDetails.getParams()));

            CloseableHttpResponse response = client.execute(httpPost);
            response.getStatusLine().getStatusCode();


            // to mock the response for now, a success object is returned.
            return new HttpClientResponse("Successfully submitted", SlingHttpServletResponse.SC_OK);

        } catch (UnsupportedEncodingException | ClientProtocolException | AuthenticationException e) {
            return new HttpClientResponse(e.getMessage(), SlingHttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (IOException e) {
            return new HttpClientResponse(e.getMessage(), SlingHttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}

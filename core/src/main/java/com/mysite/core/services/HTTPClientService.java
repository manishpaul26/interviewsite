package com.mysite.core.services;

import com.mysite.core.beans.HttpClientResponse;
import com.mysite.core.beans.RequestDetails;

public interface HTTPClientService {

    HttpClientResponse httpPost(RequestDetails requestDetails);
}

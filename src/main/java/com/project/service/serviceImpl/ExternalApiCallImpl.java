package com.project.service.serviceImpl;


import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.service.serviceInterface.IExternalApiCall;


@Service
public class ExternalApiCallImpl implements IExternalApiCall {

	
	//storing api and url in variable so that changing value in future can easy
    private final String tokenUrl = "https://qa.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp";
    private final String customerListApi = "https://qa.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=get_customer_list";
	
	
	@Override
	 //getting token and data from sunbase url
    public Object[] getTokenFromApi() {

        //setting login and password
      String   requestBody = "{ \"login_id\": \"test@sunbasedata.com\", \"password\": \"Test@123\" }";

      //calling fucntion to get token
       String token =   Apicall(tokenUrl,requestBody);

       //retrieving tokem
       String acessToken = token.substring(19, token.length()-3);

       //calling getcustomer function to get data with token
        List<Object> customers = getCustomers(acessToken, customerListApi);

        //returing data
        Object[] customerReceived =customers.toArray();
        return customerReceived;
    }

	@Override
	public String Apicall(String apiUrl, String requestBody) {

        //using restTemplate and httpheader to consume external api
        RestTemplate restTemplate = new RestTemplate();

      HttpHeaders headers = new HttpHeaders();

        //setting content type for header
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody,headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                                                                         apiUrl,
                                                                         HttpMethod.POST,
                                                                         requestEntity,
                                                                          String.class
                                                                       );

               String responseBody =responseEntity.getBody();
               return  responseBody;
    }

	@Override
	public List<Object> getCustomers(String token, String apiurl) {

        //using restTemplate and httpheader to consume external api
        RestTemplate restTemplate = new RestTemplate();

         HttpHeaders headers = new HttpHeaders();

        //setting content type for header
         headers.setContentType(MediaType.APPLICATION_JSON);

          headers.set("Authorization", "Bearer " + token);

         HttpEntity<String> requestEntity =new HttpEntity<>(headers);

         ResponseEntity<Object[]> responseEntity = restTemplate.exchange(
              apiurl,
              HttpMethod.GET,
              requestEntity,
              Object[].class
         );

         Object[] responseBody = responseEntity.getBody();
         return List.of(responseBody);

    }

}

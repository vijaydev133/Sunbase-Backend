package com.project.service.serviceInterface;

import java.util.List;

public interface IExternalApiCall {
	public Object[] getTokenFromApi();
	public String Apicall(String apiUrl, String requestBody) ;
	public List<Object> getCustomers(String token, String apiurl);
}

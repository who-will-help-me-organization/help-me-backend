package org.helpme.util.request;

import org.springframework.http.HttpMethod;

public enum Endpoints {
	LOGIN(UrlProvider.AUTHENTICATION, HttpMethod.POST),
	SIGNUP(UrlProvider.USER, HttpMethod.POST);

	private String url;
	private HttpMethod method;
	
	Endpoints(String url, HttpMethod method) {
		this.url = url;
		this.method = method;
	}
	
	public String getUrl() {
		return url;
	}
	
	public HttpMethod getMethod() {
		return method;
	}
}

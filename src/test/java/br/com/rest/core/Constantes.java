package br.com.rest.core;

import io.restassured.http.ContentType;

public interface Constantes {


	String BASE_URL = "http://localhost:5000";
	String BASE_PATH = "/api";
	
	ContentType CONTENT_TYPE = ContentType.URLENC;
	
	Long MAX_TIMEOUT = 1000L;
}

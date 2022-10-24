package br.com.rest;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;

import org.junit.Test;

import io.restassured.http.ContentType;

public class CRUD {
	
	
	@Test
	public void deveRegistrarUsuario() {
		given()
			.log().all()
			.formParam("email", "teste@read6.com")
			.formParam("password", "senha")
			.formParam("role", "read")
			.contentType(ContentType.URLENC.withCharset("UTF-8"))
		.when()
			.post("http://localhost:5000/api/register")
		.then()
			.log().all()
			.statusCode(201)
			//ajustar forma de validação
//			.body("html.body.success", is("created"))   
		;
		
	}
	
	
	@Test
	public void deveFazerLogin() {

		
		String token =
				given()
			.log().all()
			.auth().preemptive().basic("teste@read6.com", "senha")
			.contentType(ContentType.JSON.withCharset("UTF-8"))
		.when()
			.post("http://localhost:5000/api/login")
		.then()
			.log().all()
			.statusCode(201)
			.extract().path("token")
		;
		
		given()
			.log().all()
		.header("Authorization",token)
			.contentType(ContentType.JSON.withCharset("UTF-8"))
		.when()
			.get("http://localhost:5000/api/employees/all")
		.then()
			.log().all()
			.statusCode(200)
	;
		
	}

}


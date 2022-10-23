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
		User user = new User("read@teste.com", "read");
		
		given()
			.log().all()
			.body(user)
			.contentType(ContentType.URLENC.withCharset("UTF-8"))
		.when()
			.post("http://localhost:5000/api/login")
		.then()
			.log().all()
			.statusCode(200)
//			.body("user.userEmail", is("read@teste.com"))
//			.body("user.userPwd", is("read"))
//			.body("user.role", is("read"))
		;
		
	}

}


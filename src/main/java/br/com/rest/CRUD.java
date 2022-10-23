package br.com.rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import io.restassured.http.ContentType;

public class CRUD {
	
	
	@Test
	public void deveRegistrarUsuario() {
//		User user = new User("read@teste.com", "read", "read");
		given()
			.log().all()
//			.contentType(ContentType.XML)
//			.body(user)
		.when()
			.post("http://localhost:5000/api/register")
		.then()
			.log().all()
			.statusCode(201)
//			.body("user.userEmail", is("read@teste.com"))
//			.body("user.userPwd", is("read"))
//			.body("user.role", is("read"))
		;
		
	}
	
	@Test
	public void deveFazerLogin() {
		
		given()
			.log().all()
		.when()
			.get("http://localhost:5000/api/login")
		.then()
			.log().all()
			.statusCode(401)
//			.body("user.userEmail", is("read@teste.com"))
//			.body("user.userPwd", is("read"))
//			.body("user.role", is("read"))
		;
		
	}

}


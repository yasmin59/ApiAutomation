package br.com.rest.test;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.rest.core.Config;
import io.restassured.path.json.JsonPath;

public class EmployeeTest extends Config{
	
	@Test
	public void naoDeveRegistrarUsuarioExistente() {
		given()
			.formParam("email", "teste@read6.com")
			.formParam("password", "senha")
			.formParam("role", "read")
		.when()
			.post("/register")
		.then()
			.statusCode(403)
		;	
	}
	
	@Test
	public void deveRegistrarUsuario() {
		given()
			.formParam("email", "teste@read7.com")
			.formParam("password", "senha")
			.formParam("role", "read")
		.when()
			.post("/register")
		.then()
			.statusCode(201)
		;	
	}
	
	@Test
	public void naoDeveLogarUsuarioInexistente() {
//		Com o preemtive o usuário loga mas não gera token
		given()
			.auth().basic("renata@renata", "senha")
		.when()
			.post("/login")
		.then()
			.log().all()
			.statusCode(201)
//			.extract().path("html/body/token")
		;
	}
	
	@Test
	public void deveLogarComSucesso() {

		String jsonString = 
		 given()
			.log().all()
			.auth().preemptive().basic("teste@test.com", "test")
		.when()
			.post("/login")
		.then()
			.log().all()
			.statusCode(201)
			.extract().body().asString()
		;
		
//		String token = JsonPath.from(jsonString).get("token");
//			 
//		 given()
//			.header("Authorization", "Basic " + token)
//		.when()
//			.post("/login")
//		.then()
//			.statusCode(500)
//		;
	}
	


}

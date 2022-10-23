package br.com.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	
	private String email;
	private String password;
	private String role;
	
	public User() {
		super();
	}
	public User(String email, String password, String role) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
	}
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + "]";
	}

}

package org.generation.BlogPessoal.dtos;

public class CredenciaisDTO {
	
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String token;
	
	
	public Long getIdUsuario() {
		return id;
	}
	public void setIdUsuario(Long id) {
		this.id = id;
	}
	public String getNomeUsuario() {
		return nome;
	}
	public void setNomeUsuario(String nome) {
		this.nome = nome;
	}
	public String getEmailUsuario() {
		return email;
	}
	public void setEmailUsuario(String email) {
		this.email = email;
	}
	public String getSenhaUsuario() {
		return senha;
	}
	public void setSenhaUsuario(String senha) {
		this.senha = senha;
	}
	public String getTokenUsuario() {
		return token;
	}
	public void setTokenUsuario(String token) {
		this.token = token;
	}


}

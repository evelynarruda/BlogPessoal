package org.generation.BlogPessoal.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
	@Table(name = "usuarios")
	public class UsuarioModel {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private String id;
		
		@NotNull
		@Size(min = 5, max = 100)
		private String nome;
		
		@ApiModelProperty(example = "evelynarrudasilva@gmail.com")
		@NotNull(message = "O atributo Usuário é Obrigatório!")
		@Email(message = "O atributo Usuário deve ser um email válido!")
		private String usuario;
		
		@NotNull
		@Size(min = 5)
		private String senha;
		
				
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

	
	
}

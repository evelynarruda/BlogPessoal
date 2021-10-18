package org.generation.BlogPessoal.repository;

import java.util.Optional;

import org.generation.BlogPessoal.model.UsuarioLogin;
import org.generation.BlogPessoal.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
	public static Optional<UsuarioModel> findByUsuario(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Optional<UsuarioLogin> findAllByUsuario() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
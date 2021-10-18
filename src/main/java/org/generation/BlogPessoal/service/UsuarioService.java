package org.generation.BlogPessoal.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.generation.BlogPessoal.model.Usuario;
import org.generation.BlogPessoal.model.UsuarioLogin;
import org.generation.BlogPessoal.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepositorio repositorio;

	public Optional<Object> cadastrarUsuario(UsuarioLogin usuario) {
		return repositorio.findByEmail(usuario.getEmail()).map(usuarioExistente -> {
			return Optional.empty();
		}).orElseGet(() -> {
			return Optional.ofNullable(repositorio.save(usuario));
		});
	}
	
	public Optional<UsuarioLogin> Logar(Optional<UsuarioLogin> user) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = repositorio.findByEmail(user.get().getEmail());

		if (usuario.isPresent()) {
			if (encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {

				String auth = user.get().getEmail() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);

				user.get().setToken(authHeader);				
				user.get().setNome(usuario.get().getNome());
				user.get().setSenha(usuario.get().getSenha());

				return user;

			}
		}
		return null;
	}

}




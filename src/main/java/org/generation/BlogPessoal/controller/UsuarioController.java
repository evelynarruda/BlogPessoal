package org.generation.BlogPessoal.controller;

import java.util.Optional;

import org.generation.BlogPessoal.model.UsuarioModel;
import org.generation.BlogPessoal.repository.UsuarioRepository;
import org.generation.BlogPessoal.model.UsuarioLogin;
import org.generation.BlogPessoal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	
	@Autowired
	private UsuarioService usuarioService;


	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> Autentication(@RequestBody Optional<UsuarioLogin> user) {
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}


	public ResponseEntity<UsuarioLogin> Post(@RequestBody UsuarioModel usuario) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(usuarioService.CadastrarUsuario(usuario));
	}
	

    @GetMapping("/todos")
    public ResponseEntity<Optional<UsuarioLogin>> getAll(){
        if(UsuarioRepository.findAllByUsuario().isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        else {
            return ResponseEntity.status(200).body(UsuarioRepository.findAllByUsuario());
        }
    }

 }



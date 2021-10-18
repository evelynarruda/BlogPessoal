package org.generation.BlogPessoal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.generation.BlogPessoal.model.Usuario;
import org.generation.BlogPessoal.repository.UsuarioRepositorio;
import org.generation.BlogPessoal.model.UsuarioLogin;
import org.generation.BlogPessoal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepositorio repositorio;
	@Autowired
	private UsuarioService usuarioService;


	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> Autentication(@RequestBody Optional<UsuarioLogin> user) {
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Optional<Object>> Post(@RequestBody UsuarioLogin usuario) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(usuarioService.cadastrarUsuario(usuario));
	}

	@GetMapping("/todos")
    public ResponseEntity<List<Usuario>> getAll(){
        if(repositorio.findAll().isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        else {
            return ResponseEntity.status(200).body(repositorio.findAll());
        }
    }

 }



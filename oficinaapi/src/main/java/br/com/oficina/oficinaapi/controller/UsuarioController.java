package br.com.oficina.oficinaapi.controller;

import java.util.List;
import java.util.Optional;

import br.com.oficina.oficinaapi.dto.LoginDTO;
import br.com.oficina.oficinaapi.dto.UsuarioRegistro;
import br.com.oficina.oficinaapi.model.Carro;
import br.com.oficina.oficinaapi.model.Usuario;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.oficina.oficinaapi.repository.UsuarioRepository;

@RestController

public class UsuarioController {
    

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/usuario")

    public ResponseEntity<Usuario> cadastraUsuario(@RequestBody UsuarioRegistro usuarioRegistro) {
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioRegistro, usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> fazLogin(@RequestBody LoginDTO body){
        Usuario usuario = null;
        try{
            usuario = usuarioRepository.getUserByEmail(body.email());
        }catch (SecurityException e){
            throw new RuntimeException(e);
        }


        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    @GetMapping
    public ResponseEntity<String> buscaNome(@PathVariable String id) {
        try {
            Usuario usuario = usuarioRepository.getReferenceById(id);
            return ResponseEntity.status(HttpStatus.OK).body(usuario.getNome());
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }
    }

    }







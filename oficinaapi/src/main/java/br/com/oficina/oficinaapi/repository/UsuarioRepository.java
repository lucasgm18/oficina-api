package br.com.oficina.oficinaapi.repository;

import br.com.oficina.oficinaapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    static Optional<Usuario> findById(Long id) {

        return Optional.empty();
    }

    public Usuario getUserByEmail(String email);

    
}

package br.com.oficina.oficinaapi.repository;

import br.com.oficina.oficinaapi.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CarroRepository extends JpaRepository<Carro, String> {
}

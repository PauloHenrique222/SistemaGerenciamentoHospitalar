package br.com.unialfa.sgh.repository;

import br.com.unialfa.sgh.domain.Tipo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TipoRepository extends CrudRepository<Tipo, Long> {
    List<Tipo> findByUsuarioId(long usuarioId);
}

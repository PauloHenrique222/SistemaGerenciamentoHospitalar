package br.com.unialfa.sgh.repository;

import br.com.unialfa.sgh.domain.UnidadeSaude;
import org.springframework.data.repository.CrudRepository;

public interface UnidadeSaudeRepository extends CrudRepository<UnidadeSaude, Long> {
    Iterable<UnidadeSaude> findByUsuarioId(long usuarioId);
}

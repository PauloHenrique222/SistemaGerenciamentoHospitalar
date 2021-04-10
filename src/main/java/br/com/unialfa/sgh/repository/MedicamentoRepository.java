package br.com.unialfa.sgh.repository;

import br.com.unialfa.sgh.domain.Medicamento;
import org.springframework.data.repository.CrudRepository;

public interface MedicamentoRepository extends CrudRepository<Medicamento, Long> {
}

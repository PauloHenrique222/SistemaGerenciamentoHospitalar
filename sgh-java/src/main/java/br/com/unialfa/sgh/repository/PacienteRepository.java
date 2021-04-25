package br.com.unialfa.sgh.repository;

import br.com.unialfa.sgh.domain.Paciente;
import org.springframework.data.repository.CrudRepository;

public interface PacienteRepository extends CrudRepository<Paciente, Long> {
}

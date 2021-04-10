package br.com.unialfa.sgh.repository;

import br.com.unialfa.sgh.domain.Funcionario;
import org.springframework.data.repository.CrudRepository;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
}

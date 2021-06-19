package br.com.unialfa.sgh.repository;


import br.com.unialfa.sgh.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}

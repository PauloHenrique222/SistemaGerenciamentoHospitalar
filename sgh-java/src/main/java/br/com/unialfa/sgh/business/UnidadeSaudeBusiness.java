package br.com.unialfa.sgh.business;

import br.com.unialfa.sgh.DAO.UnidadeSaudeDAO;
import br.com.unialfa.sgh.domain.*;
import br.com.unialfa.sgh.repository.TipoRepository;
import br.com.unialfa.sgh.repository.UnidadeSaudeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UnidadeSaudeBusiness {

    private final UnidadeSaudeRepository unidadeSaudeRepository;
    private final EnderecoBusiness enderecoBusiness;
    private final TipoRepository tipoRepository;

    public UnidadeSaudeBusiness(UnidadeSaudeRepository unidadeSaudeRepository, EnderecoBusiness enderecoBusiness, TipoRepository tipoRepository) {
        this.unidadeSaudeRepository = unidadeSaudeRepository;
        this.enderecoBusiness = enderecoBusiness;
        this.tipoRepository = tipoRepository;
    }

    public void cadastrarUnidadeSaude(UnidadeSaudeDAO unidadeSaudeDAO){

        UnidadeSaude unidadeSaude = new UnidadeSaude();
        unidadeSaude.setNome(unidadeSaudeDAO.getNome());
        unidadeSaude.setNumeroRegistro(unidadeSaudeDAO.getNumeroRegistro());

        Optional<Tipo> tipo =  tipoRepository.findById(unidadeSaudeDAO.getTipo_id());
        unidadeSaude.setTipo(tipo.get());

        Endereco endereco;
        endereco = enderecoBusiness.cadastrarEndereco(unidadeSaudeDAO.getEnderecoDAO());
        unidadeSaude.setEndereco(endereco);

        unidadeSaudeRepository.save(unidadeSaude);
    }

    public Iterable<UnidadeSaude> listarUnidades(){
        return unidadeSaudeRepository.findAll();
    }

    public void editarUnidadeSaude(UnidadeSaude unidadeSaude){
        unidadeSaudeRepository.save(unidadeSaude);
    }
}

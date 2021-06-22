package br.com.unialfa.sgh.business;

import br.com.unialfa.sgh.DAO.UnidadeSaudeDAO;
import br.com.unialfa.sgh.domain.*;
import br.com.unialfa.sgh.repository.EnderecoRepository;
import br.com.unialfa.sgh.repository.TipoRepository;
import br.com.unialfa.sgh.repository.UnidadeSaudeRepository;
import org.springframework.stereotype.Service;

@Service
public class UnidadeSaudeBusiness {

    private final UnidadeSaudeRepository unidadeSaudeRepository;
    private final EnderecoRepository enderecoRepository;
    private final TipoRepository tipoRepository;

    public UnidadeSaudeBusiness(UnidadeSaudeRepository unidadeSaudeRepository, EnderecoRepository enderecoRepository, TipoRepository tipoRepository) {
        this.unidadeSaudeRepository = unidadeSaudeRepository;
        this.enderecoRepository = enderecoRepository;
        this.tipoRepository = tipoRepository;
    }

    public void cadastrarUnidadeSaude(UnidadeSaudeDAO unidadeSaudeDAO){

        UnidadeSaude unidadeSaude = new UnidadeSaude();
        unidadeSaude.setNome(unidadeSaudeDAO.getNome());
        unidadeSaude.setNumeroRegistro(unidadeSaudeDAO.getNumeroRegistro());
        unidadeSaude.setTelefone(unidadeSaudeDAO.getTelefone());
        unidadeSaude.setUsuarioId(unidadeSaudeDAO.getUsuarioId());
        unidadeSaude.setTipo(unidadeSaudeDAO.getTipo());

        Endereco endereco;
        endereco = enderecoRepository.save(unidadeSaudeDAO.getEndereco());
        unidadeSaude.setEndereco(endereco);

        unidadeSaudeRepository.save(unidadeSaude);
    }

    public Iterable<UnidadeSaude> listarUnidades(long usuarioId){
        return unidadeSaudeRepository.findByUsuarioId(usuarioId);
    }

    public void editarUnidadeSaude(UnidadeSaude unidadeSaude){
        unidadeSaudeRepository.save(unidadeSaude);
    }
}

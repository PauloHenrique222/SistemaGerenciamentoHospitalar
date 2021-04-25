package br.com.unialfa.sgh.business;

import br.com.unialfa.sgh.DAO.EnderecoDAO;
import br.com.unialfa.sgh.domain.Cidade;
import br.com.unialfa.sgh.domain.Endereco;
import br.com.unialfa.sgh.domain.Estado;
import br.com.unialfa.sgh.domain.Pais;
import br.com.unialfa.sgh.repository.CidadeRepository;
import br.com.unialfa.sgh.repository.EnderecoRepository;
import br.com.unialfa.sgh.repository.EstadoRepository;
import br.com.unialfa.sgh.repository.PaisRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoBusiness {

    private final EnderecoRepository enderecoRepository;
    private final PaisRepository paisRepository;
    private final EstadoRepository estadoRepository;
    private final CidadeRepository cidadeRepository;

    public EnderecoBusiness(EnderecoRepository enderecoRepository, PaisRepository paisRepository, EstadoRepository estadoRepository, CidadeRepository cidadeRepository) {
        this.enderecoRepository = enderecoRepository;
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
        this.cidadeRepository = cidadeRepository;
    }

    public Endereco cadastrarEndereco(EnderecoDAO enderecoDAO){

        Endereco endereco = new Endereco();
        endereco.setRua(enderecoDAO.getRua());
        endereco.setCep(enderecoDAO.getCep());
        endereco.setComplemento(enderecoDAO.getComplemento());
        endereco.setSetor(enderecoDAO.getSetor());
        endereco.setNumero(enderecoDAO.getNumero());
        Optional<Pais> pais = paisRepository.findById(enderecoDAO.getPais_id());
        endereco.setPais(pais.get());
        Optional<Estado> estado = estadoRepository.findById(enderecoDAO.getEstado_id());
        endereco.setEstado(estado.get());
        Optional<Cidade> cidade = cidadeRepository.findById(enderecoDAO.getCidade_id());
        endereco.setCidade(cidade.get());
        return enderecoRepository.save(endereco);
    }

    public Iterable<Endereco> listarEnderecos(){
        return enderecoRepository.findAll();
    }

    public void editarEndereco(Endereco endereco){
       enderecoRepository.save(endereco);
    }

}

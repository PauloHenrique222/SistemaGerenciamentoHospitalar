package br.com.unialfa.sgh.business;

import br.com.unialfa.sgh.DAO.FuncionarioDAO;
import br.com.unialfa.sgh.domain.*;
import br.com.unialfa.sgh.repository.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioBusiness {


    private final FuncionarioRepository funcionarioRepository;
    private final EnderecoBusiness enderecoBusiness;
    private final DepartamentoRepository departamentoRepository;
    private final RegraRepository regraRepository;
    private final CargoRepository cargoRepository;

    public FuncionarioBusiness(FuncionarioRepository funcionarioRepository, EnderecoBusiness enderecoBusiness, DepartamentoRepository departamentoRepository, RegraRepository regraRepository, CargoRepository cargoRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.enderecoBusiness = enderecoBusiness;
        this.departamentoRepository = departamentoRepository;
        this.regraRepository = regraRepository;
        this.cargoRepository = cargoRepository;
    }


    public void cadastrarFuncionario(FuncionarioDAO funcionarioDAO){

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(funcionarioDAO.getNome());
        funcionario.setSobrenome(funcionarioDAO.getSobrenome());
        funcionario.setNumeroConcelho(funcionarioDAO.getNumeroConcelho());
        funcionario.setSalario(funcionarioDAO.getSalario());
        funcionario.setAtivo(funcionarioDAO.isAtivo());
        funcionario.setEmail(funcionarioDAO.getEmail());
        funcionario.setSenha(funcionarioDAO.getSenha());
        funcionario.setCoordenador(funcionarioDAO.isCoordenador());

        Optional<Cargo> cargo =  cargoRepository.findById(funcionarioDAO.getCargo_id());
        funcionario.setCargo(cargo.get());

        Optional<Regra> regra =  regraRepository.findById(funcionarioDAO.getRegra_id());
        funcionario.setRegra(regra.get());

        Optional<Departamento> departamento =  departamentoRepository.findById(funcionarioDAO.getDepartamento_id());
        funcionario.setDepartamento(departamento.get());

        Endereco endereco;
        endereco = enderecoBusiness.cadastrarEndereco(funcionarioDAO.getEnderecoDAO());
        funcionario.setEndereco(endereco);

        funcionarioRepository.save(funcionario);
    }

    public Iterable<Funcionario> listarUnidades(){
        return funcionarioRepository.findAll();
    }

    public void editarUnidadeSaude(Funcionario funcionario){
        funcionarioRepository.save(funcionario);
    }
}

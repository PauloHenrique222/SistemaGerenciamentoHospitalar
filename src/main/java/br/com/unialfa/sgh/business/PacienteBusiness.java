package br.com.unialfa.sgh.business;

import br.com.unialfa.sgh.DAO.PacienteDAO;
import br.com.unialfa.sgh.domain.Endereco;
import br.com.unialfa.sgh.domain.Paciente;
import br.com.unialfa.sgh.repository.PacienteRepository;
import org.springframework.stereotype.Service;

@Service
public class PacienteBusiness {

    private final EnderecoBusiness enderecoBusiness;
    private final PacienteRepository pacienteRepository;

    public PacienteBusiness(EnderecoBusiness enderecoBusiness, PacienteRepository pacienteRepository) {
        this.enderecoBusiness = enderecoBusiness;
        this.pacienteRepository = pacienteRepository;
    }

    public void cadastrarPaciente(PacienteDAO pacienteDAO){

        Paciente paciente = new Paciente();
        paciente.setNome(pacienteDAO.getNome());
        paciente.setCpf(pacienteDAO.getCpf());
        paciente.setRg(pacienteDAO.getRg());
        Endereco endereco;
        endereco = enderecoBusiness.cadastrarEndereco(pacienteDAO.getEnderecoDAO());
        paciente.setEndereco(endereco);

        pacienteRepository.save(paciente);
    }

    public Iterable<Paciente> listarPacientes(){
        return pacienteRepository.findAll();
    }

    public void editarPaciente(Paciente paciente) {
        pacienteRepository.save(paciente);
    }
}

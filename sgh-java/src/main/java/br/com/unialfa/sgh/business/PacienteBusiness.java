package br.com.unialfa.sgh.business;

import br.com.unialfa.sgh.DAO.PacienteDAO;
import br.com.unialfa.sgh.domain.Endereco;
import br.com.unialfa.sgh.domain.Paciente;
import br.com.unialfa.sgh.repository.EnderecoRepository;
import br.com.unialfa.sgh.repository.PacienteRepository;
import org.springframework.stereotype.Service;

@Service
public class PacienteBusiness {

    private final EnderecoRepository enderecoRepository;
    private final PacienteRepository pacienteRepository;

    public PacienteBusiness(EnderecoRepository enderecoRepository, PacienteRepository pacienteRepository) {
        this.enderecoRepository = enderecoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public void cadastrarPaciente(PacienteDAO pacienteDAO){

        Paciente paciente = new Paciente();
        paciente.setNome(pacienteDAO.getNome());
        paciente.setCpf(pacienteDAO.getCpf());
        paciente.setRg(pacienteDAO.getRg());
        Endereco endereco;
        endereco = enderecoRepository.save(pacienteDAO.getEndereco());
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

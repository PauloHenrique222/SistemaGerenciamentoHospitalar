package br.com.unialfa.sgh.business;


import br.com.unialfa.sgh.DAO.FichaAtendimentoDAO;
import br.com.unialfa.sgh.domain.*;
import br.com.unialfa.sgh.repository.*;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.time.LocalDateTime;

@Service
public class FichaAtendimentoBusiness {

    private final UnidadeSaudeRepository unidadeSaudeRepository;
    private final PacienteRepository pacienteRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final PrioridadeRepository prioridadeRepository;
    private final FichaAtendimentoRepository fichaAtendimentoRepository;

    public FichaAtendimentoBusiness(UnidadeSaudeRepository unidadeSaudeRepository, PacienteRepository pacienteRepository, FuncionarioRepository funcionarioRepository, PrioridadeRepository prioridadeRepository, FichaAtendimentoRepository fichaAtendimentoRepository) {
        this.unidadeSaudeRepository = unidadeSaudeRepository;
        this.pacienteRepository = pacienteRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.prioridadeRepository = prioridadeRepository;
        this.fichaAtendimentoRepository = fichaAtendimentoRepository;
    }


    public void cadastrarFichaAtendimento(FichaAtendimentoDAO fichaAtendimentoDAO){
        FichaAtendimento fichaAtendimento = new FichaAtendimento();
        fichaAtendimento.setHorarioEntrada(LocalDateTime.now());
        fichaAtendimento.setSintomas(fichaAtendimentoDAO.getSintomas());
        fichaAtendimento.setObservacao(fichaAtendimentoDAO.getObservacao());

        Optional<Paciente> paciente = pacienteRepository.findById(fichaAtendimentoDAO.getPaciente_id());
        fichaAtendimento.setPaciente(paciente.get());

        Optional<UnidadeSaude> unidadeSaude =  unidadeSaudeRepository.findById(fichaAtendimentoDAO.getUnidade_saude_id());
        fichaAtendimento.setUnidadeSaude(unidadeSaude.get());

        Optional<Funcionario> funcionario =  funcionarioRepository.findById(fichaAtendimentoDAO.getFuncionario_id());
        fichaAtendimento.setFuncionario(funcionario.get());

        Optional<Prioridade> prioridade = prioridadeRepository.findById(fichaAtendimentoDAO.getPrioridade_id());
        fichaAtendimento.setPrioridade(prioridade.get());

        fichaAtendimentoRepository.save(fichaAtendimento);

    }

    public Iterable<FichaAtendimento> listarFichas(){
        return fichaAtendimentoRepository.findAll();
    }

    public void editarFicha(FichaAtendimentoDAO fichaAtendimentoDAO){
        FichaAtendimento fichaAtendimentoEdit = new FichaAtendimento();

        fichaAtendimentoEdit.setSintomas(fichaAtendimentoDAO.getSintomas());
        fichaAtendimentoEdit.setObservacao(fichaAtendimentoDAO.getObservacao());

        Optional<Prioridade> prioridade = prioridadeRepository.findById(fichaAtendimentoDAO.getPaciente_id());
        fichaAtendimentoEdit.setPrioridade(prioridade.get());

        fichaAtendimentoRepository.save(fichaAtendimentoEdit);
    }
}

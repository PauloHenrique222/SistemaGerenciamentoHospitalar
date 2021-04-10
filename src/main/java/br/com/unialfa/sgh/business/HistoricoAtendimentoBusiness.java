package br.com.unialfa.sgh.business;

import br.com.unialfa.sgh.DAO.HistoricoAtendimentoDAO;
import br.com.unialfa.sgh.domain.FichaAtendimento;
import br.com.unialfa.sgh.domain.Funcionario;
import br.com.unialfa.sgh.domain.HistoricoAtendimento;
import br.com.unialfa.sgh.repository.FichaAtendimentoRepository;
import br.com.unialfa.sgh.repository.FuncionarioRepository;
import br.com.unialfa.sgh.repository.HistoritoAtendimentoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class HistoricoAtendimentoBusiness {

    private final FuncionarioRepository funcionarioRepository;
    private final FichaAtendimentoRepository fichaAtendimentoRepository;
    private final HistoritoAtendimentoRepository historitoAtendimentoRepository;

    public HistoricoAtendimentoBusiness(FuncionarioRepository funcionarioRepository, FichaAtendimentoRepository fichaAtendimentoRepository, HistoritoAtendimentoRepository historitoAtendimentoRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.fichaAtendimentoRepository = fichaAtendimentoRepository;
        this.historitoAtendimentoRepository = historitoAtendimentoRepository;
    }

    public void cadastrarHistoricoAtendimento(HistoricoAtendimentoDAO historicoAtendimentoDAO){
        HistoricoAtendimento historicoAtendimento = new HistoricoAtendimento();
        historicoAtendimento.setData(LocalDateTime.now());
        historicoAtendimento.setObservacao(historicoAtendimentoDAO.getObservacao());


        Optional<Funcionario> funcionario =  funcionarioRepository.findById(historicoAtendimentoDAO.getFuncionario_id());
        historicoAtendimento.setFuncionario(funcionario.get());

        Optional<FichaAtendimento> fichaAtendimento =  fichaAtendimentoRepository.findById(historicoAtendimentoDAO.getFicha_atendimento_id());
        historicoAtendimento.setFichaAtendimento(fichaAtendimento.get());

        historitoAtendimentoRepository.save(historicoAtendimento);
    }

    public Iterable<HistoricoAtendimento> listarHistoricos(){
        return historitoAtendimentoRepository.findAll();
    }

    public void editarHistoricos(HistoricoAtendimento historicoAtendimento){
        historitoAtendimentoRepository.save(historicoAtendimento);
    }
}

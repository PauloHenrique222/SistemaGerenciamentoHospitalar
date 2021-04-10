package br.com.unialfa.sgh.business;

import br.com.unialfa.sgh.DAO.SolicitacaoDAO;
import br.com.unialfa.sgh.domain.*;
import br.com.unialfa.sgh.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SolicitacaoBusiness {

    private final FichaAtendimentoRepository fichaAtendimentoRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final ExameRepository exameRepository;
    private final MedicamentoRepository medicamentoRepository;
    private final SolicitacaoRepository solicitacaoRepository;

    public SolicitacaoBusiness(FichaAtendimentoRepository fichaAtendimentoRepository, FuncionarioRepository funcionarioRepository, ExameRepository exameRepository, MedicamentoRepository medicamentoRepository, SolicitacaoRepository solicitacaoRepository) {
        this.fichaAtendimentoRepository = fichaAtendimentoRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.exameRepository = exameRepository;
        this.medicamentoRepository = medicamentoRepository;
        this.solicitacaoRepository = solicitacaoRepository;
    }


    public void cadastrarSolicitacao(SolicitacaoDAO solicitacaoDAO){

        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setConcluida(false);
        solicitacao.setData(LocalDateTime.now());

        Optional<FichaAtendimento> fichaAtendimento = fichaAtendimentoRepository.findById(solicitacaoDAO.getFicha_atendimento_id());
        solicitacao.setFichaAtendimento(fichaAtendimento.get());

        Optional<Funcionario> funcionario = funcionarioRepository.findById(solicitacaoDAO.getFuncionario_id());
        solicitacao.setFuncionario(funcionario.get());

        List<Exame> exames = (List<Exame>) exameRepository.findAllById(solicitacaoDAO.getExame_id());
        solicitacao.setSolicitacaoExames(exames);

        List<Medicamento> medicamentos = (List<Medicamento>) medicamentoRepository.findAllById(solicitacaoDAO.getMedicamento_id());
        solicitacao.setSolicitacaoMedicamentos(medicamentos);

        solicitacaoRepository.save(solicitacao);
    }

    public Iterable<Solicitacao> listarSolicitacao(){
        return solicitacaoRepository.findAll();
    }

    public void editarSolicitacao(Solicitacao solicitacao) {
        solicitacaoRepository.save(solicitacao);
    }

}

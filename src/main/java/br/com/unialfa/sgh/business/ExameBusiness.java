package br.com.unialfa.sgh.business;

import br.com.unialfa.sgh.DAO.ExameDAO;
import br.com.unialfa.sgh.domain.Exame;
import br.com.unialfa.sgh.domain.UnidadeSaude;
import br.com.unialfa.sgh.repository.ExameRepository;
import br.com.unialfa.sgh.repository.UnidadeSaudeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExameBusiness {

    private final ExameRepository exameRepository;
    private final UnidadeSaudeRepository unidadeSaudeRepository;

    public ExameBusiness(ExameRepository exameRepository, UnidadeSaudeRepository unidadeSaudeRepository) {
        this.exameRepository = exameRepository;
        this.unidadeSaudeRepository = unidadeSaudeRepository;
    }

    public Exame cadastrarExame(ExameDAO exameDAO){

        Exame exame = new Exame();
        exame.setNome(exameDAO.getNome());
        exame.setDescricao(exameDAO.getDescricao());
        Optional<UnidadeSaude> unidadeSaude = unidadeSaudeRepository.findById(exameDAO.getUnidade_saude_id());
        exame.setUnidadeSaude(unidadeSaude.get());

        return exameRepository.save(exame);
    }

    public Iterable<Exame> listarExame() {
        return exameRepository.findAll();
    }


    public void editarExame(Exame medicamento) {
        exameRepository.save(medicamento);
    }


    public void deletarExame(long id) {
        exameRepository.deleteById(id);
    }
}

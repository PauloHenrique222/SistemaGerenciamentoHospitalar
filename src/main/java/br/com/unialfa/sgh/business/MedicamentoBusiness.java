package br.com.unialfa.sgh.business;

import br.com.unialfa.sgh.DAO.MedicamentoDAO;
import br.com.unialfa.sgh.domain.Medicamento;
import br.com.unialfa.sgh.domain.UnidadeSaude;
import br.com.unialfa.sgh.repository.MedicamentoRepository;
import br.com.unialfa.sgh.repository.UnidadeSaudeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicamentoBusiness {

    private final MedicamentoRepository medicamentoRepository;
    private final UnidadeSaudeRepository unidadeSaudeRepository;


    public MedicamentoBusiness(MedicamentoRepository medicamentoRepository, UnidadeSaudeRepository unidadeSaudeRepository) {
        this.medicamentoRepository = medicamentoRepository;
        this.unidadeSaudeRepository = unidadeSaudeRepository;
    }

    public Medicamento cadastrarMedicamento(MedicamentoDAO medicamentoDAO){

        Medicamento medicamento = new Medicamento();
        medicamento.setNome(medicamentoDAO.getNome());
        medicamento.setLote(medicamentoDAO.getLote());
        medicamento.setFabricante(medicamentoDAO.getFabricante());
        medicamento.setDataValidade(medicamentoDAO.getDataValidade());
        medicamento.setQuantidade(medicamentoDAO.getQuantidade());
        Optional<UnidadeSaude> unidadeSaude = unidadeSaudeRepository.findById(medicamentoDAO.getUnidade_saude_id());
        medicamento.setUnidadeSaude(unidadeSaude.get());

        return medicamentoRepository.save(medicamento);
    }

    public Iterable<Medicamento> listarMedicamento() {
        return medicamentoRepository.findAll();
    }


    public void editarMedicamento(Medicamento medicamento) {
        medicamentoRepository.save(medicamento);
    }


    public void deletarMedicamento(long id) {
        medicamentoRepository.deleteById(id);
    }

}

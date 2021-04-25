package br.com.unialfa.sgh.service;

import br.com.unialfa.sgh.DAO.MedicamentoDAO;
import br.com.unialfa.sgh.business.MedicamentoBusiness;
import br.com.unialfa.sgh.domain.Medicamento;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/medicamentos")
public class MedicamentoController {

    final private MedicamentoBusiness medicamentoBusiness;

    public MedicamentoController(MedicamentoBusiness medicamentoBusiness) {
        this.medicamentoBusiness = medicamentoBusiness;
    }

    @PostMapping(path = "/create")
    public void cadastrarMedicamento(@RequestBody MedicamentoDAO medicamentoDAO) {
        medicamentoBusiness.cadastrarMedicamento(medicamentoDAO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Medicamento> listarMedicamento() {
        return medicamentoBusiness.listarMedicamento();
    }

    @PutMapping(path = "/edit")
    public void editarMedicamento(@RequestBody Medicamento medicamento) {
        medicamentoBusiness.editarMedicamento(medicamento);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody
    void deletarMedicamento(@PathVariable(name = "id") long id) {
        medicamentoBusiness.deletarMedicamento(id);
    }

}

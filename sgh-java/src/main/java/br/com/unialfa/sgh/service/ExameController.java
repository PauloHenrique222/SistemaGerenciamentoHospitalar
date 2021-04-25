package br.com.unialfa.sgh.service;

import br.com.unialfa.sgh.DAO.ExameDAO;
import br.com.unialfa.sgh.business.ExameBusiness;
import br.com.unialfa.sgh.domain.Exame;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/exames")
public class ExameController {

    final private ExameBusiness exameBusiness;

    public ExameController(ExameBusiness exameBusiness) {
        this.exameBusiness = exameBusiness;
    }

    @PostMapping(path = "/create")
    public void cadastrarExame(@RequestBody ExameDAO exameDAO) {
        exameBusiness.cadastrarExame(exameDAO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Exame> listarExame() {
        return exameBusiness.listarExame();
    }

    @PutMapping(path = "/edit")
    public void editarExame(@RequestBody Exame exame) {
        exameBusiness.editarExame(exame);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody
    void deletarExame(@PathVariable(name = "id") long id) {
        exameBusiness.deletarExame(id);
    }
}

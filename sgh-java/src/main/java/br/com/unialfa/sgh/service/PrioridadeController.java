package br.com.unialfa.sgh.service;

import br.com.unialfa.sgh.domain.Prioridade;
import br.com.unialfa.sgh.repository.PrioridadeRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/prioridades")
public class PrioridadeController {

    private final PrioridadeRepository prioridadeRepository;

    public PrioridadeController(PrioridadeRepository prioridadeRepository) {
        this.prioridadeRepository = prioridadeRepository;
    }

    @PostMapping(path = "/create")
    public void cadastrarPrioridade(@RequestBody Prioridade prioridade){
        prioridadeRepository.save(prioridade);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Prioridade> listarPrioridade(){
        return prioridadeRepository.findAll();
    }

    @PutMapping(path = "/edit")
    public void editarPrioridade(@RequestBody Prioridade prioridade){
        prioridadeRepository.save(prioridade);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody void deletarPrioridade(@PathVariable(name = "id") long id){
        prioridadeRepository.deleteById(id);
    }

}


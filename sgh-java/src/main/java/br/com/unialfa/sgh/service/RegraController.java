package br.com.unialfa.sgh.service;

import br.com.unialfa.sgh.domain.Regra;
import br.com.unialfa.sgh.repository.RegraRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/regras")
public class RegraController {

    private final RegraRepository regraRepository;

    public RegraController(RegraRepository regraRepository) {
        this.regraRepository = regraRepository;
    }

    @PostMapping(path = "/create")
    public void cadastrarRegra(@RequestBody Regra regra){
        regraRepository.save(regra);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Regra> listarRegra(){
        return regraRepository.findAll();
    }

    @PutMapping(path = "/edit")
    public void editarCargo(@RequestBody Regra regra){
        regraRepository.save(regra);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody void deletarRegra(@PathVariable(name = "id") long id){
        regraRepository.deleteById(id);
    }

}


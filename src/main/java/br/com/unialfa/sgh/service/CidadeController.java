package br.com.unialfa.sgh.service;


import br.com.unialfa.sgh.domain.Cidade;
import br.com.unialfa.sgh.repository.CidadeRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cidades")
public class CidadeController {

    private final CidadeRepository cidadeRepository;

    public CidadeController(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    @PostMapping(path = "/create")
    public void cadastrarCidade(@RequestBody Cidade cidade){
        cidadeRepository.save(cidade);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Cidade> listarCidade(){
        return cidadeRepository.findAll();
    }

    @PutMapping(path = "/edit")
    public void editarCidade(@RequestBody Cidade cidade){
        cidadeRepository.save(cidade);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody void deletarCidade(@PathVariable(name = "id") long id){
        cidadeRepository.deleteById(id);
    }

}

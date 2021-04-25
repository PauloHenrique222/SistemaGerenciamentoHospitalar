package br.com.unialfa.sgh.service;

import br.com.unialfa.sgh.domain.Pais;
import br.com.unialfa.sgh.repository.PaisRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/paises")
public class PaisController {

    private final PaisRepository paisRepository;

    public PaisController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @PostMapping(path = "/create")
    public void cadastrarPais(@RequestBody Pais pais){
        paisRepository.save(pais);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Pais> listarPais(){
        return paisRepository.findAll();
    }

    @PutMapping(path = "/edit")
    public void editarPais(@RequestBody Pais pais){
        paisRepository.save(pais);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody void deletarPais(@PathVariable(name = "id") long id){
        paisRepository.deleteById(id);
    }

}

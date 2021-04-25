package br.com.unialfa.sgh.service;

import br.com.unialfa.sgh.domain.Estado;
import br.com.unialfa.sgh.repository.EstadoRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/estados")
public class EstadoController {

    private final EstadoRepository estadoRepository;

    public EstadoController(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @PostMapping(path = "/create")
    public void cadastrarEstado(@RequestBody Estado estado){
        estadoRepository.save(estado);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Estado> listarEstado(){
        return estadoRepository.findAll();
    }

    @PutMapping(path = "/edit")
    public void editarEstado(@RequestBody Estado estado){
        estadoRepository.save(estado);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody void deletarEstado(@PathVariable(name = "id") long id){
        estadoRepository.deleteById(id);
    }

}

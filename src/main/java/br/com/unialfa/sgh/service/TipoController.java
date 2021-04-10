package br.com.unialfa.sgh.service;

import br.com.unialfa.sgh.domain.Tipo;
import br.com.unialfa.sgh.repository.TipoRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/tipos")
public class TipoController {

    private final TipoRepository tipoRepository;

    public TipoController(TipoRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }

    @PostMapping(path = "/create")
    public void cadastrarTipo(@RequestBody Tipo tipo){
        tipoRepository.save(tipo);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Tipo> listarTipo(){
        return tipoRepository.findAll();
    }

    @PutMapping(path = "/edit")
    public void editarTipo(@RequestBody Tipo tipo){
        tipoRepository.save(tipo);
    }

}

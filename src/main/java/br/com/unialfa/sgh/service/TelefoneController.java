package br.com.unialfa.sgh.service;

import br.com.unialfa.sgh.domain.Telefone;
import br.com.unialfa.sgh.repository.TelefoneRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

public class TelefoneController {

    private final TelefoneRepository telefoneRepository;

    public TelefoneController(TelefoneRepository telefoneRepository) {
        this.telefoneRepository = telefoneRepository;
    }

    @PostMapping(path = "/create")
    public void cadastrarTelefone(@RequestBody Telefone telefone){
        telefoneRepository.save(telefone);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Telefone> listarTelefone(){
        return telefoneRepository.findAll();
    }

    @PutMapping(path = "/edit")
    public void editarTelefone(@RequestBody Telefone telefone){
        telefoneRepository.save(telefone);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody void deletarTelefone(@PathVariable(name = "id") long id){
        telefoneRepository.deleteById(id);
    }
}

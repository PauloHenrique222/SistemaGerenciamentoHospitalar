package br.com.unialfa.sgh.service;

import br.com.unialfa.sgh.domain.Departamento;



import br.com.unialfa.sgh.repository.DepartamentoRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/departamentos")
public class DepartamentoController {

    private final DepartamentoRepository departamentoRepository;

    public DepartamentoController(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    @PostMapping(path = "/create")
    public void cadastrarDepartamento(@RequestBody Departamento departamento){
        departamentoRepository.save(departamento);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Departamento> listarDepartamento(){
        return departamentoRepository.findAll();
    }

    @PutMapping(path = "/edit")
    public void editarDepartamento(@RequestBody Departamento departamento){
        departamentoRepository.save(departamento);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody void deletarDepartamento(@PathVariable(name = "id") long id){
        departamentoRepository.deleteById(id);
    }

}

package br.com.unialfa.sgh.service;

import br.com.unialfa.sgh.domain.Cargo;
import br.com.unialfa.sgh.repository.CargoRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cargos")
public class CargoController {

    private final CargoRepository cargoRepository;

    public CargoController(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @PostMapping(path = "/create")
    public void cadastrarCargo(@RequestBody Cargo cargo){
        cargoRepository.save(cargo);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Cargo> listarCargo(){
        return cargoRepository.findAll();
    }

    @PutMapping(path = "/edit")
    public void editarCargo(@RequestBody Cargo cargo){
        cargoRepository.save(cargo);
    }

    @DeleteMapping(value = "/delete/{id}")
    public @ResponseBody void deletarCargo(@PathVariable(name = "id") long id){
        cargoRepository.deleteById(id);
    }

}

package br.com.unialfa.sgh.service;

import br.com.unialfa.sgh.DAO.UnidadeSaudeDAO;
import br.com.unialfa.sgh.business.UnidadeSaudeBusiness;
import br.com.unialfa.sgh.domain.UnidadeSaude;
import br.com.unialfa.sgh.repository.UnidadeSaudeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/unidades")
public class UnidadeSaudeController {

    private final UnidadeSaudeBusiness unidadeSaudeBusiness;
    private final UnidadeSaudeRepository unidadeSaudeRepository;

    public UnidadeSaudeController(UnidadeSaudeBusiness unidadeSaudeBusiness, UnidadeSaudeRepository unidadeSaudeRepository) {
        this.unidadeSaudeBusiness = unidadeSaudeBusiness;
        this.unidadeSaudeRepository = unidadeSaudeRepository;
    }

    @PostMapping(path = "/create")
    public void cadastrarUnidadeSaude(@RequestBody UnidadeSaudeDAO unidadeSaudeDAO){
        unidadeSaudeBusiness.cadastrarUnidadeSaude(unidadeSaudeDAO);
    }


    @GetMapping(value = "/listar/{usuarioId}")
    public ResponseEntity<?> listarUnidadePorUsuarioId(@PathVariable(name = "usuarioId") long usuarioId){
        try {
            return new ResponseEntity<>(unidadeSaudeBusiness.listarUnidades(usuarioId), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "/edit")
    public void editarUnidadeSaude(@RequestBody UnidadeSaude unidadeSaude) {
        unidadeSaudeBusiness.editarUnidadeSaude(unidadeSaude);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> bucarUnidadePorId(@PathVariable(name = "id") long id){
        try {
            return new ResponseEntity<>(unidadeSaudeRepository.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deletarUnidade(@PathVariable(name = "id") long id){
        try {
            unidadeSaudeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }
}

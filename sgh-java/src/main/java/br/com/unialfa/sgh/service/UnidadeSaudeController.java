package br.com.unialfa.sgh.service;

import br.com.unialfa.sgh.DAO.UnidadeSaudeDAO;
import br.com.unialfa.sgh.business.UnidadeSaudeBusiness;
import br.com.unialfa.sgh.domain.UnidadeSaude;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/unidades")
public class UnidadeSaudeController {

    private final UnidadeSaudeBusiness unidadeSaudeBusiness;

    public UnidadeSaudeController(UnidadeSaudeBusiness unidadeSaudeBusiness) {
        this.unidadeSaudeBusiness = unidadeSaudeBusiness;
    }

    @PostMapping(path = "/create")
    public void cadastrarUnidadeSaude(@RequestBody UnidadeSaudeDAO unidadeSaudeDAO){
        unidadeSaudeBusiness.cadastrarUnidadeSaude(unidadeSaudeDAO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listarUnidades(){
        try {
            return new ResponseEntity<>(unidadeSaudeBusiness.listarUnidades(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "/edit")
    public void editarUnidadeSaude(@RequestBody UnidadeSaude unidadeSaude) {
        unidadeSaudeBusiness.editarUnidadeSaude(unidadeSaude);
    }
}

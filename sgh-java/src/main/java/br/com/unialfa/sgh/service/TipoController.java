package br.com.unialfa.sgh.service;

import br.com.unialfa.sgh.domain.Tipo;
import br.com.unialfa.sgh.repository.TipoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/tipos")
public class TipoController {

    private final TipoRepository tipoRepository;

    public TipoController(TipoRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }

    @GetMapping(value = "listar/{usuario_id}")
    public ResponseEntity<?> bucarTipoPorUsuarioId(@PathVariable(name = "usuario_id") long usuarioId){
        try {
            return new ResponseEntity<>(tipoRepository.findByUsuarioId(usuarioId), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> bucarTipoPorId(@PathVariable(name = "id") long id){
        try {
            return new ResponseEntity<>(tipoRepository.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> cadastrarTipo(@RequestBody Tipo tipo){
        try {
            return new ResponseEntity<>(tipoRepository.save(tipo), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "/edit")
    public ResponseEntity<?> editarTipo(@RequestBody Tipo tipo){
        try {
            return new ResponseEntity<>(tipoRepository.save(tipo), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deletarTipo(@PathVariable(name = "id") long id){
        try {
            tipoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }
}

package br.com.unialfa.sgh.service;

import br.com.unialfa.sgh.DAO.UsuarioDAO;
import br.com.unialfa.sgh.domain.Usuario;
import br.com.unialfa.sgh.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UsuarioController {

    private final UserRepository userRepository;

    public UsuarioController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping(value = "/login")
    public ResponseEntity<?> bucarTipoPorId(@RequestBody UsuarioDAO usuarioDAO){
        try {
            Usuario usuario = userRepository.findByEmail(usuarioDAO.getEmail());
            if(usuario.getPassword().equals(usuarioDAO.getPassword())){
                return new ResponseEntity<>(usuario, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/create")
    public ResponseEntity<?> cadastrarTipo(@RequestBody Usuario usuario){
        try {
            if(usuario.getPassword().equals(usuario.getPasswordConfirmation())){
                return new ResponseEntity<>(userRepository.save(usuario), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "/edit")
    public ResponseEntity<?> editarTipo(@RequestBody Usuario usuario){
        try {
            return new ResponseEntity<>(userRepository.save(usuario), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }
}

package br.com.unialfa.sgh.service;

import br.com.unialfa.sgh.business.EnderecoBusiness;
import br.com.unialfa.sgh.domain.Endereco;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/enderecos")
public class EnderecoController {

    final EnderecoBusiness enderecoBusiness;

    public EnderecoController(EnderecoBusiness enderecoBusiness) {
        this.enderecoBusiness = enderecoBusiness;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Endereco> listarEnderecos(){
        return enderecoBusiness.listarEnderecos();
    }

    @PutMapping(path = "/edit")
    public void editarEndereco(@RequestBody Endereco endereco){
        enderecoBusiness.editarEndereco(endereco);
    }
}

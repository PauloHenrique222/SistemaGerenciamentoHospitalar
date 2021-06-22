package br.com.unialfa.sgh.service;

import br.com.unialfa.sgh.domain.Endereco;
import br.com.unialfa.sgh.repository.EnderecoRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/enderecos")
public class EnderecoController {

    final EnderecoRepository enderecoRepository;

    public EnderecoController(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Endereco> listarEnderecos(){
        return enderecoRepository.findAll();
    }

    @PutMapping(path = "/edit")
    public void editarEndereco(@RequestBody Endereco endereco){
        enderecoRepository.save(endereco);
    }
}

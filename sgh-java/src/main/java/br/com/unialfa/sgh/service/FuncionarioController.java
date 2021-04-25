package br.com.unialfa.sgh.service;

import br.com.unialfa.sgh.DAO.FuncionarioDAO;
import br.com.unialfa.sgh.business.FuncionarioBusiness;
import br.com.unialfa.sgh.domain.Funcionario;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/funcionarios")
public class FuncionarioController {

    final FuncionarioBusiness funcionarioBusiness;

    public FuncionarioController(FuncionarioBusiness funcionarioBusiness) {
        this.funcionarioBusiness = funcionarioBusiness;
    }

    @PostMapping(path = "/create")
    public void cadastrarFuncionario(@RequestBody FuncionarioDAO funcionarioDAO){
        funcionarioBusiness.cadastrarFuncionario(funcionarioDAO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Funcionario> listarUnidades(){
        return funcionarioBusiness.listarUnidades();
    }

    @PutMapping(path = "/edit")
    public void editarUnidadeSaude(@RequestBody Funcionario funcionario) {
        funcionarioBusiness.editarUnidadeSaude(funcionario);
    }

}

package br.com.unialfa.sgh.service;

import br.com.unialfa.sgh.DAO.FichaAtendimentoDAO;
import br.com.unialfa.sgh.business.FichaAtendimentoBusiness;
import br.com.unialfa.sgh.domain.FichaAtendimento;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/fichas")
public class FichaAtendimentoController {

    private final FichaAtendimentoBusiness fichaAtendimentoBusiness;

    public FichaAtendimentoController(FichaAtendimentoBusiness fichaAtendimentoBusiness) {
        this.fichaAtendimentoBusiness = fichaAtendimentoBusiness;
    }

    @PostMapping(path = "/create")
    public void cadastrarFichaAtendimento(@RequestBody FichaAtendimentoDAO fichaAtendimentoDAO){
        fichaAtendimentoBusiness.cadastrarFichaAtendimento(fichaAtendimentoDAO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<FichaAtendimento> listarFichas(){
        return fichaAtendimentoBusiness.listarFichas();
    }

    @PutMapping(path = "/edit")
    public void editarFicha(@RequestBody FichaAtendimentoDAO fichaAtendimentoDAO) {
        fichaAtendimentoBusiness.editarFicha(fichaAtendimentoDAO);
    }

}

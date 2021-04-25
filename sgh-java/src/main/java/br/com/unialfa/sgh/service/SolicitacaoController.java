package br.com.unialfa.sgh.service;

import br.com.unialfa.sgh.DAO.SolicitacaoDAO;
import br.com.unialfa.sgh.business.SolicitacaoBusiness;
import br.com.unialfa.sgh.domain.Solicitacao;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/solicitacoes")
public class SolicitacaoController {

    private final SolicitacaoBusiness solicitacaoBusiness;

    public SolicitacaoController(SolicitacaoBusiness solicitacaoBusiness) {
        this.solicitacaoBusiness = solicitacaoBusiness;
    }

    @PostMapping(path = "/create")
    public void cadastrarSolicitacao(@RequestBody SolicitacaoDAO solicitacaoDAO){
        solicitacaoBusiness.cadastrarSolicitacao(solicitacaoDAO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Solicitacao> listarSolicitacao(){
        return solicitacaoBusiness.listarSolicitacao();
    }

    @PutMapping(path = "/edit")
    public void editarSolicitacao(@RequestBody Solicitacao solicitacao) {
        solicitacaoBusiness.editarSolicitacao(solicitacao);
    }
}

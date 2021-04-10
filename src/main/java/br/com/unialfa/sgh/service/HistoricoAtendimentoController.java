package br.com.unialfa.sgh.service;

import br.com.unialfa.sgh.DAO.HistoricoAtendimentoDAO;
import br.com.unialfa.sgh.business.HistoricoAtendimentoBusiness;
import br.com.unialfa.sgh.domain.HistoricoAtendimento;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/historicos")
public class HistoricoAtendimentoController {
    private final HistoricoAtendimentoBusiness historicoAtendimentoBusiness;

    public HistoricoAtendimentoController(HistoricoAtendimentoBusiness historicoAtendimentoBusiness) {
        this.historicoAtendimentoBusiness = historicoAtendimentoBusiness;
    }

    @PostMapping(path = "/create")
    public void cadastrarHistoricoAtendimento(@RequestBody HistoricoAtendimentoDAO historicoAtendimentoDAO){
        historicoAtendimentoBusiness.cadastrarHistoricoAtendimento(historicoAtendimentoDAO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<HistoricoAtendimento> listarFichas(){
        return historicoAtendimentoBusiness.listarHistoricos();
    }

    @PutMapping(path = "/edit")
    public void editarHistorico(@RequestBody HistoricoAtendimento historicoAtendimento) {
        historicoAtendimentoBusiness.editarHistoricos(historicoAtendimento);
    }

}

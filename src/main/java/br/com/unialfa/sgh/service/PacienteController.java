package br.com.unialfa.sgh.service;

import br.com.unialfa.sgh.DAO.PacienteDAO;
import br.com.unialfa.sgh.business.PacienteBusiness;
import br.com.unialfa.sgh.domain.Paciente;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/pacientes")
public class PacienteController {

    private final PacienteBusiness pacienteBusiness;

    public PacienteController(PacienteBusiness pacienteBusiness) {
        this.pacienteBusiness = pacienteBusiness;
    }

    @PostMapping(path = "/create")
    public void cadastrarPaciente(@RequestBody PacienteDAO pacienteDAO){
        pacienteBusiness.cadastrarPaciente(pacienteDAO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Paciente> listarPacientes(){
        return pacienteBusiness.listarPacientes();
    }

    @PutMapping(path = "/edit")
    public void editarUnidadeSaude(@RequestBody Paciente paciente) {
        pacienteBusiness.editarPaciente(paciente);
    }
}

package br.com.unialfa.sgh.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class FichaAtendimento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDateTime horarioEntrada;
    private String sintomas;
    private LocalDateTime horarioSaida;
    private String observacao;

    @OneToMany(mappedBy = "fichaAtendimento")
    private List<Solicitacao> solicitacaos;

    @OneToMany(mappedBy = "fichaAtendimento")
    private List<HistoricoAtendimento> historicoAtendimentos;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="unidade_saude_id")
    private UnidadeSaude unidadeSaude;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="paciente_id")
    private Paciente paciente;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="prioridade_id")
    private Prioridade prioridade;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="funcionario_id")
    private Funcionario funcionario;

    public FichaAtendimento() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(LocalDateTime horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public LocalDateTime getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(LocalDateTime horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<Solicitacao> getSolicitacaos() {
        return solicitacaos;
    }

    public void setSolicitacaos(List<Solicitacao> solicitacaos) {
        this.solicitacaos = solicitacaos;
    }

    public List<HistoricoAtendimento> getHistoricoAtendimentos() {
        return historicoAtendimentos;
    }

    public void setHistoricoAtendimentos(List<HistoricoAtendimento> historicoAtendimentos) {
        this.historicoAtendimentos = historicoAtendimentos;
    }

    public UnidadeSaude getUnidadeSaude() {
        return unidadeSaude;
    }

    public void setUnidadeSaude(UnidadeSaude unidadeSaude) {
        this.unidadeSaude = unidadeSaude;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}


package br.com.unialfa.sgh.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Solicitacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String observacao;
    private boolean concluida;
    private LocalDateTime data;

    @ManyToMany
    @JoinTable(
            name = "solicitacao_medicamento",
            joinColumns = @JoinColumn(name = "medicamento_id"),
            inverseJoinColumns = @JoinColumn(name = "solicitacao_id"))
    private List<Medicamento> solicitacaoMedicamentos;

    @ManyToMany
    @JoinTable(
            name = "solicitacao_exame",
            joinColumns = @JoinColumn(name = "exame_id"),
            inverseJoinColumns = @JoinColumn(name = "solicitacao_id"))
    private List<Exame> solicitacaoExames;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="ficha_atendimento_id")
    private FichaAtendimento fichaAtendimento;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="funcionario_id")
    private Funcionario funcionario;


    public Solicitacao() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public List<Medicamento> getSolicitacaoMedicamentos() {
        return solicitacaoMedicamentos;
    }

    public void setSolicitacaoMedicamentos(List<Medicamento> solicitacaoMedicamentos) {
        this.solicitacaoMedicamentos = solicitacaoMedicamentos;
    }

    public List<Exame> getSolicitacaoExames() {
        return solicitacaoExames;
    }

    public void setSolicitacaoExames(List<Exame> solicitacaoExames) {
        this.solicitacaoExames = solicitacaoExames;
    }

    public FichaAtendimento getFichaAtendimento() {
        return fichaAtendimento;
    }

    public void setFichaAtendimento(FichaAtendimento fichaAtendimento) {
        this.fichaAtendimento = fichaAtendimento;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}

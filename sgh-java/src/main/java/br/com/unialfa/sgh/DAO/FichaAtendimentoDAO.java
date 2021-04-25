package br.com.unialfa.sgh.DAO;

import java.time.LocalDate;

public class FichaAtendimentoDAO {

    private String sintomas;
    private String observacao;
    private long paciente_id;
    private long unidade_saude_id;
    private long funcionario_id;
    private long prioridade_id;

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public long getPaciente_id() {
        return paciente_id;
    }

    public void setPaciente_id(long paciente_id) {
        this.paciente_id = paciente_id;
    }

    public long getUnidade_saude_id() {
        return unidade_saude_id;
    }

    public void setUnidade_saude_id(long unidade_saude_id) {
        this.unidade_saude_id = unidade_saude_id;
    }

    public long getFuncionario_id() {
        return funcionario_id;
    }

    public void setFuncionario_id(long funcionario_id) {
        this.funcionario_id = funcionario_id;
    }

    public long getPrioridade_id() {
        return prioridade_id;
    }

    public void setPrioridade_id(long prioridade_id) {
        this.prioridade_id = prioridade_id;
    }
}

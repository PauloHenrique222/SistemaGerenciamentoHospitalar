package br.com.unialfa.sgh.DAO;

import java.util.List;

public class SolicitacaoDAO {

    private String observacao;
    private List<Long> medicamento_id;
    private List<Long> exame_id;
    private long ficha_atendimento_id;
    private long funcionario_id;

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<Long> getMedicamento_id() {
        return medicamento_id;
    }

    public void setMedicamento_id(List<Long> medicamento_id) {
        this.medicamento_id = medicamento_id;
    }

    public List<Long> getExame_id() {
        return exame_id;
    }

    public void setExame_id(List<Long> exame_id) {
        this.exame_id = exame_id;
    }

    public long getFuncionario_id() {
        return funcionario_id;
    }

    public long getFicha_atendimento_id() {
        return ficha_atendimento_id;
    }

    public void setFicha_atendimento_id(long ficha_atendimento_id) {
        this.ficha_atendimento_id = ficha_atendimento_id;
    }

    public void setFuncionario_id(long funcionario_id) {
        this.funcionario_id = funcionario_id;
    }
}

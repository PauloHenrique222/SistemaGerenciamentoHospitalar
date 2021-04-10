package br.com.unialfa.sgh.DAO;

public class HistoricoAtendimentoDAO {

    private String observacao;
    private long ficha_atendimento_id;
    private long funcionario_id;

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public long getFicha_atendimento_id() {
        return ficha_atendimento_id;
    }

    public void setFicha_atendimento_id(long ficha_atendimento_id) {
        this.ficha_atendimento_id = ficha_atendimento_id;
    }

    public long getFuncionario_id() {
        return funcionario_id;
    }

    public void setFuncionario_id(long funcionario_id) {
        this.funcionario_id = funcionario_id;
    }
}

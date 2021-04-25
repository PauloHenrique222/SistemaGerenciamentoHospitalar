package br.com.unialfa.sgh.DAO;

public class ExameDAO {

    private String nome;
    private String descricao;
    private long unidade_saude_id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getUnidade_saude_id() {
        return unidade_saude_id;
    }

    public void setUnidade_saude_id(long unidade_saude_id) {
        this.unidade_saude_id = unidade_saude_id;
    }
}

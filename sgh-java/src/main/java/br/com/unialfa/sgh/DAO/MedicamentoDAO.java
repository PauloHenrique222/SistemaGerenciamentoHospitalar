package br.com.unialfa.sgh.DAO;

import java.util.Date;

public class MedicamentoDAO {
    private String nome;
    private String lote;
    private String fabricante;
    private Date dataValidade;
    private int quantidade;
    private long unidade_saude_id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public long getUnidade_saude_id() {
        return unidade_saude_id;
    }

    public void setUnidade_saude_id(long unidade_saude_id) {
        this.unidade_saude_id = unidade_saude_id;
    }
}

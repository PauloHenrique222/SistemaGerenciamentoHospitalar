package br.com.unialfa.sgh.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Medicamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private String lote;
    private String fabricante;
    private Date dataValidade;
    private int quantidade;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="unidade_saude_id")
    private UnidadeSaude unidadeSaude;

    @JsonIgnore
    @ManyToMany(mappedBy = "solicitacaoMedicamentos")
    private List<Solicitacao> solicitacaos;


    public Medicamento() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public UnidadeSaude getUnidadeSaude() {
        return unidadeSaude;
    }

    public void setUnidadeSaude(UnidadeSaude unidadeSaude) {
        this.unidadeSaude = unidadeSaude;
    }

    public List<Solicitacao> getSolicitacaos() {
        return solicitacaos;
    }

    public void setSolicitacaos(List<Solicitacao> solicitacaos) {
        this.solicitacaos = solicitacaos;
    }
}

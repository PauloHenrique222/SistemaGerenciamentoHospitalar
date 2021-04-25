package br.com.unialfa.sgh.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Exame implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private String descricao;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="unidade_saude_id")
    private UnidadeSaude unidadeSaude;

    @JsonIgnore
    @ManyToMany(mappedBy = "solicitacaoExames")
    private List<Solicitacao> solicitacaos;


    public Exame() {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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


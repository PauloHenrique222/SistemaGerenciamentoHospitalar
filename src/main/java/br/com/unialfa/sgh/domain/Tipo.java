package br.com.unialfa.sgh.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Tipo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;

    @OneToMany(mappedBy = "tipo")
    private List<UnidadeSaude> unidadeSaudes;

    public Tipo() {
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

    public List<UnidadeSaude> getUnidadeSaudes() {
        return unidadeSaudes;
    }

    public void setUnidadeSaudes(List<UnidadeSaude> unidadeSaudes) {
        this.unidadeSaudes = unidadeSaudes;
    }
}


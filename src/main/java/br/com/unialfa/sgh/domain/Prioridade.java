package br.com.unialfa.sgh.domain;


import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Prioridade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;

    @OneToMany(mappedBy = "prioridade")
    private List<FichaAtendimento> fichaAtendimentos;

    public Prioridade() {
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

    public List<FichaAtendimento> getFichaAtendimentos() {
        return fichaAtendimentos;
    }

    public void setFichaAtendimentos(List<FichaAtendimento> fichaAtendimentos) {
        this.fichaAtendimentos = fichaAtendimentos;
    }
}

package br.com.unialfa.sgh.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Paciente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    @Column(unique = true, nullable = false)
    private String cpf;
    @Column(unique = true, nullable = false)
    private String rg;

    @OneToMany(mappedBy = "paciente")
    private List<FichaAtendimento> fichaAtendimentos;

    @OneToOne(cascade=CascadeType.ALL)
    private Endereco endereco;

    public Paciente() {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public List<FichaAtendimento> getFichaAtendimentos() {
        return fichaAtendimentos;
    }

    public void setFichaAtendimentos(List<FichaAtendimento> fichaAtendimentos) {
        this.fichaAtendimentos = fichaAtendimentos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}


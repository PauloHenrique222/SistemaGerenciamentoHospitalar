package br.com.unialfa.sgh.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class UnidadeSaude implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;

    @Column(unique = true, nullable = false)
    private String numeroRegistro;

    @JsonIgnore
    @OneToMany(mappedBy = "unidadeSaude")
    private List<Medicamento> medicamentos;

    @JsonIgnore
    @OneToMany(mappedBy = "unidadeSaude")
    private List<Exame> exames;

    @JsonIgnore
    @OneToMany(mappedBy = "unidadeSaude")
    private List<Telefone> telefones;

    @JsonIgnore
    @OneToMany(mappedBy = "unidadeSaude")
    private List<FichaAtendimento> fichaAtendimentos;

    @JsonIgnore
    @OneToMany(mappedBy = "unidadeSaude")
    private List<Funcionario> funcionarios;

    @JsonIgnore
    @OneToOne(cascade=CascadeType.ALL)
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name="tipo_id")
    private Tipo tipo;

    public UnidadeSaude() {
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

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(String numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public List<Exame> getExames() {
        return exames;
    }

    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<FichaAtendimento> getFichaAtendimentos() {
        return fichaAtendimentos;
    }

    public void setFichaAtendimentos(List<FichaAtendimento> fichaAtendimentos) {
        this.fichaAtendimentos = fichaAtendimentos;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}

package br.com.unialfa.sgh.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private String sobrenome;
    private int numeroConcelho;
    private BigDecimal salario;
    private boolean ativo;
    private String email;
    private String senha;
    private boolean coordenador;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="unidade_saude_id")
    private UnidadeSaude unidadeSaude;

    @OneToMany(mappedBy = "funcionario")
    private List<Solicitacao> solicitacaos;

    @OneToMany(mappedBy = "funcionario")
    private List<FichaAtendimento> fichaAtendimentos;

    @OneToMany(mappedBy = "funcionario")
    private List<HistoricoAtendimento> historicoAtendimentos;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="departamento_id")
    private Departamento departamento;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="regra_id")
    private Regra regra;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="cargo_id")
    private Cargo cargo;

    @OneToOne(cascade=CascadeType.ALL)
    private Endereco endereco;

    @OneToMany(mappedBy = "funcionario")
    private List<Telefone> telefones;

    public Funcionario() {
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getNumeroConcelho() {
        return numeroConcelho;
    }

    public void setNumeroConcelho(int numeroConcelho) {
        this.numeroConcelho = numeroConcelho;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isCoordenador() {
        return coordenador;
    }

    public void setCoordenador(boolean coordenador) {
        this.coordenador = coordenador;
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

    public List<FichaAtendimento> getFichaAtendimentos() {
        return fichaAtendimentos;
    }

    public void setFichaAtendimentos(List<FichaAtendimento> fichaAtendimentos) {
        this.fichaAtendimentos = fichaAtendimentos;
    }

    public List<HistoricoAtendimento> getHistoricoAtendimentos() {
        return historicoAtendimentos;
    }

    public void setHistoricoAtendimentos(List<HistoricoAtendimento> historicoAtendimentos) {
        this.historicoAtendimentos = historicoAtendimentos;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Regra getRegra() {
        return regra;
    }

    public void setRegra(Regra regra) {
        this.regra = regra;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
}


package br.com.unialfa.sgh.DAO;

import br.com.unialfa.sgh.domain.Endereco;

import java.math.BigDecimal;

public class FuncionarioDAO {

    private String nome;
    private String sobrenome;
    private int numeroConcelho;
    private BigDecimal salario;
    private boolean ativo;
    private String email;
    private String senha;
    private boolean coordenador;
    private long unidade_saude_id;
    private long cargo_id;
    private long regra_id;
    private long departamento_id;
    private Endereco endereco;

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

    public long getUnidade_saude_id() {
        return unidade_saude_id;
    }

    public void setUnidade_saude_id(long unidade_saude_id) {
        this.unidade_saude_id = unidade_saude_id;
    }

    public long getCargo_id() {
        return cargo_id;
    }

    public void setCargo_id(long cargo_id) {
        this.cargo_id = cargo_id;
    }

    public long getRegra_id() {
        return regra_id;
    }

    public void setRegra_id(long regra_id) {
        this.regra_id = regra_id;
    }

    public long getDepartamento_id() {
        return departamento_id;
    }

    public void setDepartamento_id(long departamento_id) {
        this.departamento_id = departamento_id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}

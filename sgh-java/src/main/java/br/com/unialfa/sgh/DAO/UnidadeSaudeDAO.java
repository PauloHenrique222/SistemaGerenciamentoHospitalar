package br.com.unialfa.sgh.DAO;

public class UnidadeSaudeDAO {
    private long id;
    private String nome;
    private long tipo_id;
    private String numeroRegistro;
    private EnderecoDAO enderecoDAO;

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

    public long getTipo_id() {
        return tipo_id;
    }

    public void setTipo_id(long tipo_id) {
        this.tipo_id = tipo_id;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(String numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public EnderecoDAO getEnderecoDAO() {
        return enderecoDAO;
    }

    public void setEnderecoDAO(EnderecoDAO enderecoDAO) {
        this.enderecoDAO = enderecoDAO;
    }
}

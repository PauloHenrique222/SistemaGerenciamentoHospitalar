package br.com.unialfa.sgh.DAO;

public class EnderecoDAO {
    private String rua;
    private String cep;
    private String complemento;
    private String setor;
    private int numero;
    private long pais_id;
    private long estado_id;
    private long cidade_id;

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public long getPais_id() {
        return pais_id;
    }

    public void setPais_id(long pais_id) {
        this.pais_id = pais_id;
    }

    public long getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(long estado_id) {
        this.estado_id = estado_id;
    }

    public long getCidade_id() {
        return cidade_id;
    }

    public void setCidade_id(long cidade_id) {
        this.cidade_id = cidade_id;
    }
}

package modelo;

import java.sql.Date;

public class Cliente {
    private int id;
    private String nome;
    private String email;
    private long telefone;
    private Date dtnasc;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public long getTelefone() {
        return telefone;
    }
    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
    public Date getDtnasc() {
        return dtnasc;
    }
    public void setDtnasc(Date dtnasc) {
        this.dtnasc = dtnasc;
    }
}

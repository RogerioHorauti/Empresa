package br.edu.impacta.ads.aps.jdbc.model;

import java.io.Serializable;

public class Cargo implements Serializable{
   
    private Integer codigo;
    private String nome;

    public Cargo() {
    }

    public Cargo(Integer codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
   
    public int getCodigo() {
        return codigo;
    }
 
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}

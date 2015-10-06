package br.edu.impacta.ads.aps.jdbc.model;

import java.io.Serializable;

public class Departamento implements Serializable{
    
    private Integer codigo;
    private String nome;
    
    public Departamento() {
    }
 
    public Departamento(Integer codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}

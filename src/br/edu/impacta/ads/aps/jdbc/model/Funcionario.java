package br.edu.impacta.ads.aps.jdbc.model;

import java.io.Serializable;
import java.util.Calendar;

public class Funcionario implements Serializable{
    
    private Integer codigo;
    private String nome;
    private Cargo cargo;
    private Departamento departamento;
    private Calendar dataDeContratacao;
    
    public Funcionario() {
    }

    public Funcionario(Integer codigo, String nome, Cargo cargo, Departamento departamento) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.departamento = departamento;
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

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Calendar getDataDeContratacao() {
        return dataDeContratacao;
    }

    public void setDataDeContratacao(Calendar dataDeContratacao) {
        this.dataDeContratacao = dataDeContratacao;
    }
   
    
}

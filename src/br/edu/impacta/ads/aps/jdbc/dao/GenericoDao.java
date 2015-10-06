package br.edu.impacta.ads.aps.jdbc.dao;

import java.util.List;

public interface GenericoDao <E>{
    public boolean inserir(E e);
    public boolean alterar(E e);
    public boolean deletar(E e);
    public List<E> listar();
}

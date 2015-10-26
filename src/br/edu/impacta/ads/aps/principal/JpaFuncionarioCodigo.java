package br.edu.impacta.ads.aps.principal;

import br.edu.impacta.ads.aps.jpa.dao.FuncionarioDao;
import br.edu.impacta.ads.aps.jpa.model.Funcionario;

public class JpaFuncionarioCodigo {
    public static void main(String[] args) {
        Integer codigo = Integer.parseInt("5");
        Funcionario func = new FuncionarioDao().id(codigo);
        System.out.println(func.getCodigo()+" "+func.getNome());
    }
}

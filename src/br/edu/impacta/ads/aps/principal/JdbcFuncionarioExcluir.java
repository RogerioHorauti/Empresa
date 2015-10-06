package br.edu.impacta.ads.aps.principal;

import br.edu.impacta.ads.aps.jdbc.dao.FuncionarioDao;
import br.edu.impacta.ads.aps.jdbc.model.Funcionario;

public class JdbcFuncionarioExcluir {
    
    public static void main(String[] args) {
        
        Funcionario f = new Funcionario();       
        f.setCodigo(1042);
        FuncionarioDao dao = new FuncionarioDao();
        dao.deletar(f);
    }
    
}

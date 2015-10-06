package br.edu.impacta.ads.aps.principal;

import br.edu.impacta.ads.aps.jdbc.dao.FuncionarioDao;
import br.edu.impacta.ads.aps.jdbc.model.Funcionario;
import java.util.List;

public class JdbcFuncionarioListar {
    public static void main(String[] args) {       
        
        FuncionarioDao dao = new FuncionarioDao();
        List<Funcionario> funcionarios = dao.listar();
        for (Funcionario func : funcionarios) {
            System.out.println(func.getCodigo() + " " +func.getNome());
            System.out.println("\t" + func.getDepartamento().getCodigo()+" "+func.getDepartamento().getNome());
            System.out.println("\t"+func.getCargo().getCodigo()+" "+func.getCargo().getNome());
        }
    }
}

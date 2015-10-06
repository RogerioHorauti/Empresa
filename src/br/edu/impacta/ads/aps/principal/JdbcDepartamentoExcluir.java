package br.edu.impacta.ads.aps.principal;
import br.edu.impacta.ads.aps.jdbc.dao.DepartamentoDao;
import br.edu.impacta.ads.aps.jdbc.model.Departamento;

public class JdbcDepartamentoExcluir {
    
     public static void main(String[] args) {
        
        Departamento dep = new Departamento();
        dep.setCodigo(10);       
        DepartamentoDao dao = new DepartamentoDao();        
        if(dao.deletar(dep) != true){           
            System.out.println("Não foi possivel excluir");
        }else{
            System.out.println("cargo excluido com sucesso!");
        }
    }    
    
}

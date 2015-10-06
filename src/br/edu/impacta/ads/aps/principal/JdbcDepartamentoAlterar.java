package br.edu.impacta.ads.aps.principal;
import br.edu.impacta.ads.aps.jdbc.dao.DepartamentoDao;
import br.edu.impacta.ads.aps.jdbc.model.Departamento;

public class JdbcDepartamentoAlterar {
    public static void main(String[] args) {
        
        Departamento dep = new Departamento();
        dep.setCodigo(10);
        dep.setNome("TI");       
        DepartamentoDao dao = new DepartamentoDao();      
        if(dao.alterar(dep) != true){
            System.out.println("Não foi possivel alterar");
        }else{
            System.out.println("alterado com sucesso!");
        }
    }
    
}

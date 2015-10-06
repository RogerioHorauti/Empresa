package br.edu.impacta.ads.aps.principal;
import br.edu.impacta.ads.aps.jdbc.dao.DepartamentoDao;
import br.edu.impacta.ads.aps.jdbc.model.Departamento;

public class JdbcDepartamentoInserir {
    
    public static void main(String[] args) {
        
        Departamento dep = new Departamento();
        dep.setNome("ti");       
        DepartamentoDao dao = new DepartamentoDao();       
        if(dao.inserir(dep)!=true){
            System.out.println("Não foi possivel inserir o cargo");
        }else{
            System.out.println("Cargo inserido com sucesso");
        }
    
    }
}
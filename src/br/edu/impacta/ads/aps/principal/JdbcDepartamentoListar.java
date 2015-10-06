package br.edu.impacta.ads.aps.principal;
import br.edu.impacta.ads.aps.jdbc.dao.DepartamentoDao;
import br.edu.impacta.ads.aps.jdbc.model.Departamento;
import java.util.List;

public class JdbcDepartamentoListar {
    public static void main(String[] args) {
         DepartamentoDao dao = new DepartamentoDao();
	List<Departamento> deps = dao.listar();
				
       for (Departamento dep : deps) {
            System.out.print(dep.getCodigo()+" - "+dep.getNome()+"\n");
       }
    }
}

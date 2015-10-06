package br.edu.impacta.ads.aps.principal;

import br.edu.impacta.ads.aps.jdbc.dao.CargoDao;
import br.edu.impacta.ads.aps.jdbc.model.Cargo;
import java.util.List;

public class JdbcCargoListar {
    public static void main(String[] args) {
        CargoDao dao = new CargoDao();
	List<Cargo> cargos = dao.listar();
				
       for (Cargo cargo : cargos) {
            System.out.print(cargo.getCodigo()+" - "+cargo.getNome()+"\n");
       }
    }
}

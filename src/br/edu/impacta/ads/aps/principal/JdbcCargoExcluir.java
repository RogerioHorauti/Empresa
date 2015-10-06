package br.edu.impacta.ads.aps.principal;

import br.edu.impacta.ads.aps.jdbc.dao.CargoDao;
import br.edu.impacta.ads.aps.jdbc.model.Cargo;

public class JdbcCargoExcluir {
    public static void main(String[] args) {
        
        Cargo cargo = new Cargo();
        cargo.setCodigo(14);        
        CargoDao dao = new CargoDao();        
        if(dao.deletar(cargo) != true){           
            System.out.println("Não foi possivel excluir");
        }else{
            System.out.println("cargo excluido com sucesso!");
        }
    }    
}

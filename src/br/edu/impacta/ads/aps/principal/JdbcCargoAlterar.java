package br.edu.impacta.ads.aps.principal;

import br.edu.impacta.ads.aps.jdbc.dao.CargoDao;
import br.edu.impacta.ads.aps.jdbc.model.Cargo;

public class JdbcCargoAlterar {
    public static void main(String[] args) {
        Cargo cargo = new Cargo();
        cargo.setCodigo(14);
        cargo.setNome("ARQUITETO");        
        CargoDao dao = new CargoDao();       
        if(dao.alterar(cargo) != true){
            System.out.println("Não foi possivel alterar");
        }else{
            System.out.println("alterado com sucesso!");
        }
    }   
}

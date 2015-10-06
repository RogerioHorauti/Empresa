package br.edu.impacta.ads.aps.principal;

import br.edu.impacta.ads.aps.jdbc.dao.CargoDao;
import br.edu.impacta.ads.aps.jdbc.model.Cargo;

public class JdbcCargoInserir {
    public static void main(String[] args) {
        Cargo cargo = new Cargo();
        cargo.setNome("arquiteto");
        CargoDao dao = new CargoDao();
        if(dao.inserir(cargo)!=true){
            System.out.println("Não foi possivel inserir o cargo");
        }else{
            System.out.println("Cargo inserido com sucesso");
        }
    }
}

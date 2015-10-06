package br.edu.impacta.ads.aps.principal;

import br.edu.impacta.ads.aps.jdbc.dao.FuncionarioDao;
import br.edu.impacta.ads.aps.jdbc.model.Cargo;
import br.edu.impacta.ads.aps.jdbc.model.Departamento;
import br.edu.impacta.ads.aps.jdbc.model.Funcionario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcFuncionarioInserir {
    
    public static void main(String[] args) {       
        
        Funcionario f = new Funcionario();       
        f.setNome("Rogerio Yudi Horauti");
        Cargo cargo = new Cargo();
        cargo.setCodigo(8);
        f.setCargo(cargo);
        Departamento dep = new Departamento();
        dep.setCodigo(11);
        f.setDepartamento(dep);        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar data = new GregorianCalendar();
        try 
        {
            data.setTime(sdf.parse("10/06/2015"));
        } 
        catch (ParseException ex) 
        {
            Logger.getLogger(JdbcFuncionarioInserir.class.getName()).log(Level.SEVERE, null, ex);
        }
        f.setDataDeContratacao(data);        
        FuncionarioDao dao = new FuncionarioDao();
        dao.inserir(f);               
    
    }
}

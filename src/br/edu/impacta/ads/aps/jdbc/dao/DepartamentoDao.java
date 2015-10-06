package br.edu.impacta.ads.aps.jdbc.dao;

import br.edu.impacta.ads.aps.jdbc.conexao.Conexao;
import br.edu.impacta.ads.aps.jdbc.model.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DepartamentoDao implements GenericoDao<Departamento>{

   @Override
    public boolean inserir(Departamento departamento) 
    {    
        boolean status = false;
        String sql = "INSERT INTO empresa.departamento (nome) VALUES (?)";
        PreparedStatement ps;        
        try {      
            Connection conn = Conexao.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, departamento.getNome());
            if(ps.executeUpdate()!=0){
                status=true;      
            }
            ps.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CargoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    
    @Override
    public boolean alterar(Departamento departamento) {
         boolean status = false;
         String sql = "UPDATE empresa.departamento SET nome=? WHERE id_departamento=?";
         PreparedStatement ps;
         
        try {
            Connection conn = Conexao.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, departamento.getNome());
            ps.setInt(2, departamento.getCodigo());
            if(ps.executeUpdate() != 0){
                status = true;
            }
            ps.close();
            conn.close();                     
        }  
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CargoDao.class.getName()).log(Level.SEVERE, null, ex);
        }         
         return status;
    }

    @Override
    public boolean deletar(Departamento departamento) {
        boolean status = false;
        String sql = "delete FROM empresa.departamento WHERE id_departamento=?";
	PreparedStatement ps;
	try {
            Connection conn = Conexao.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1, departamento.getCodigo());
            if(ps.executeUpdate() != 0) {
		status = true;
            }
            ps.close();
            conn.close();
	} catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CargoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
	return status;
    }

    @Override
    public List<Departamento> listar() {
        List<Departamento> cargos = new ArrayList<>();
        String sql = "SELECT * FROM empresa.departamento";
        PreparedStatement ps;
        try {
            Connection conn = Conexao.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Departamento cargo = new Departamento();
                cargo.setCodigo(rs.getInt("id_departamento"));
                cargo.setNome(rs.getString("nome"));
                cargos.add(cargo);
            } 
            ps.close();
            conn.close();           
    }    
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CargoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cargos;
    }      
    
}

package br.edu.impacta.ads.aps.jdbc.dao;

import br.edu.impacta.ads.aps.jdbc.conexao.Conexao;
import br.edu.impacta.ads.aps.jdbc.model.Cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CargoDao implements GenericoDao<Cargo>{

    @Override
    public boolean inserir(Cargo cargo) {
        
        boolean status = false;
        String sql = "INSERT INTO empresa.cargo (nome) VALUES (?)";
        PreparedStatement ps;        
        try {
            Connection conn = Conexao.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, cargo.getNome());
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
    public boolean alterar(Cargo cargo) {
         boolean status = false;
         String sql = "UPDATE empresa.cargo SET nome=? WHERE id_cargo=?";
         PreparedStatement ps;
         
        try {
            Connection conn = Conexao.getInstance().getConnection();
            ps = conn.prepareStatement(sql);         
            ps.setString(1, cargo.getNome());
             ps.setInt(2, cargo.getCodigo());
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
    public boolean deletar(Cargo cargo) {
        boolean status = false;
        String sql = "delete FROM empresa.cargo WHERE id_cargo=?";
	PreparedStatement ps;
	try {
            Connection conn = Conexao.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1, cargo.getCodigo());
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
    public List<Cargo> listar() {
        List<Cargo> cargos = new ArrayList<>();
        String sql = "SELECT * FROM empresa.cargo";
        PreparedStatement ps;
        try {
            Connection conn = Conexao.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Cargo cargo = new Cargo();
                cargo.setCodigo(rs.getInt("id_cargo"));
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
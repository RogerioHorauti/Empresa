package br.edu.impacta.ads.aps.jdbc.dao;

import br.edu.impacta.ads.aps.jdbc.conexao.Conexao;
import br.edu.impacta.ads.aps.jdbc.model.Cargo;
import br.edu.impacta.ads.aps.jdbc.model.Departamento;
import br.edu.impacta.ads.aps.jdbc.model.Funcionario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioDao implements GenericoDao<Funcionario>{

    @Override
    public boolean inserir(Funcionario funcionario) {
        boolean status = false;
        String sql = "INSERT INTO Empresa.FUNCIONARIO (nome, id_cargo, id_departamento, dt_contratacao) VALUES (?, ?, ?, ?)";
        PreparedStatement ps;        
        try {
            Connection conn = Conexao.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, funcionario.getNome());
            ps.setInt(2, funcionario.getCargo().getCodigo());
            ps.setInt(3, funcionario.getDepartamento().getCodigo());
            Date gravarData = new Date(Calendar.getInstance().getTimeInMillis());
            ps.setDate(4, gravarData);
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
    public boolean alterar(Funcionario funcionario) {
      boolean status = false;
         String sql = "UPDATE empresa.funcionario SET nome=?, id_cargo=?, id_departamento=?, dt_contratacao=? WHERE id_funcionario=?";
         PreparedStatement ps;
         
        try {
            Connection conn = Conexao.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, funcionario.getNome());
            ps.setInt(2, funcionario.getCargo().getCodigo());
            ps.setInt(3, funcionario.getDepartamento().getCodigo());
            Date gravarData = new Date(Calendar.getInstance().getTimeInMillis());
            ps.setDate(4, gravarData);
            ps.setInt(5, funcionario.getCodigo());
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
    public boolean deletar(Funcionario funcionario) {
        boolean status = false;
        String sql = "delete FROM empresa.funcionario WHERE id_funcionario=?";
	PreparedStatement ps;
	try {
            Connection conn = Conexao.getInstance().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setLong(1, funcionario.getCodigo());
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
    public List<Funcionario> listar() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT F.ID_FUNCIONARIO, F.NOME, F.ID_CARGO, C.NOME CARGO, \n" +
                        "F.ID_DEPARTAMENTO, D.NOME DEPARTAMENTO\n" +
                        "FROM EMPRESA.FUNCIONARIO F\n" +
                        "INNER JOIN EMPRESA.CARGO C\n" +
                        "ON F.ID_CARGO = C.ID_CARGO\n" +
                        "INNER JOIN EMPRESA.DEPARTAMENTO D\n" +
                        "ON F.ID_DEPARTAMENTO = D.ID_DEPARTAMENTO";
        try {
            Connection conn = Conexao.getInstance().getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                /*FUNCIONARIO*/
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(rs.getInt("ID_FUNCIONARIO"));
                funcionario.setNome(rs.getString("NOME"));
                
                /*DEPARTAMENTO*/
                Departamento departamento = new Departamento();
                departamento.setCodigo(rs.getInt("ID_DEPARTAMENTO"));
                departamento.setNome(rs.getString("DEPARTAMENTO"));
                funcionario.setDepartamento(departamento);
                
                /*CARGO*/
                Cargo cargo = new Cargo();
                cargo.setCodigo(rs.getInt("ID_CARGO"));
                cargo.setNome(rs.getString("CARGO"));
                funcionario.setCargo(cargo);
                
                funcionarios.add(funcionario);
            }
            stm.close();
            rs.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return funcionarios;
    }
    
}

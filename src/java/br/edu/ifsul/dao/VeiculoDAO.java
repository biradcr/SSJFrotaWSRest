 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.conexao.Conexao;
import br.edu.ifsul.modelo.Veiculo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ubiratan
 */
public class VeiculoDAO {
    
    public VeiculoDAO()    {
    
    }   
    
    public Veiculo buscar(Veiculo veiculo)
    {
        String sql = "SELECT * FROM veiculos where codigo=?";
        Veiculo retorno = null;
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {           
            pst.setInt(1, veiculo.getCodigo());
            ResultSet res = pst.executeQuery();
            
            if(res.next())
            {
                retorno = new Veiculo();
                retorno.setCodigo(res.getInt("codigo"));
                retorno.setKm(res.getInt("km"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return retorno;    
    
    }
    
    public Veiculo buscarVeiculo(Integer veiculo){
         String sql = "SELECT * FROM veiculos WHERE codigo = ?";
        Veiculo retorno = null;        
        PreparedStatement pst = Conexao.getPreparedStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        try {           
            pst.setInt(1, veiculo);
            ResultSet res = pst.executeQuery();            
            if(res.next()){
                retorno = new Veiculo();
                retorno.setCodigo(res.getInt("codigo"));
                retorno.setModelo(res.getString("modelo"));
                retorno.setCor(res.getString("cor"));
                retorno.setKm(res.getInt("km"));
                retorno.setPlaca(res.getString("placa"));
            }        
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);            
        }        
        return retorno;    
    }
    
}
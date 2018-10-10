 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.conexao.Conexao;
import br.edu.ifsul.modelo.Retirada;
import br.edu.ifsul.modelo.Usuario;
import br.edu.ifsul.modelo.Veiculo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ubiratan
 */
public class RetiradaDAO {
    public RetiradaDAO(){
    
    }
    
    public Retirada inserirRetirada(Retirada retirada){
        String sql = "INSERT INTO retiradas(veiculo, imei_usuario) VALUES(?,?)";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {            
            System.out.println("Dados recebidos Veiculo no DAO: "+retirada.getVeiculo()+" Imei: "+retirada.getImei());
            System.out.println("Dados recebidos Veiculo no DAO: "+retirada.toString());
            pst.setInt(1, retirada.getVeiculo());            
            pst.setString(2, retirada.getImei());
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }   
        } catch (SQLException ex) {
            Logger.getLogger(RetiradaDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }   
       // System.out.println("Dados da retirada ### Código:"+retirada);
        return retirada;           
    }
    
    public Retirada getLastRetiradaByPlaca(String placa){
        String sql = "SELECT r.codigo, r.local_inicio, r.data_hora_inicio, r.data_hora_fim, r.destino, r.local_devolucao, \n" +
                      "r.km_inicial, r.km_final, r.usuario, r.veiculo"
                + " FROM retiradas r, veiculos v"
                + " WHERE v.placa = ?"
                + " AND r.veiculo = v.codigo"
                + " ORDER BY r.codigo desc limit 1";
        Retirada item = new Retirada();
        
        /*
            Tive que criar outro tipo de prepared statement porque ele não deixava navegar entre os valores
            que haviam sido carregados na listagem
        */
        PreparedStatement pst = Conexao.getPreparedStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        try {            
            pst.setString(1, placa);            
            ResultSet res = pst.executeQuery();            
            while(res.next()){            
                item.setCodigo(res.getInt("codigo"));
                item.setLocalInicio(res.getString("local_inicio"));
                item.setDataHoraInicio(res.getTimestamp("data_hora_inicio"));
                item.setDataHoraFim(res.getTimestamp("data_hora_fim"));
                item.setDestino(res.getString("destino"));
                item.setLocalDevolucao(res.getString("local_devolucao"));
                item.setKmInicial(res.getInt("km_inicial"));
                item.setKmFinal(res.getInt("km_final"));
                item.setUsuario(res.getInt("usuario"));
                item.setVeiculo(res.getInt("veiculo"));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(RetiradaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return item;
    }
    
    public Veiculo getVeiculo(Integer codVeiculo){
        String sql = "SELECT *"
                + " FROM retiradas r, veiculos v"
                + " WHERE v.codigo = ?"
                + " AND r.veiculo = v.codigo";
        Veiculo item = new Veiculo();        
        /*
            Tive que criar outro tipo de prepared statement porque ele não deixava navegar entre os valores
            que haviam sido carregados na listagem
        */
        PreparedStatement pst = Conexao.getPreparedStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        try {            
            pst.setInt(1, codVeiculo);            
            ResultSet res = pst.executeQuery();            
            while(res.next()){            
                item.setCodigo(res.getInt("codigo"));
                item.setKm(res.getInt("km"));               
            }            
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return item;
    }
    
    public boolean atualizar(Retirada retirada)
    {
        String sql = "UPDATE retiradas set local_devolucao=?,km_final=?,data_hora_fim=?";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setString(5, retirada.getLocalDevolucao());
            pst.setInt(7, retirada.getKmFinal());            
            pst.setTimestamp(3, retirada.getDataHoraFim());
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }           
        } catch (SQLException ex) {
            Logger.getLogger(RetiradaDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }        
        return retorno;    
    } 
    
    public List<Retirada> listar() {
         String sql = "SELECT * FROM retiradas";
        List<Retirada> retorno = new ArrayList<Retirada>();
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Retirada item = new Retirada();
                item.setLocalInicio(res.getString("local_inicio"));
                item.setDataHoraInicio(res.getTimestamp("data_hora_inicio"));
                item.setDataHoraFim(res.getTimestamp("data_hora_fim"));
                item.setDestino(res.getString("destino"));
                item.setLocalDevolucao(res.getString("local_devolucao"));
                item.setKmInicial(res.getInt("km_inicial"));
                item.setKmFinal(res.getInt("km_final"));
                item.setUsuario(res.getInt("usuario"));
                item.setVeiculo(res.getInt("veiculo"));                
                retorno.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RetiradaDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return retorno;
    }
    
    public Retirada buscarRetirada(String retirada){
         String sql = "SELECT * FROM retiradas, usuarios "
                 + "WHERE imei_usuario = ? AND km_final is null "
                 + "AND retiradas.usuario = usuarios.codigo";
        
        Retirada retornoR = null;       
        PreparedStatement pst = Conexao.getPreparedStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        try {           
            pst.setString(1, retirada);
            ResultSet res = pst.executeQuery();            
            if(res.next()){
                retornoR = new Retirada();
                retornoR.setCodigo(res.getInt("codigo"));
                retornoR.setLocalInicio(res.getString("local_inicio"));
                retornoR.setDataHoraInicio(res.getTimestamp("data_hora_inicio"));
                retornoR.setDataHoraFim(res.getTimestamp("data_hora_fim"));
                retornoR.setDestino(res.getString("destino"));
                retornoR.setLocalDevolucao(res.getString("local_devolucao"));
                retornoR.setKmInicial(res.getInt("km_inicial"));
                retornoR.setKmFinal(res.getInt("km_final"));
                retornoR.setUsuario(res.getInt("usuario"));
                retornoR.setVeiculo(res.getInt("veiculo"));
                retornoR.setImei(res.getString("imei_usuario"));
                retornoR.setNomeUsuario(res.getString("nome"));
            }        
        } catch (SQLException ex) {
            Logger.getLogger(RetiradaDAO.class.getName()).log(Level.SEVERE, null, ex);            
        }        
        return retornoR;  
    }
    
    public Retirada devolver(Retirada retirada){
         String sql = "UPDATE retiradas SET destino = ?, km_final= ? "
                 + "WHERE imei_usuario = ? AND km_final is null;";
        Boolean retorno = false;        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {           
            pst.setString(1, retirada.getDestino());            
            pst.setInt(2, retirada.getKmFinal());           
            pst.setString(3, retirada.getImei());           
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }   
        } catch (SQLException ex) {
            Logger.getLogger(RetiradaDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }   
       // System.out.println("Dados da retirada ### Código:"+retirada);
        return retirada;    
    }


}

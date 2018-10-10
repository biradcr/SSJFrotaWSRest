 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.conexao.Conexao;
import br.edu.ifsul.modelo.Usuario;
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
public class UsuarioDAO {
    public UsuarioDAO(){
    
    }   
    
    public List<Usuario> listar() {
         String sql = "SELECT * FROM usuarios";
        List<Usuario> retorno = new ArrayList<Usuario>();
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Usuario item = new Usuario();
                item.setCodigo(res.getInt("codigo"));
                item.setNome(res.getString("nome"));
                item.setMatricula(res.getInt("matricula"));
                item.setEmail(res.getString("email"));
                item.setCnh_numero(res.getString("cnh_numero"));
                item.setCnh_categoria(res.getString("cnh_categoria"));
                item.setFone_particular(res.getString("fone_particula"));
                item.setFone_corporativo(res.getString("fone_corporativo"));
                item.setImei(res.getString("imei"));
                item.setAtivo(res.getBoolean("ativo"));              
                retorno.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return retorno;}    
    
    public Usuario buscarUsuario(String usuario){
         String sql = "SELECT * FROM usuarios WHERE imei= ? AND ativo = true";
        Usuario retorno = null;        
        PreparedStatement pst = Conexao.getPreparedStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        try {           
            pst.setString(1, usuario);
            ResultSet res = pst.executeQuery();            
            if(res.next()){
                retorno = new Usuario();
                retorno.setCodigo(res.getInt("codigo"));
                retorno.setNome(res.getString("nome"));
                retorno.setMatricula(res.getInt("matricula"));
                retorno.setEmail(res.getString("email"));
                retorno.setCnh_numero(res.getString("cnh_numero"));
                retorno.setCnh_categoria(res.getString("cnh_categoria"));
                retorno.setFone_particular(res.getString("fone_particular"));
                retorno.setFone_corporativo(res.getString("fone_corporativo"));
                retorno.setImei(res.getString("imei"));
                retorno.setAtivo(res.getBoolean("ativo")); 
            }        
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);            
        }        
        return retorno;    
    }


}

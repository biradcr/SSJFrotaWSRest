/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.sql.Timestamp;

/**
 *
 * @author ubiratan
 */
public class Usuario {
    
    private Integer codigo;
    private String nome;
    private Integer matricula;
    private String email;
    private String cnh_numero;
    private String cnh_categoria;
    private String fone_particular;
    private String fone_corporativo;
    private String imei;
    private Boolean ativo;
    

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the matricula
     */
    public Integer getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the cnh_numero
     */
    public String getCnh_numero() {
        return cnh_numero;
    }

    /**
     * @param cnh_numero the cnh_numero to set
     */
    public void setCnh_numero(String cnh_numero) {
        this.cnh_numero = cnh_numero;
    }

    /**
     * @return the cnh_categoria
     */
    public String getCnh_categoria() {
        return cnh_categoria;
    }

    /**
     * @param cnh_categoria the cnh_categoria to set
     */
    public void setCnh_categoria(String cnh_categoria) {
        this.cnh_categoria = cnh_categoria;
    }

    /**
     * @return the fone_particular
     */
    public String getFone_particular() {
        return fone_particular;
    }

    /**
     * @param fone_particular the fone_particular to set
     */
    public void setFone_particular(String fone_particular) {
        this.fone_particular = fone_particular;
    }

    /**
     * @return the fone_corporativo
     */
    public String getFone_corporativo() {
        return fone_corporativo;
    }

    /**
     * @param fone_corporativo the fone_corporativo to set
     */
    public void setFone_corporativo(String fone_corporativo) {
        this.fone_corporativo = fone_corporativo;
    }

    /**
     * @return the imei
     */
    public String getImei() {
        return imei;
    }

    /**
     * @param imei the imei to set
     */
    public void setImei(String imei) {
        this.imei = imei;
    }

    /**
     * @return the ativo
     */
    public Boolean getAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    

    

}

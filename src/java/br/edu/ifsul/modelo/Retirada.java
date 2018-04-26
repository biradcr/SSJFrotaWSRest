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
public class Retirada {
    
    private Integer codigo;
    private String localInicio;
    private Timestamp dataHoraInicio;
    private Timestamp dataHoraFim;
    private String destino;
    private String localDevolucao;
    private Integer kmInicial;
    private Integer kmFinal;
    private Integer usuario;
    private Integer veiculo;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getLocalInicio() {
        return localInicio;
    }

    public void setLocalInicio(String localInicio) {
        this.localInicio = localInicio;
    }

    public Timestamp getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(Timestamp dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public Timestamp getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(Timestamp dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getLocalDevolucao() {
        return localDevolucao;
    }

    public void setLocalDevolucao(String localDevolucao) {
        this.localDevolucao = localDevolucao;
    }

    public Integer getKmInicial() {
        return kmInicial;
    }

    public void setKmInicial(Integer kmInicial) {
        this.kmInicial = kmInicial;
    }

    public Integer getKmFinal() {
        return kmFinal;
    }

    public void setKmFinal(Integer kmFinal) {
        this.kmFinal = kmFinal;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public Integer getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Integer veiculo) {
        this.veiculo = veiculo;
    }

    

}

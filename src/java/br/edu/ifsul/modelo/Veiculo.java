/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 *
 * @author ubiratan
 */
public class Veiculo {
    
    private Integer codigo;
    private String modelo;
    private String cor;
    private Calendar ano;
    private Integer km;
    private String placa;
    private Montadora montadora;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Calendar getAno() {
        return ano;
    }

    public void setAno(Calendar ano) {
        this.ano = ano;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Montadora getMontadora() {
        return montadora;
    }

    public void setMontadora(Montadora montadora) {
        this.montadora = montadora;
    }

    
}

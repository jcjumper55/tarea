/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author ciroa
 */
public class Ruta extends Abstract{
    private Integer id;
    private String codigo;
    private String paradaInicial;
    private String paradaFinal;
    private String hora;
    private Double costo;

    public Ruta() {
    }

    public Ruta(String codigo, String paradaInicial, String paradaFinal, Double costo) {
        this.codigo = codigo;
        this.paradaInicial = paradaInicial;
        this.paradaFinal = paradaFinal;
        this.costo = costo;
    }

    public Ruta(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getParadaInicial() {
        return paradaInicial;
    }

    public void setParadaInicial(String paradaInicial) {
        this.paradaInicial = paradaInicial;
    }

    public String getParadaFinal() {
        return paradaFinal;
    }

    public String getHora() {
        return hora;
    }

    public void setParadaFinal(String paradaFinal) {
        this.paradaFinal = paradaFinal;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    @Override
    public String toString() {
        return "Ruta{id=" + id + ",codigo=" + codigo + ", paradaInicial=" + paradaInicial + ", paradaFinal=" + paradaFinal + ", hora=" + hora+ ", costo=" + costo + '}';
    }
    @Override
    public String toFileData(){ 
        return id+"\t"+codigo+"\t"+ paradaInicial+"\t"+ paradaFinal+"\t"+ hora+"\t"+ costo+"\t"+"\r\n";
    }
    
}

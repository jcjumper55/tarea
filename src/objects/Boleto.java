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
public class Boleto extends Abstract implements Cloneable{
    private String paradaInicial;
    private String paradaFinal;
    private String hora;
    private String fecha;
    
    private String identificacion;
    private String apellidos;
    private String nombres;
    private int edad;
    private String tipo;
    private Double valor;
    private Double total;
    private String asiento;
    private String asientosStr;

    public void setParadaInicial(String paradaInicial) {
        this.paradaInicial = paradaInicial;
    }

    public void setParadaFinal(String paradaFinal) {
        this.paradaFinal = paradaFinal;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setAsientosStr(String asientosStr) {
        this.asientosStr = asientosStr;
    }

    public String getParadaInicial() {
        return paradaInicial;
    }

    public String getParadaFinal() {
        return paradaFinal;
    }

    public String getHora() {
        return hora;
    }

    public String getFecha() {
        return fecha;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public int getEdad() {
        return edad;
    }

    public String getTipo() {
        return tipo;
    }

    public Double getValor() {
        return valor;
    }

    public String getAsientosStr() {
        return asientosStr;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public String getAsiento() {
        return asiento;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Boleto{" + "paradaInicial=" + paradaInicial + ", paradaFinal=" + paradaFinal + ", hora=" + hora + ", fecha=" + fecha + ", identificacion=" + identificacion + ", apellidos=" + apellidos + ", nombres=" + nombres + ", edad=" + edad + ", tipo=" + tipo + ", valor=" + valor + ", asientosStr=" + asientosStr + '}';
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    @Override
    public String toFileData(){ 
        return paradaInicial+"\t"+paradaFinal+"\t"+ hora+"\t"+ fecha+"\t"+ identificacion+"\t"+ nombres+"\t"+ apellidos+"\t"+ edad+"\t"+ tipo+"\t"+ asientosStr+"\t"+ total+"\t"+"\r\n";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ciroa
 */
public class Disponibilidad extends Abstract{
    private String paradaInicial;
    private String paradaFinal;
    private String hora;
    private String fecha;
    private String asientosStr;
    
    private String[] asientos;
    private ArrayList<String> asientosVentana;
    private ArrayList<String> asientosPasillo;
    private String[][] disponibles;
    
    public Disponibilidad() {
        
        disponibles=new String[10][4];
        for(int i=0;i<10;i++){
            String[] fila=new String[]{"0","0","0","0"};
            disponibles[i]=fila;
        }
        asientosVentana=new ArrayList<>();
        asientosPasillo=new ArrayList<>();
    }
    
    
    

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

    public void setAsientos(String asientos) {
        this.asientosStr = asientos;
        this.asientos = asientos.split(",");        
        int num=0;
        for(int i=0;i<disponibles.length;i++){
            for(int j=0;j<disponibles[i].length;j++){   
                num++;
                Boolean ocupado=true;
                for(int k=0;k<this.asientos.length;k++){
                    
                    //System.out.println(" "+num+" "+this.asientos[k]);
                    if(this.asientos[k].equals(Integer.toString(num))){
                        ocupado=false;                        
                    }
                }
                disponibles[i][j]=(ocupado?"X":"0");
            }
        }
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

    public String getAsientos() {
        return asientosStr;
    }
    public String getAsientosFormated() {
        String asientosFormat="";
        int num=0;
        for(int i=0;i<disponibles.length;i++){
            for(int j=0;j<disponibles[i].length;j++){
                num++;
                if(disponibles[i][j].equals("0"))
                    asientosFormat+=((asientosFormat.equals("")?"":",")+num);
            }
        }
        return asientosFormat;
    }
    public void setOcupado(Integer asien, Boolean ocupado){
        int num=0;
        for(int i=0;i<disponibles.length;i++){
            for(int j=0;j<disponibles[i].length;j++){
                num++;
                if(asien==num){
                    disponibles[i][j]=ocupado?"X":"0";
                    break;
                }
            }
        }
    }
    public ArrayList<Integer> getAsientosDisponibles(String tipo){
        ArrayList<Integer> asieAux=new ArrayList<>();
        int num=0;
        for(int i=0;i<disponibles.length;i++){
            for(int j=0;j<disponibles[i].length;j++){
                num++;
                if("0".equals(disponibles[i][j])){
                    if("Pasillo".equals(tipo)){
                        if(j==1||j==2) asieAux.add(num);
                    }
                    if("Ventana".equals(tipo)){
                        if(j==0||j==3) asieAux.add(num);
                    }
                }
            }
        }
        return asieAux;
    }
    public String[][] getDisponibles() {
        return disponibles;
    }

    
    
    @Override
    public String toString() {
        return "Disponibilidad{" + "paradaInicial=" + paradaInicial + ", paradaFinal=" + paradaFinal + ", hora=" + hora + ", fecha=" + fecha + ", asientosStr=" + asientosStr + '}';
    }
    public void printDisponibles() {
        for(int i=0;i<disponibles.length;i++){
            for(int j=0;j<disponibles[i].length;j++){
                if(j==2) System.out.print("|   |");
                System.out.print(disponibles[i][j]+" ");
            }
            System.out.println("");
        }
    }
    @Override
    public String toFileData(){ 
        return paradaInicial+"\t"+paradaFinal+"\t"+ hora+"\t"+ fecha+"\t"+ this.getAsientosFormated()+"\t"+"\r\n";
    }
    
}

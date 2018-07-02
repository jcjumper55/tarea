/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
* @author ciroa
 */
public class Boletos extends Abstract{
    public Boletos(){
        NAME="BOLETOS";
        FILE_STR="datos/Boletos.txt";       
        file=new File(FILE_STR);        
        this.validateFile();
    }
    @Override
    protected objects.Abstract fileDataToObject(StringTokenizer mistokens){
        objects.Boleto obj=new objects.Boleto();
        
        obj.setParadaInicial(mistokens.nextToken().trim());        
        obj.setParadaFinal(mistokens.nextToken().trim());
        obj.setHora(mistokens.nextToken().trim());
        obj.setFecha(mistokens.nextToken().trim());
        obj.setIdentificacion(mistokens.nextToken().trim());
        obj.setNombres(mistokens.nextToken().trim());
        obj.setApellidos(mistokens.nextToken().trim());
        obj.setEdad(Integer.parseInt(mistokens.nextToken().trim())); 
        obj.setTipo(mistokens.nextToken().trim());
        //obj.setValor(Double.parseDouble(mistokens.nextToken().trim())); 
        obj.setAsientosStr(mistokens.nextToken().trim());
        obj.setTotal(Double.parseDouble(mistokens.nextToken().trim())); 
        //System.out.println(obj.toString());
        this.getList().add((objects.Abstract)obj);
        return obj;
    }
    public ArrayList<objects.Boleto> Search(String ruta, String hora, String fecha){
        ArrayList<objects.Boleto> objs=new ArrayList<>();
        for(int i=0;i<this.getList().size();i++){
            objects.Boleto aux=(objects.Boleto) this.getListAt(i);
//            System.out.println(ruta+ " " +aux.getParadaInicial()+" - "+aux.getParadaFinal());
//            System.out.println(hora+ " " +aux.getHora());
//            System.out.println(fecha+ " " +aux.getFecha());
            if(ruta.equals(aux.getParadaInicial()+" - "+aux.getParadaFinal()) && hora.equals(aux.getHora()) && fecha.equals(aux.getFecha())){
                String[] asientos=aux.getAsientosStr().split(";");
                for (String asiento : asientos) {
                     String[] campos=asiento.trim().split(":");
                    try {
                        objects.Boleto clone=(objects.Boleto) aux.clone();
                        clone.setAsiento(campos[0].trim()+":"+campos[1].trim());
                        System.out.println(campos[0].trim()+":"+campos[1].trim());
                        System.out.println(campos[2].trim());
                        clone.setValor(Double.parseDouble(campos[2].trim()));
                        objs.add(clone);
                    } catch (CloneNotSupportedException ex) {
                        Logger.getLogger(Boletos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }
        }
        return objs;
    }
    public objects.Boleto  SearchOne(String ruta, String hora, String fecha, String cedula){
        objects.Boleto obj=null;
        for(int i=0;i<this.getList().size();i++){
            objects.Boleto aux=(objects.Boleto) this.getListAt(i);
            if(ruta.equals(aux.getParadaInicial()+" - "+aux.getParadaFinal()) && hora.equals(aux.getHora()) && fecha.equals(aux.getFecha()) && cedula.equals(aux.getIdentificacion())){
                obj=aux;
            }
        }
        return obj;
    }
    @Override
    public Boolean equals(objects.Abstract data1,objects.Abstract data2){
        objects.Boleto ver1=(objects.Boleto)data1;
        objects.Boleto ver2=(objects.Boleto)data2;
        return (
                ver1.getParadaInicial().equals(ver2.getParadaInicial())
                && ver1.getParadaFinal().equals(ver2.getParadaFinal()) 
                && ver1.getFecha().equals(ver2.getFecha()) 
                && ver1.getHora().equals(ver2.getHora()) 
                && ver1.getIdentificacion().equals(ver2.getIdentificacion()) 
        );
    }
    public static void main(String args[]) {
         Boletos dis=new Boletos();
         dis.readData();         
    }
}

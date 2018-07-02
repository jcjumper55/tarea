/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.File;
import java.util.StringTokenizer;

/**
 *
* @author ciroa
 */
public class Disponibilidad extends Abstract{
    public Disponibilidad(){
        NAME="DISPONIBILIDAD";
        FILE_STR="datos/Disponibilidad.txt";       
        file=new File(FILE_STR);        
        this.validateFile();
    }
    @Override
    protected objects.Abstract fileDataToObject(StringTokenizer mistokens){
        objects.Disponibilidad obj=new objects.Disponibilidad();
        obj.setParadaInicial(mistokens.nextToken().trim());
        obj.setParadaFinal(mistokens.nextToken().trim());
        obj.setHora(mistokens.nextToken().trim());
        obj.setFecha(mistokens.nextToken().trim());
        obj.setAsientos(mistokens.nextToken().trim());
        //System.out.println(obj.toString());
        //obj.printDisponibles();
        this.getList().add((objects.Abstract)obj);
        return obj;
    }
    public objects.Disponibilidad Search(String ruta, String hora, String fecha){
        objects.Disponibilidad obj=null;
        for(int i=0;i<this.getList().size();i++){
            objects.Disponibilidad aux=(objects.Disponibilidad) this.getListAt(i);
//            System.out.println(ruta+ " " +aux.getParadaInicial()+" - "+aux.getParadaFinal());
//            System.out.println(hora+ " " +aux.getHora());
//            System.out.println(fecha+ " " +aux.getFecha());
            if(ruta.equals(aux.getParadaInicial()+" - "+aux.getParadaFinal()) && hora.equals(aux.getHora()) && fecha.equals(aux.getFecha())){
                obj=aux; break;
            }
        }
        return obj;
    }
    @Override
    public Boolean equals(objects.Abstract data1,objects.Abstract data2){
        objects.Disponibilidad ver1=(objects.Disponibilidad)data1;
        objects.Disponibilidad ver2=(objects.Disponibilidad)data2;
        return (
                ver1.getParadaInicial().equals(ver2.getParadaInicial())
                && ver1.getParadaFinal().equals(ver2.getParadaFinal()) 
                && ver1.getFecha().equals(ver2.getFecha()) 
                && ver1.getHora().equals(ver2.getHora()) 
        );
    }
    public static void main(String args[]) {
         Disponibilidad dis=new Disponibilidad();
         dis.readData();         
    }
}

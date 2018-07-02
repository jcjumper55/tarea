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
public class Rutas extends Abstract{

    public Rutas(){
        NAME="RUTAS";
        FILE_STR="datos/Rutas.txt";       
        file=new File(FILE_STR);        
        this.validateFile();
    }
    @Override
    protected objects.Abstract fileDataToObject(StringTokenizer mistokens){
        objects.Ruta obj=new objects.Ruta();
        obj.setId(Integer.parseInt(mistokens.nextToken().trim()));
        obj.setCodigo(mistokens.nextToken().trim());
        obj.setParadaInicial(mistokens.nextToken().trim());
        obj.setParadaFinal(mistokens.nextToken().trim());
        obj.setHora(mistokens.nextToken().trim());
        obj.setCosto(Double.parseDouble(mistokens.nextToken().trim()));       
        System.out.println(obj.toString());
        this.getList().add((objects.Abstract)obj);
        return obj;
    }
    
    
}

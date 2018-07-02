/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ciroa
 */
public class Abstract {
    protected String NAME;
    protected String FILE_STR;
    protected File file;
    protected ArrayList<objects.Abstract> list =new ArrayList<>();

    public Abstract() {
        this.file = null;
        this.NAME = "";
    }

    public String getFileString() {
        return FILE_STR;
    }
    public void setFile(String file) {
        this.FILE_STR = file;
    }
    protected boolean validateFile(){            
            if(!file.exists()){                
                try {
                    file.createNewFile();
                    System.out.println("Base de datos de "+NAME+" creada se creo correctamente!");
                } catch (IOException ex) {
                    Logger.getLogger(Abstract.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else System.out.println("La base de datos de "+NAME+" existe!");
            
        
        return true;
    }
    
    public objects.Abstract getListAt(int pos) {
        return list.get(pos);
    }
    public ArrayList<objects.Abstract> getList() {
        return list;
    }
    
    protected objects.Abstract fileDataToObject(StringTokenizer mistokens){
        objects.Abstract obj=new objects.Abstract();
        this.list.add(obj);
        return obj;
    }
    public void readData(){
        String linea;
        try (BufferedReader leerFichero = new BufferedReader (new FileReader(this.file))) {
            while( (linea = leerFichero.readLine()) != null){
                //este bucle es para meter todos los datos leidos de archivo de texto separlo en atributos y convertirlos a objeto para poder trabajar con el
                //en esta parte le digo que lo separe en tokens pero ojo estos tokens son solo Strings tengo que convertirlos para poder emterlos en el objeto y trabajar con ellos
                if(!"".equals(linea.trim())){
                    StringTokenizer mistokens = new StringTokenizer(linea, "\t");
                    this.fileDataToObject(mistokens);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Abstract.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
    public void addData(objects.Abstract data){
        try(BufferedWriter Fescribe = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.file,true), "utf-8"))) {  
              /*Escribe en el fichero la cadena que recibe la función.  
               *el string "\r\n" significa salto de linea  y el \t significa tabulacion  */  
              Fescribe.write(data.toFileData());  
              System.out.println(this.NAME+" a sido insertado en la base de datos");           //Cierra el flujo de escritura  

        }catch (Exception ex) {  
          //Captura un posible error le imprime en pantalla   
          System.out.println(ex.getMessage());  
       }
    }
    public Boolean equals(objects.Abstract data1,objects.Abstract data2){
        return false;
    }
    public void updateData(objects.Abstract data){
        String linea;        
        try (BufferedReader leerFichero = new BufferedReader (new FileReader(this.file))) {
            this.list=new ArrayList<>();
            while( (linea = leerFichero.readLine()) != null){
                //este bucle es para meter todos los datos leidos de archivo de texto separlo en atributos y convertirlos a objeto para poder trabajar con el
                //en esta parte le digo que lo separe en tokens pero ojo estos tokens son solo Strings tengo que convertirlos para poder emterlos en el objeto y trabajar con ellos
                if(!"".equals(linea.trim())){
                    StringTokenizer mistokens = new StringTokenizer(linea, "\t");
                    this.fileDataToObject(mistokens);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Abstract.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(this.file));
            for(objects.Abstract n:this.list){
                if(!this.equals(n,data))
                    bw.write(n.toFileData());   
                else
                    bw.write(data.toFileData());   
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Abstract.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void deleteData(objects.Abstract data){
        String linea;
        try (BufferedReader leerFichero = new BufferedReader (new FileReader(this.file))) {
            this.list=new ArrayList<>();
            while( (linea = leerFichero.readLine()) != null){
                //este bucle es para meter todos los datos leidos de archivo de texto separlo en atributos y convertirlos a objeto para poder trabajar con el
                //en esta parte le digo que lo separe en tokens pero ojo estos tokens son solo Strings tengo que convertirlos para poder emterlos en el objeto y trabajar con ellos
                if(!"".equals(linea.trim())){
                    StringTokenizer mistokens = new StringTokenizer(linea, "\t");
                    this.fileDataToObject(mistokens);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Abstract.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(this.file));
            for(objects.Abstract n:this.list){
                if(!this.equals(n,data))
                    bw.write(n.toFileData());
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Abstract.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

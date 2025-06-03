package com.prueba.model;

import com.prueba.excepcion.ExcepcionPersonalizada;

public class Pelicula {

    private String title;
    private int episode_id;
    private String opening_crawl;
    private String director;
    private String producer;
    private String release_date ="";



    public Pelicula(){
        this.setTitle("");
        this.setEpisode_id(0);
        this.setOpening_crawl("");
        this.setDirector("");
        this.setProducer("");
        this.setRelease_date("");

    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }

    public void setEpisode_id(int episode_id){
        this.episode_id = episode_id;
    }
    public int getEpisode_id(){
        return this.episode_id;
    }

    public void setOpening_crawl(String opening_crawl){ this.opening_crawl = opening_crawl;}
    public String getOpening_crawl(){return this.opening_crawl;}

    public void setDirector(String director){ this.director = director;}
    public String getDirector(){return this.director;}

    public void setProducer(String producer){ this.producer = producer;}
    public String getProducer(){return this.producer;}

    public void setRelease_date(String release_date){ this.release_date = release_date;}
    public String getRelease_date(){return this.release_date;}


    // metodo toString para mostrar informacion del objeto imprimiendo directamente el objeto sin invocar algun metodo
    // el metodo ya existe en el objeto asi que se tiene que sobre escribir
    @Override
    public String toString(){
        return  "\noooooooooooooooooooooooooooooooooooooooo\n"+
                "\n Salida metodo toString() clase Pelicula "+
                "\n Titulo de la pelicula: "+this.getTitle()+
                "\n ID del episodio: "+this.getEpisode_id()+
                "\n Opening de la pelicula: "+this.getOpening_crawl()+
                "\n Director de la pelicula: "+this.getDirector()+
                "\n Productor de la pelicula "+this.getProducer()+
                "\n Fecha de lanzamiento de la pelicula: "+this.getRelease_date()+
                "\n oooooooooooooooooooooooooooooooooooooooo\n ";
    }// fin toString


    // creamos un constructor que recibe como argumento un objeto de clase TituloRecord
    // el record ya posee integrados los getters y los setters, y se pueden obtener las propiedades mediante nombreObjeto.nombrePropiedad()
    // ejemplo objetoTituloRecord.Title();
  /*
    public Pelicula(TituloRecord objetoTituloRecord){
        this.setNombre(objetoTituloRecord.Title());
        this.setLanzamiento(objetoTituloRecord.Released());
        // lanzamos la excepcion personalizada cuando  Runtime traiga N/A. Probar con el titulo bichos
        if(objetoTituloRecord.Runtime().contains("N/A")){
            throw new ExcepcionPersonalizada("Excepcion Personalizada: ->Encontre N/A en campo Runtime");
        }
        this.setDuracion(objetoTituloRecord.Runtime());
        this.setGenero(objetoTituloRecord.Genre());
        this.setDirector(objetoTituloRecord.Director());
        this.setTrama(objetoTituloRecord.Plot());
        this.setPais(objetoTituloRecord.Country());

    }





    public void extraerInformacionArreglos(String[] arrClaves, String[] arrValores){
        // recorremos el arreglo de claves para extraer la información específica para el objeto Titulo
        // System.out.println("Metodo interno extraerInformacionArreglos arrClaves[1]: "+ arrClaves[1]);
       //  System.out.println("Metodo interno extraerInformacionArreglos arrValores[1]: "+ arrValores[1]);
        String elementoProcesar = "";
        String clavesIgnoradas = "-";
        for(int i=0; i < arrClaves.length; i++){
            elementoProcesar = arrClaves[i];
            // System.out.println("Elemento a procesar: "+elementoProcesar);
            // extraemos el titulo del arreglo
            if("Title".equals(elementoProcesar)){
                this.setNombre(arrValores[i]);
            }
            else if("Released".equals(elementoProcesar)){
                this.setLanzamiento(arrValores[i]);
            }
            else if("Runtime".equals(elementoProcesar)){
                this.setDuracion(arrValores[i]);
            }
            else if("Genre".equals(elementoProcesar)){
                this.setGenero(arrValores[i]);
            }
            else if("Director".equals(elementoProcesar)){
                this.setDirector(arrValores[i]);
            }
            else if("Plot".equals(elementoProcesar)){
                this.setTrama(arrValores[i]);
            }
            else if("Country".equals(elementoProcesar)){
                this.setPais(arrValores[i]);
            }
            else{
                // guardamos en un string las claves no usadas para mostrar despues
               // clavesIgnoradas = clavesIgnoradas.concat(" ,").concat(elementoProcesar);
                clavesIgnoradas = clavesIgnoradas +" ,"+ elementoProcesar;
            }
        }//fin for
        // almacenamos las claves no usadas en el objeto
        this.setClavesNoUsadas(clavesIgnoradas);
    }// fin extraerInformacion

    public void listarInformacionAlmacenada(){
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("INFORMACION DE LA PELICULA");
        System.out.println("Titulo de la pelicula: "+this.getNombre());
        System.out.println("Fecha de lanzamiento de la pelicula: "+this.getLanzamiento());
        System.out.println("Duracion de la pelicula: "+this.getDuracion());
        System.out.println("Genero de la pelicula: "+this.getGenero());
        System.out.println("Director de lanzamiento de la pelicula: "+this.getDirector());
        System.out.println("Trama de la pelicula: "+this.getTrama());
        System.out.println("Pais de la pelicula: "+this.getPais());
        System.out.println("Claves no usadas del Json: "+this.getClavesNoUsadas());
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    }// fin listarInformacion




    */



}// fin clase



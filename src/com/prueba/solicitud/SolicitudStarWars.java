package com.prueba.solicitud;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class SolicitudStarWars {
    public String endpoint ;
    public int numeroDePelicula;
    public String url;
    private String respuestaAPIRequest = "";
    private String respuestaAPIResponse = "";
    private String pelicula = "";

    public SolicitudStarWars(){
        // this.endpoint = "http://www.omdbapi.com/?t=tt3896198&apikey=";
        int numeroPelicula = 0;
        this.endpoint = "https://swapi.py4e.com/api/films/";
        numeroPelicula = this.buscarPelicula();
        if(numeroPelicula != 0){
            System.out.println("Numero de pelicula capturado sin problema: "+numeroPelicula);
        }
        else{
            System.out.println("Error capturando numero de pelicula. Numero de pelicula con valor: "+numeroPelicula);
        }

    }

    /*
    public SolicitudStarWars(String muchasSolicitudes){
        // cuando se manda un String en el constructor, significa que no se hará el llamado al método asignar pelicula

        // this.endpoint = "http://www.omdbapi.com/?t=tt3896198&apikey=";
        this.endpoint = "http://www.omdbapi.com/?t=";
        this.apiKey = "&apikey=c184ab6c";

    }

*/



    public String getRespuestaAPIRequest(){
        return this.respuestaAPIRequest;
    }
    public void setRespuestaAPIRequest(String respuestaAPIRequest){
        this.respuestaAPIRequest = respuestaAPIRequest;
    }

    public String getRespuestaAPIResponse(){
        return this.respuestaAPIResponse;
    }
    public void setRespuestaAPIResponse(String respuestaAPIResponse){
        this.respuestaAPIResponse = respuestaAPIResponse;
    }

    public String getPelicula(){
        return this.pelicula;
    }
    public void setPelicula(String pelicula){
        this.pelicula = pelicula;
    }

    public int getNumeroDePelicula(){
        return this.numeroDePelicula;
    }
    public void setNumeroDePelicula(int numeroDePelicula){
        this.numeroDePelicula = numeroDePelicula;
    }


    public String mostrarURL(){
        return this.url;
    }

    public int buscarPelicula() {
        Scanner atrapar = new Scanner(System.in);
        int numeroPelicula = 0;
        String numeroPeliculaString = "";
        System.out.println("PROCESO ATRAPAR NUMERO PELICULA");
        try{
            System.out.println("Digite numero de la pelicula");
            numeroPelicula = atrapar.nextInt();
            setNumeroDePelicula(numeroPelicula);
            numeroPeliculaString = String.valueOf(this.getNumeroDePelicula());
            // esta instruccion configura el endpoint a consumir de acuerdo con el nombre de la pelicula digitado
            this.url = this.endpoint.concat(numeroPeliculaString).concat("/");

        }
        catch(Exception e){
            System.out.println("Excepcion. Error atrapando numero de pelicula. Mensaje: "+e.getMessage());
            setNumeroDePelicula(0);
        }
        finally {
            return this.getNumeroDePelicula();
        }



    }// fin buscar pelicula


    public String transformarEspacios(String urlConEspacios){
        String urlTransformada = "";
        urlTransformada = urlConEspacios.replace(" ", "%20");
        System.out.println("Url Solicitada: "+urlConEspacios);
        System.out.println("Url Transformada: "+urlTransformada);
        return urlTransformada;
    }

    public void consumirEndpointRequest(){
        try{
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(this.url))
                    .build();

            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    //.thenAccept(System.out::println)
                    // .thenAccept(this::setRespuestaAPI)
                    //.thenAccept(respuesta -> System.out.println("La respuesta tipo request es: " +respuesta))
                    .thenAccept(respuesta -> this.setRespuestaAPIRequest(respuesta))
                    .join();
        }
        catch(Exception e ){
            System.out.println("Error consumiendo Endpoint. Tipo Error: "+ e.getMessage());
            System.out.println("Error: "+ e);
        }
    }

    public void consumirEndpointResponse() throws IOException, InterruptedException{
        try{
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(this.url))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // System.out.println("La respuesta tipo response es: "+response.body());

            this.setRespuestaAPIResponse(response.body());



        }
        catch(IOException | InterruptedException e){
            throw new RuntimeException(e);
        }
        catch(Exception e ){
            System.out.println("Error consumiendo Endpoint tipo Response. Tipo Error: "+ e.getMessage());
            System.out.println("Error: "+ e);
        }
    } // fin consumirEndpointResponse
}

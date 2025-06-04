
import com.prueba.model.*;
import com.prueba.solicitud.SolicitudStarWars;
import com.prueba.persistencia.Archivo;

import java.io.IOException;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        // creamos objeto solicitud
        SolicitudStarWars objetoSolicitudStarWars = new SolicitudStarWars();
        // creamos objeto para recibir pelicula
        Pelicula objetoPelicula = new Pelicula();
        System.out.println("Mensaje main: La URL es: "+objetoSolicitudStarWars.mostrarURL());
        // objetoSolicitudStarWars.consumirEndpointRequest();
        // System.out.println("Mensaje main: La respuesta tipo request es: " +objetoSolicitudStarWars.getRespuestaAPIRequest());
        objetoSolicitudStarWars.consumirEndpointResponse();
        System.out.println("Mensaje main: La respuesta tipo response es:"+objetoSolicitudStarWars.getRespuestaAPIResponse());
        // construimos un objeto Gson para procesar el JSON y obtener arreglos con las claves y valores
        BibliotecaGson objetoGson = new BibliotecaGson();
        // procesamos el json obtenido del request
        objetoPelicula =  objetoGson.procesarJsonStarWars(objetoSolicitudStarWars.getRespuestaAPIResponse());
        System.out.println("ObjetoPelicula obtenido con biblioteca GSON: "+ objetoPelicula);
        // convertimos el objetoPelicula a json
        String jsonPelicula = objetoGson.convertirAJsonObjeto(objetoPelicula);
        // construimos un objeto de la clase Archivo para guardar el json en archivo .json
        Archivo objetoArchivo = new Archivo();
        String resultadoGuardar =  objetoArchivo.guardarJson(jsonPelicula);
        System.out.println(resultadoGuardar);






    }// fin main
}// fin clase
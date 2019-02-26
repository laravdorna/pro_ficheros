/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex13_ficheros;

import escritura.Escribir;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lectura.Leer;

/**
 *
 * @author Lara Vazquez Dorna
 */
public class EX13_Ficheros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //instanciar un objeto de tipo leer
        Leer obxLeer = new Leer();
        //intancair objeto tipo escribir
        Escribir obxEscribir = new Escribir();
        // Se crea un objeto de tipo fichero hay que darle la ruta si no esta en la 
        //carpeta del proyecto
        File f = new File("nomes.txt");
        File c = new File("nomesComas.txt");
        File n = new File("numeros.txt");
        File a = new File("Alumnos.txt");

        //crear arrayList 
        ArrayList<Integer> numeros = new ArrayList<>();
        ArrayList<Alumno> alumnos = new ArrayList<>();

        //se lee el fichero simplemente en el metodo esta capturada la excepcion
        obxLeer.leerPalabras(f);

        //capturamos la excepcion lanzada en el metodo
        try {
            obxLeer.leerLineas(f);
        } catch (FileNotFoundException ex) {
            System.out.println("Error! el fichero no existe");
        }

        //leemos el fichero con delimitador
        obxLeer.leerDelimitador(c);

        //leemos y guardamos en un arrayList
        numeros = obxLeer.LeerNumeros(n, numeros);
        //mostrar el array
        System.out.println(numeros);
        try {
            //llamamos al fichero alumnos que tiene una Strng y un numero
            obxLeer.leerLineas(a);
        } catch (FileNotFoundException ex) {
            System.out.println("Error! el fichero no existe");
        }

        //leer el objeto
        System.out.println("**************************"
                + "\nleer el array objeto");
        obxLeer.leerObxetos(a);
//falta guardar en array alumnos y crear los alumnos

//escribir en un fichero de numeros
        obxEscribir.escribirNumeros("num");

    }

}

/**
 *Clase con metodos de escritura para ficheros
 */
package escritura;

import ex13_ficheros.Alumno;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.PedirDatos;

/**
 *
 * @author lvazquezdorna
 */
public class Escribir {

    File fich = null;
    PrintWriter f = null;

    public File escribirNumeros(String nomeFich) {
        fich = new File(nomeFich + ".txt");
        //cuando abrimos el fichero para escribir puede no existir entonces lo crea
        // si existe lo machaca y vuelve a empezar a escribir desde el principio SOBREESCRIBE
        //Si quieres añadir hay que usar otro metodo
        try {
            //abrir flujo de escritura
            f = new PrintWriter(fich);
            f.println(PedirDatos.entero(nomeFich));
            f.println(PedirDatos.entero(nomeFich));
            f.println(PedirDatos.entero(nomeFich));

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            f.close();
        }

        return fich;
    }

    //metodo que escribe un objeto
    public void escribirLineas(String nomeFich, ArrayList<Alumno> lista) {
        try {
            f = new PrintWriter(new File(nomeFich + ".txt"));
            for (Alumno al : lista) {
                f.println(al.getNome() + " " + al.getNota());
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            f.close();
        }
    }

    public void engadir (String nomeFich){
        try {
            //filewriter añade a un fichero: continua escribiendo donde el fichero está vacio
            f = new PrintWriter(new FileWriter(nomeFich+".txt",true));
            Alumno a = new Alumno(PedirDatos.cadena("nombre"), PedirDatos.entero("nota"));
            f.println(a);
        } catch (IOException ex) {
           System.out.println(ex.getMessage());
        }finally {
            f.close();
        }
    
    }
    transient 
    
    
}

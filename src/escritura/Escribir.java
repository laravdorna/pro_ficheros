/**
 *Clase con metodos de escritura para ficheros
 */
package escritura;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
}

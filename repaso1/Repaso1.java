/*
Realizar un programa que cree un hilo, que a su vez cree otro hilo,
y así consecutivamente, hasta un total de cinco hilos.
Cada hilo debe presentar su nombre indicando que ha comenzado,
crear su hilo hijo y presentar su nombre 10 veces indicando que se está procesando,
esperando un tiempo aleatorio entre 100 y 600 milisegundos entre cada presentación. 
Cada hilo deberá esperar a que su hijo termine antes de presentar su último mensaje indicando su nombre 
y que ha terminado.


 */
package repaso1;

/**
 *
 * @author findag
 */
public class Repaso1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // Creamos un objeto de la clase Hilo que sera el encargado de empezar la creacion de nuestros hilos.
        Hilo padre = new Hilo("Padre");
        
        // Iniciamos nuestro hilo "Padre".
        padre.start();
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repaso1;

/**
 *
 * @author findag
 */
public class Hilo extends Thread
{
    // Creamos una variable static de tipo int que nos ira marcando el numero del hilo con el que estamos trabajando.
    static int numeroHilo = 1;
    
    // Definimos un objeto de tipo hilo que llamaremos hijo.
    Hilo hijo;
    
    // Creamos un costructor de nuestra clase Hilo que recibira como parametro un String
    // De esta manera podremos invocar a getName para conocer el hilo en el que estamos.
    public Hilo(String nombre)
    {
        super(nombre);
    }
    
    /*
    *   Este metodo es COMPLETAMENTE NECESARIO a la hora de trabajar con hilos, es donde definimos el trabajo
    *   a realizar de cada uno de nuestros hilos.
    */
    @Override
    public void run()
    {
        System.out.println("Empezo el hilo: " + getName());
        // Este if nos servira para que nuestro total de hilos sea 5; 4 que se crearan aqui mas nuestro hilo padre.
        if(numeroHilo < 5)
        {
            /*  Instanciamos nuestro objeto de tipo hilo pasandole un parametro de tipo String agregandole nuestra
            *   variable numeroHilo para identificarlo, despues sumaremos 1 a dicha variable y lanzamos el hilo.
            */
            
            hijo = new Hilo("hijo" + numeroHilo);
            numeroHilo = numeroHilo + 1;
            hijo.start();
            
            /*  Ponemos un join porque nos interesa que hasta que no termine el ultimo hilo que lanzamos no se ejecute
            *   el anterior, los join siempre requieren estar en un try - catch.
            */
            try
            {
                hijo.join();
            }
            catch (InterruptedException ex)
            {
                System.out.println("Hilo " + getName() + " interrumpido");
            }
        }
        
        // Este bucle for sera el encargado de repetir nuestro hilo las 10 veces solicitadas.
        for(int i = 0; i < 10; i++)
        {
            System.out.println("Procesando hilo " + getName());
            try
            {
                sleep((long)(Math.random() * (600 - 100) + 100));
            }
            catch (InterruptedException ex)
            {
                System.out.println("Error en el seep del hilo " + getName() + "en la vuelta " + i);
            }
        }
        
        // Una vez finaliza nuestro bucle nuestro hilo termina mostrando un mensaje de finalizacion.
        System.out.println("Fin del hilo " + getName());
    }
        
        
    
}

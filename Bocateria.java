import java.util.HashMap;
import java.util.Collection;
import java.util.Iterator;
/**
 * Clase que define la administración de una bocateria
 * 
 * @author (Juan Carlos Aragón) 
 * @version (1.0)
 */
public class Bocateria
{
   private Cliente primeraPersonaEnCola;
   private int facturacionActual;
   private HashMap<Integer,Cliente> clientesDespachados;
   private static final int PRECIO_BOCADILLO = 5;
   
   /**
    * Constructor de Bocatería, inicializa sus atributos
    */
   public Bocateria(){
       primeraPersonaEnCola = null;
       facturacionActual = 0;
       clientesDespachados = new HashMap();
    }
    
   /**
    * Añade un nuevo cliente a la cola
    * 
    * @param numeroDeBocadillos la cantidad de bocadillos que pide
    */
   public void llegaNuevoClienteALaCola(int numeroDeBocadillos){
       if(primeraPersonaEnCola == null){
           primeraPersonaEnCola = new Cliente(numeroDeBocadillos);
        }
        else{
            //Seleccionamos la penultima persona en cola
            Cliente penultimo = primeraPersonaEnCola;
            while(penultimo.getSiguienteEnLaCola() != null){
                penultimo = penultimo.getSiguienteEnLaCola();
            }
            //Añadimos a la ultima persona detras del penultimo
            penultimo.setSiguienteEnLaCola(new Cliente(numeroDeBocadillos));
        }
       
    }
    
   /**
    * Muestra datos por pantalla de los clientes en cola
    */
   public void visualizaDatosClientesEnCola(){
       System.out.println(primeraPersonaEnCola.toString() + "(" + (primeraPersonaEnCola.getNumeroDeBocadillos() * PRECIO_BOCADILLO) +
                            " euros)");
       
       Cliente siguienteCliente = primeraPersonaEnCola.getSiguienteEnLaCola();
       while(siguienteCliente != null){
           System.out.println(siguienteCliente.toString()+ "(" + (siguienteCliente.getNumeroDeBocadillos() * PRECIO_BOCADILLO) +
                            " euros)");
           siguienteCliente = siguienteCliente.getSiguienteEnLaCola();
        }
    }
   
   /**
    * Cobra al cliente Actual
    */
   public void despacharClienteActual(){
       if(primeraPersonaEnCola != null){
           //Cobramos al cliente
           facturacionActual += primeraPersonaEnCola.getNumeroDeBocadillos() * PRECIO_BOCADILLO;
           //Incluimos al cliente en los clientes despachados
           clientesDespachados.put(primeraPersonaEnCola.getNumeroCliente(), primeraPersonaEnCola);
           //Desplazamos al segundo en la cola a la primera posicion
           primeraPersonaEnCola = primeraPersonaEnCola.getSiguienteEnLaCola();
        }
    }
    
   /**
    * Muestra por pantalla los datos de la bocateria
    */
   public void visualizaDatosBocateria(){
       System.out.println("Facturación actual: " + facturacionActual + " euros.");
       System.out.println("Estadode la cola:");
       visualizaDatosClientesEnCola();
       System.out.println("Clientes despachados:");
       //Imprimimos todos los clientes ya despachados
       Iterator<Cliente> it = clientesDespachados.values().iterator();
       while(it.hasNext()){
           System.out.println(it.next().toString());
        }
       
       
    }
    
   /**
    * Devuelve la posición en cola del cliente con mas bocadillos
    * 
    * @return posicion de esa persona en la cola
    */
   public int getPosicionPrimerClienteConMasBocadillos(){
       int posicion = 0;
       
       return posicion;
    }
    
   /**
    * Elimina de la cola al cliente con un determinado id
    * 
    * @param id numero de cliente que se va
    */
   public void clienteAbandonaCola(int id){
    }
    
   /**
    * Ordena la Cola por el numero de bocadillos que ha pedido cada uno de los clientes
    * 
    */
   public void ordenarColaPorNumeroDeBocadillos(){
       
    }
}

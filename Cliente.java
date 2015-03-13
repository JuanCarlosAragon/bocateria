
/**
 * Clase que representa al cliente de una bocatería, asigna el número de cliente, y cada cliente sabe cual es su siguiente.
 * 
 * @author (Juan Carlos Aragón) 
 * @version (1.0)
 */
public class Cliente
{
   private int numeroCliente;
   private Cliente siguienteEnLaCola;
   private int numeroDeBocadillos;
   private static int numeroClienteActual = 1;
   
   /**
    * Constructor de Cliente, inicializa al objeto cliente asignandole su número de cliente
    * 
    * @param numeroDeBocadillos Número de bocadillos que pide el cliente
    */
   public Cliente(int numeroDeBocadillos){
       //Asignamos el número de cliente e incrementamos el contador
       numeroCliente = numeroClienteActual;
       numeroClienteActual++;
       
       //Inicializa el resto de atributos
       siguienteEnLaCola = null;
       this.numeroDeBocadillos = numeroDeBocadillos;
    }
    
   /**
    * Devuelve el Cliente que va después de él
    * 
    * @return El siguiente Cliente
    */
   public Cliente getSiguienteEnLaCola(){
       return siguienteEnLaCola;
    }
    
   /**
    * Devuelve la cantidad de bocadillos que ha pedido
    * 
    * @return numero de bocadillos que ha pedido
    */
   public int getNumeroDeBocadillos(){
       return numeroDeBocadillos;
    }
   
   /**
    * Devuelve el numero de cliente
    * 
    * @return numero de Cliente
    */
   public int getNumeroCliente(){
       return numeroCliente;
    }
    
   /**
    * Devuelve un String con los atributos del cliente
    * 
    * @return un String con las características del cliente
    */
   public String toString(){
       String infoCliente = "Cliente " + getNumeroCliente() + ": " + getNumeroDeBocadillos() +
                            " bocadillo/s ";
       return infoCliente;
    }
    
    /**
     * Fija el cliente que va por detrás de él
     * 
     * @param cliente El Cliente que va detras en la cola
     */
    public void setSiguienteEnLaCola(Cliente cliente){
        siguienteEnLaCola = cliente;
    }
}

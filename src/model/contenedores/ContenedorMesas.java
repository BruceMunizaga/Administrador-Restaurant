package src.model.contenedores;

import edu.princeton.cs.stdlib.StdOut;
import src.model.Mesa;
import src.model.herenciaPersona.Cliente;

public class ContenedorMesas {

    private final Mesa[] mesas;

    private int cantActual;
    private final int cantMaxima;

    /**
     * The constructor
     *
     * @param cantMaxima a inicializar
     */
    public ContenedorMesas(int cantMaxima) {

        if (cantMaxima <= 0){

            throw new NumberFormatException("No se pueden crear contenedores con posiciones menores o iguales que cero");
        }else{
            this.cantMaxima = cantMaxima;
            mesas = new Mesa[cantMaxima];
            this.cantActual = 0;
        }
    }

    /**
     * Funcion que agregara una nueva mesa al contenedor
     *
     * @param nuevaMesa a agregar
     * @return true si pudo agregarlo
     */
    public boolean agregarMesa(Mesa nuevaMesa){
        if (this.cantActual == this.cantMaxima){
            System.out.println("Cantidad maxima alcanzada, no se pudo agregar la nueva mesa.");
        }else{
            if (this.cantActual == 0){
                this.mesas[0] = nuevaMesa;
                this.cantActual++;
                return true;
            }else{
                for (int i = 0; i < this.cantMaxima; i++) {
                    if (this.mesas[i] == null){
                        this.mesas[i] = nuevaMesa;
                        this.cantActual++;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Funcion que obtendra una mesa en funcion de su numero
     *
     * @param numeroMesa a buscar
     * @return true si encontro la mesa
     */
    public Mesa obtenerMesa(int numeroMesa){
        if (this.cantActual == 0){
            System.out.println("No hay mesas registradas.");
        }else{
            for (Mesa mesa: this.mesas) {
                if(mesa.getNumeroMesa() == numeroMesa){
                    return mesa;
                }
            }
            System.out.println("Mesa no encontrada.");
        }
        return null;
    }
}

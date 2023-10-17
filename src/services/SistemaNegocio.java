package src.services;

public interface SistemaNegocio {

    /**
     * procedimiento que cargara la informaicion al sistema
     */
    void cargarInformacion();

    /**
     * procedimiento que actualizar el stock en el inventario
     */
    void actualizarStock();

    /**
     * procedimiento que desplegara el inventario por pantalla
     */
    void verInventario();

    /**
     * procedimiento que agregara un producto nuevo al inventario
     */
    void agregarProducto();

    /**
     * procedimiento que eliminara un producto  del inventario escogido por el usuario
     */
    void eliminarUnProducto();

    /**
     * procedimiento que desplegara a los trabajadores en pantalla
     */
    void verTrabajadores();

    /**
     * procedimiento que renovara el contrato de un trabajador
     */
    void renovarContrato();

    /**
     * procedimiento para finalizar el contrato de un trabajador
     */
    void finalizarContrato();

    /**
     * procedimiento para otorgar el contrato indefinido a un trabajador
     */
    void otorgarIndefinido();

    /**
     * procedimiento que registrara a los clientes nuevos
     */
    void registrarCliente();

    /**
     * procedimiento que desplegara el status de sus mesas en pantalla
     */
    void desplegarMesas();

    /**
     * Procedimiento que desplegara una mesa en especifico
     */
    void verMesa();

    /**
     * Procedimiento que desplegara a los clientes registrados
     */
    void verClientes();

    /**
     * procedimiento que aumentar la orden del cliente registrado
     */
    void aumentarOrden();

}

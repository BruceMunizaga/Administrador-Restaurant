package src.model;

public abstract class Persona {
    private String nombre;
    private int edad;

    /**
     * The constructor
     * @param nombre a inicializar
     * @param edad a inicializar
     */
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getEdad() {
        return this.edad;
    }
}

package Modelo;
import Control.Control;

public class Comprador extends Persona{
    private Control control;
    private String funcion;
    private String correo;
    private int numBoletas;

    public Comprador(Control con, String funcion, String correo, int numBoletas, String cedula, String nombre, String telefono) {
        super(cedula, nombre, telefono);
        this.control = con;
        this.funcion = funcion;
        this.correo = correo;
        this.numBoletas = numBoletas;
    }

    public Object getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getNumBoletas() {
        return numBoletas;
    }

    public void setNumBoletas(int numBoletas) {
        this.numBoletas = numBoletas;
    }
}
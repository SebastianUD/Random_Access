package Modelo;

public class Vino {

    // Atributos del cliente
    private String id;
    private Object color;
    private String marca;
    private Object edad;

    // Si es su responsabilidad, pone y dice sus datos

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getColor() {
        return color;
    }

    public void setColor(Object color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Object getEdad() {
        return edad;
    }

    public void setEdad(Object edad) {
        this.edad = edad;
    }


}
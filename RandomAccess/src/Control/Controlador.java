package Control;

import Modelo.Vino;
import Vista.Interfaz;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

    // Objetos vista y modelo
    private Interfaz vista;
    private Vino modelo;
    ArrayList<Vino> lista = new ArrayList<>();
    private int posicion = -1;

    // Constructor para inicializar la vista
    public Controlador() {

        this.vista = new Interfaz(this);//Copia de sí mismo


        // Le envia la referencia del listener al boton de la vista
        this.vista.btnInsertar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnSalir.addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.vista.btnInsertar) {
            if (this.vista.insertId.getText().equals("") && this.vista.insertMarca.getText().equals("") && this.vista.insertColor.getSelectedItem().equals("None") && this.vista.insertEdad.getSelectedItem().equals("None")) {
                this.vista.msgInsertar("");
            } else {
                boolean comprobar;
                // Llama al método crear vino, enviando como parámetros lo que se llene en los JTextField, crea el vino y retorna un booleano
                comprobar = crearVino(this.vista.insertId.getText(), this.vista.insertMarca.getText(), this.vista.insertColor.getSelectedItem(), this.vista.insertEdad.getSelectedItem());
                // Envía el booleano comprobar, para enviar el mensaje de si se pudo añadir o no
                this.vista.msgdevino(comprobar);
            }
        }

        if (e.getSource() == this.vista.btnLimpiar) {
            this.vista.blanquearCampos();
        }

        if (e.getSource() == this.vista.btnBuscar) {
            // Obtiene el id del vino a buscar
            String id = this.vista.consId.getText();
            // Busca el vino en la lista
            buscarVino(id);
            // Muestra los datos del vino si se encuentra en la lista
            if (!lista.isEmpty() && lista.get(posicion).getId().equals(id)) {
                this.vista.consMarca.setText(lista.get(posicion).getMarca());
                this.vista.consColor.setText((String) lista.get(posicion).getColor());
                this.vista.consEdad.setText((String) lista.get(posicion).getEdad());
            } else if (lista.isEmpty()) {
                // Muestra un mensaje en la interfaz gráfica si la lista está vacía
                this.vista.msgVacio(id);
            } else if (vista.consId.getText().isEmpty()) { //Si le da en buscar y no ha ingresado vinos
                this.vista.msgIngresar(id);
            } else {
                // Muestra un mensaje en la interfaz gráfica si el vino no se encuentra en la lista
                this.vista.msgInexistente(id);
            }
        }

        if (e.getSource() == this.vista.btnSalir) {//Cerrar la ventana
            this.vista.dispose();
        }
    }

    // Recibe datos de la vista para crear el modelo
    public boolean crearVino(String id, String marca, Object color, Object edad) {

        int comprobar = -1;

        // Se crea el vino ingresado
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId().equals(id)) { //Recorre los elementos de la lista para comprobar que no se repita ID
                comprobar = 0; //Cambia el valor de comprobar para identificar que ya existe un vino con ese ID
            }
        }

        if (comprobar == -1) { // Si la variable comprobar no ha cambiado, significa que el vino aún no existe
            modelo = new Vino();
            modelo.setId(id);
            modelo.setMarca(marca);
            modelo.setColor(color);
            modelo.setEdad(edad);

            lista.add(modelo);  // Añade a la lista de vinos el vino ingresado
            return true; // True, para indicar que se pudo agregar
        } else {
            return false; // False, para indicar que no se agregó porque ya existe
        }
    }

    // Busca los vinos
    public void buscarVino(String id) {
        posicion = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId().equals(id)) { // Compara si en algún elemento de la lista ya está ingresado algún ID del mismo tipo
                posicion = i; // Guarda la posición en la que se encuentra el ID
                break;
            }
        }
    }
}

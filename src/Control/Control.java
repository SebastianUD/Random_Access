package Control;

import Vista.Interfaz;
import Modelo.Comprador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control implements ActionListener{

    private Interfaz interfaz;
    private Comprador comprador;

    public Control() {
        interfaz = new Interfaz(this);
        comprador = new Comprador(this,"","",1,"","","");
        this.interfaz.insertFuncion.addActionListener(this);
        this.interfaz.insertCedula.addActionListener(this);
        this.interfaz.insertNombre.addActionListener(this);
        this.interfaz.insertCorreo.addActionListener(this);
        this.interfaz.insertTelefono.addActionListener(this);
        this.interfaz.btnTerminar.addActionListener(this);
    }
    
    public void iniciar(){
        interfaz.setTitle("Festival estéreo picnic");
        interfaz.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
    // Aquí irá el código que se ejecutará cuando se realice una acción
    // en los elementos que están siendo escuchados por este ActionListener
    }
}

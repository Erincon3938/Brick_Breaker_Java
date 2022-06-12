package Principal;

import Clases.Ventana;

import javax.swing.*;
import java.awt.*;

public class Principal {

    public static void main(String[] args) {

        Ventana ventana = new Ventana() ;
        // Para que la ventana sea visible
        ventana.setVisible(true);
        // Poder Cerrar la Ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/Recursos/brick-breaker.png"));
        ventana.setIconImage(icon);

    }

}

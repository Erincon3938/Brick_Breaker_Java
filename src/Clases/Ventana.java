package Clases;
import javax.swing.*;

public class Ventana extends JFrame {

    public Ventana () {

        Gameplay gameplay = new Gameplay() ;
        // Titulo de la Pagina
        setTitle(" Brick Breaker");
        // Tamaño de la Ventana
        setBounds(10 , 10 , 700 , 600 ) ;
        // Ubicamos la Ventana en el Centro
        setLocationRelativeTo(null);
        setResizable(false);
        add (gameplay) ;

    }

}

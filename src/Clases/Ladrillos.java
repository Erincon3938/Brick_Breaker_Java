package Clases;
import java.awt.*;

public class Ladrillos {

    public int ladrillo [] [] ;
    public int Ancho_Ladrillo , Altura_Ladrillo ;

    public Ladrillos (int fila ,int columna) {

        ladrillo = new int[fila][columna] ;

        for (int i = 0; i < ladrillo.length; i++) {

            for (int j = 0; j < ladrillo [0].length; j++) {

                ladrillo [i] [j] = 1 ;

            }

        }

        Ancho_Ladrillo = 540 / columna ;
        Altura_Ladrillo = 150 / fila ;

    }

    public void Dibujar (Graphics2D g) {

        for (int i = 0; i < ladrillo.length; i++) {

            for (int j = 0; j < ladrillo [0].length; j++) {

                if (ladrillo [i] [j] > 0) {

                    Color myColor_06 = new Color(174 , 186 , 255  );
                    g.setColor(myColor_06) ;
                    g.fillRect(j * Ancho_Ladrillo + 80 , i * Altura_Ladrillo + 50 , Ancho_Ladrillo , Altura_Ladrillo);

                    g.setStroke(new BasicStroke(3));
                    Color myColor_01 = new Color(69, 69, 69);
                    g.setColor(myColor_01) ;
                    g.drawRect(j * Ancho_Ladrillo + 80 , i * Altura_Ladrillo + 50 , Ancho_Ladrillo , Altura_Ladrillo);

                }

            }

        }

    }

    public void Valor_Ladrillo (int valor , int fila , int columna ) {

        ladrillo [fila] [columna] = valor;

    }

}

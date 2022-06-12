package Clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener ;
import java.awt.event.KeyEvent ;
import java.awt.event.KeyListener ;
import javax.swing.Timer ;


public class Gameplay extends JPanel implements KeyListener , ActionListener {

    private boolean play = false ;
    private Timer timer ;

    private int score = 0 ;
    private int Total_Bricks = 21 ;
    private int delay = 6 ;

    private int Player_X = 310 ;
    private int Ball_PosX = 120 ;
    private int Ball_PosY = 350 ;

    private int Ball_XDir = -1 ;
    private int Ball_YDir = -2 ;

    private Ladrillos ladrillo ;

    public Gameplay () {

        ladrillo = new Ladrillos(3 , 7) ;
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer (delay , this) ;
        timer.start();


    }

    @Override
    public void paintComponent(Graphics g) {

        // Fondo

        Color myColor_01 = new Color(69, 69, 69);
        g.setColor(myColor_01);
        g.fillRect(1,1,692,592);

        // Dibujando Ladrillos

        ladrillo.Dibujar((Graphics2D)g);

        // Bordes

        Color myColor_02 = new Color(169, 169, 169);
        g.setColor(myColor_02) ;
        g.fillRect(0,0,3,592);
        g.fillRect(0,0,692,3);
        //g.fillRect(0,558,692,3);
        g.fillRect(681,0,3,592);

        // Score
        Color myColor_03 = new Color(255, 126, 153) ;
        g.setColor(myColor_03) ;
        g.setFont(new Font("Fira Code" , Font.BOLD , 25));
        g.drawString(""+score , 590 , 35);

        // Raqueta

        Color myColor_04 = new Color(163, 255, 126) ;
        g.setColor(myColor_04) ;
        g.fillRect(Player_X , 540 , 100 , 8);

        // Pelota

        Color myColor_05 = new Color(255, 255, 150) ;
        g.setColor(myColor_05) ;
        g.fillOval(Ball_PosX , Ball_PosY , 20 , 20);

        if (Total_Bricks <= 0 ) {

            play = false ;
            Ball_XDir = 0 ;
            Ball_YDir = 0 ;

            Color myColor_06 = new Color(139, 204, 255 ) ;
            g.setFont(new Font("Fira Code" , Font.BOLD , 30));
            g.setColor(myColor_06) ;
            g.drawString("Ganaste" , 280 , 320);

            Color myColor_07 = new Color(255, 155, 155 ) ;
            g.setColor(myColor_07) ;
            g.setFont(new Font("Fira Code" , Font.BOLD , 30));
            g.drawString("Presiona Enter para Jugar de Nuevo " , 83 , 380);

        }


        if (Ball_PosY > 560) {
            play = false ;
            Ball_XDir = 0 ;
            Ball_YDir = 0 ;

            Color myColor_06 = new Color(139, 204, 255 ) ;
            g.setFont(new Font("Fira Code" , Font.BOLD , 30));
            g.setColor(myColor_06) ;
            g.drawString("Juego Acabado , Puntuaje : "+score , 120 , 320);

            Color myColor_07 = new Color(255, 155, 155 ) ;
            g.setColor(myColor_07) ;
            g.setFont(new Font("Fira Code" , Font.BOLD , 30));
            g.drawString("Presiona Enter para Jugar de Nuevo " , 83 , 380);

        }

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        timer.start();

        if (play) {



            if (new Rectangle(Ball_PosX , Ball_PosY , 20 , 20 ).intersects(new Rectangle(Player_X , 540 , 100 , 8))) {

                Ball_YDir = - Ball_YDir ;
            }

            A : for (int i = 0; i < ladrillo.ladrillo.length; i++) {

                for (int j = 0; j < ladrillo.ladrillo [0].length ; j++) {

                    if (ladrillo.ladrillo [i] [j] > 0) {

                        int Ladrillo_X = j * ladrillo.Ancho_Ladrillo + 80 ;
                        int Ladrillo_Y = i * ladrillo.Altura_Ladrillo + 50 ;
                        int Ancho_Ladrillo = ladrillo.Ancho_Ladrillo ;
                        int Altura_Ladrillo = ladrillo.Altura_Ladrillo ;

                        Rectangle rect = new Rectangle(Ladrillo_X , Ladrillo_Y ,  Ancho_Ladrillo , Altura_Ladrillo);
                        Rectangle ballRect = new Rectangle(Ball_PosX , Ball_PosY , 20 , 20);
                        Rectangle ladrilloRect = rect ;

                        if (ballRect.intersects(ladrilloRect)) {

                            ladrillo.Valor_Ladrillo(0 , i , j);
                            Total_Bricks -- ;
                            score += 5 ;

                            if (Ball_PosX + 19 <= ladrilloRect.x || Ball_PosX + 1 >= ladrilloRect.x + ladrilloRect.width ) {

                                Ball_XDir = - Ball_XDir ;

                            }

                            else  {

                                Ball_YDir = -Ball_YDir ;

                            }

                            break A ;
                        }

                    }

                }

            }

            Ball_PosX += Ball_XDir ;
            Ball_PosY += Ball_YDir ;

            if (Ball_PosX < 0) {

                Ball_XDir = -Ball_XDir ;

            }

            if (Ball_PosY < 0) {

                Ball_YDir = -Ball_YDir ;

            }

            if (Ball_PosX > 670) {

                Ball_XDir = -Ball_XDir ;

            }

        }

        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {

        int id = e.getKeyCode() ;

        // Derecha

        if (id == KeyEvent.VK_D) {

            if (Player_X >= 600) {

                Player_X = 580 ;

            }

            else {

                move_Right () ;
            }

        }

        // Izquierda

        if (id == KeyEvent.VK_A) {

            if (Player_X < 10) {

                Player_X = 10 ;

            }

            else {

                move_Left () ;
            }

        }

        if (id == KeyEvent.VK_ENTER) {

            if (!play) {

                play = true ;
                Ball_PosX = 120 ;
                Ball_PosY = 350 ;
                Ball_XDir = -1 ;
                Ball_YDir = - 2 ;
                Player_X = 310 ;
                score = 0 ;
                Total_Bricks = 21 ;
                ladrillo = new Ladrillos(3 , 7) ;
                repaint();

            }

        }

    }

    public void move_Right () {

        play = true ;
        Player_X += 60 ;

    }



    public void move_Left () {

        play = true ;
        Player_X -= 60 ;

    }

    @Override
    public void keyReleased(KeyEvent e) {}


}

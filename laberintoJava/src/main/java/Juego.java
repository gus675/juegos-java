import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Juego extends JPanel{
    Laberinto laberinto=new Laberinto();
    Personaje personaje= new Personaje();
    public static int nivel=1;

    public Juego() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {


            }

            @Override
            public void keyPressed(KeyEvent e) {
                personaje.teclapresionada(e);

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
     });
        setFocusable(true);
    }

    public void paint(Graphics graphics){
        laberinto.paint(graphics);
        personaje.paint(graphics);

    }

    public static int cambiaNivel(){
        return nivel++;
    }

    public static int obtieneNivel(){
        return nivel;
    }

    public static void main(String[]args){
        JOptionPane.showMessageDialog(null,"¿Estás listo?");
        JFrame miVentana = new JFrame("Laberinto");
        Juego game = new Juego();
        miVentana.add(game);
        miVentana.setSize(920,540);
        miVentana.setLocation(300,200);
        miVentana.setVisible(true);
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true){
            try{
                Thread.sleep(10);
            }catch (InterruptedException ex){
                Logger.getLogger(Juego.class.getName()).log(Level.SEVERE,null,ex);
            }
            game.repaint();

            if(obtieneNivel()>3){
                JOptionPane.showMessageDialog(null,"Bye Bye");
                System.exit(0);

            }


        }
    }


}

package org.example.elementos;

import javax.swing.*;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static int reiniciaJuego=-1;

    public static void main(String[]args){
        JOptionPane.showMessageDialog(null, "¿Estas listo?");

        JFrame ventana = new JFrame("Jueguito");
        Juego jueguito = new Juego();
        ventana.add(jueguito);
        ventana.setSize(1300,400);
        ventana.setLocation(70,200);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            if(jueguito.juegoFinalizado){
                reiniciaJuego=JOptionPane.showConfirmDialog(null,"Has perdido... ¿Quieres jugar de nuevo?","Has perdido...", JOptionPane.YES_NO_OPTION);
                if(reiniciaJuego==0){
                    reiniciValores();
                } else if (reiniciaJuego==1) {
                    System.exit(0);
                }
            }else{
                jueguito.repaint();
                try{
                    Thread.sleep(10);
                }catch (InterruptedException ex){
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(Juego.pierdeVida==true){
                    JOptionPane.showMessageDialog(null, "Cuidado!!");
                    Juego.pierdeVida=false;
                    Juego.vidas--;
                    Auto.y_inicial=270;
                    Auto.saltando=false;
                    Obstaculo.x_inicial=1300;
                }
            }
        }
    }
    public static void reiniciValores(){
        Juego.juegoFinalizado=false;
        Obstaculo.x_auxiliar=-4;
        Juego.puntos=0;
        Juego.nivel=1;
        Juego.vidas=3;
        reiniciaJuego=-1;
        Obstaculo.x_inicial=1300;
    }

}
import java.awt.*;
import java.awt.event.KeyEvent;

public class Personaje {
    Laberinto lab=new Laberinto();
    int x=40;
    int y=40;
    int ancho=40;
    int alto=40;
    int movimiento=40;

    public void paint(Graphics graphics){
        graphics.setColor(Color.red);
        graphics.fillOval(x,y,ancho,alto);
        graphics.setColor(Color.black);
        graphics.drawOval(x,y,ancho,alto);

        //ojos
        graphics.setColor(Color.white);
        graphics.fillOval(x+7,y+8,13,13);
        graphics.fillOval(21,8,13,13);
        graphics.setColor(Color.black);
        graphics.fillOval(11,12,5,5);
        graphics.fillOval(25,12,5,5);

        //boca
        graphics.setColor(Color.black);
        graphics.fillOval(x+7,y+24,27,7);


    }

    public void teclapresionada(KeyEvent event){
        int [][] laberinto= lab.obtieneLaberinto();

        if(event.getKeyCode()==37){//izquierda
            if(laberinto[y/40][(x/40)-1]!=1){
                x=x-movimiento;
            }
        }

        if(event.getKeyCode()==39) {//derecha
            if (laberinto[y / 40][(x / 40) + 1] != 1) {
                x = x + movimiento;
            }
        }

        if(event.getKeyCode()==40) {//abajo
            if (laberinto[(y / 40) + 1][x / 40] != 1) {
                y = y + movimiento;
            }
        }
        if(event.getKeyCode()==38){//arriba
            if(laberinto[(y/40)-1][x/40]!=1){
                y=y-movimiento;
            }
        }
        //si llega al final
        if(x==840 && y==440){
            Juego.cambiaNivel();
            x=40;
            y=40;
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

/**
 *
 * @author Oscar Garzon
 */
import Logica.Juego;
import javax.swing.*;
import java.awt.*;

public class FPrincipal extends JFrame {

    private Juego juegoPacman;
    private PDibujo panelDibujo;
    private PControles panelControles;
    private PInformacion panelInformacion;

    public FPrincipal() {
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(205, 300);
        this.setTitle("Pacman");
        this.juegoPacman = new Juego();
        this.setLayout(new BorderLayout());
        this.panelDibujo = new PDibujo();
        this.getContentPane().add(this.panelDibujo, BorderLayout.CENTER);
        this.panelControles = new PControles(this.juegoPacman);
        this.getContentPane().add(this.panelControles, BorderLayout.SOUTH);
        this.panelInformacion = new PInformacion();
        this.getContentPane().add(this.panelInformacion, BorderLayout.NORTH);
        this.juegoPacman.addObserver(this.panelDibujo);
        this.juegoPacman.addObserver(this.panelInformacion);
        this.juegoPacman.notificar();
    }

    public Juego getJuego() {
        return this.juegoPacman;
    }

    public static void main(String[] args) {
        FPrincipal frame = new FPrincipal();
        frame.setVisible(true);
        
    }
}

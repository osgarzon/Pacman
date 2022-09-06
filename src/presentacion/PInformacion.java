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
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PInformacion extends JPanel implements Observer {
    private JLabel puntos;
    public PInformacion() {
        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createTitledBorder("Informacion"));
        this.puntos = new JLabel("Puntos: ");
        this.add(puntos);
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        this.puntos.setText("Puntos: " + ((Juego) arg1).getPuntos());
    }
}


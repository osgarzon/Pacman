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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PControles extends JPanel {

    private Juego juego;
    private JButton arriba;
    private JButton abajo;
    private JButton derecha;
    private JButton izquierda;
    private JLabel espacio1;
    private JLabel espacio2;

    public PControles(Juego juego) {
        this.juego = juego;
        this.setLayout(new GridLayout(2, 3, 0, 0));
        this.setBorder(BorderFactory.createTitledBorder("ControlesPacman"));
        {
            this.espacio1 = new JLabel("");
            this.add(this.espacio1);
            this.arriba = new JButton("^");
            this.arriba.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    arribaActionPerformed(evt);
                }
            });
            this.add(arriba);
            this.espacio2 = new JLabel("");
            this.add(this.espacio2);
        }
        {
            this.izquierda = new JButton("<");
            this.izquierda.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    izquierdaActionPerformed(evt);
                }
            });
            this.add(izquierda);
        }
        {
            this.abajo = new JButton("v");
            this.abajo.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    abajoActionPerformed(evt);
                }
            });
            this.add(abajo);
        }
        {
            this.derecha = new JButton(">");
            this.derecha.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    derechaActionPerformed(evt);
                }
            });
            this.add(derecha);
        }
        
    }

    private void arribaActionPerformed(ActionEvent evt) {
        this.juego.arriba();
    }

    private void abajoActionPerformed(ActionEvent evt) {
        this.juego.abajo();
    }

    private void derechaActionPerformed(ActionEvent evt) {
        this.juego.derecha();
    }

    private void izquierdaActionPerformed(ActionEvent evt) {
        this.juego.izquierda();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author Oscar Garzon
 */
public class Elemento {

    protected int x;
    protected int y;
    protected Image image;

    public Elemento(int x, int y, String inagen) {
        this.x = x;
        this.y = y;
        this.image = Toolkit.getDefaultToolkit().getImage(inagen);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

}

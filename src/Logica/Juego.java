/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.*;
import java.util.*;

/**
 *
 * @author Oscar Garzon
 */
public class Juego extends Observable {

    public final static int DETENIDO = -1;
    public final static int DERECHA = 0;
    public final static int ARRIBA = 1;
    public final static int IZQUIERDA = 2;
    public final static int ABAJO = 3;
    private Jugador comeGalletas;
    private ArrayList<Galleta> galletas;
    private ArrayList<Bloque> bloques;
    private int puntos;

    public Juego() {
        this.comeGalletas = new Jugador(0, 0);
        this.galletas = new ArrayList<Galleta>();
        this.bloques = new ArrayList<Bloque>();
        this.cargarBloques();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 7; j++) {
                if (!existeBloque(i, j)) {
                    this.galletas.add(new Galleta(i, j));
                }
            }
        }
        this.galletas.remove(0);
    }

    public Jugador getComeGalletas() {
        return comeGalletas;
    }

    public ArrayList<Galleta> getGalletas() {
        return galletas;
    }

    public ArrayList<Bloque> getBloques() {
        return bloques;
    }

    public int getPuntos() {
        return puntos;
    }

    private void cargarBloques() {
        File archivo = new File("res/bloques.properties");
        try {
            FileInputStream fis = new FileInputStream(archivo);
            Properties archivoPropiedades = new Properties();
            archivoPropiedades.load(fis);

            for (int i = 1; i <= 24; i++) {

                String dato = archivoPropiedades.getProperty("bloque" + i);
                String datos[] = dato.split(",");
                int y = Integer.parseInt(datos[0]);
                int x = Integer.parseInt(datos[1]);

                this.bloques.add(new Bloque(x, y));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean existeBloque(int x, int y) {
        for (Bloque b : this.bloques) {
            if (b.getX() == x && b.getY() == y) {
                return true;
            }
        }
        return false;
    }

    public void arriba() {
        if (!this.colisionBorde(Juego.ARRIBA) && !this.colisionBloque(Juego.ARRIBA)) {
            this.comeGalletas.arriba();
            this.colisionGalleta();
        }
        this.notificar();
    }

    public void abajo() {
        if (!this.colisionBorde(Juego.ABAJO) && !this.colisionBloque(Juego.ABAJO)) {
            this.comeGalletas.abajo();
            this.colisionGalleta();
        }
        this.notificar();
    }

    public void derecha() {
        if (!this.colisionBorde(Juego.DERECHA) && !this.colisionBloque(Juego.DERECHA)) {
            this.comeGalletas.derecha();
            this.colisionGalleta();
        }
        this.notificar();
    }

    public void izquierda() {
        if (!this.colisionBorde(Juego.IZQUIERDA) && !this.colisionBloque(Juego.IZQUIERDA)) {
            this.comeGalletas.izquierda();
            this.colisionGalleta();
        }
        this.notificar();
    }

    private boolean colisionBloque(int direccion) {
        int x = this.comeGalletas.getX();
        int y = this.comeGalletas.getY();
        for (Bloque bloque : this.bloques) {
            if ((direccion == Juego.DERECHA && bloque.getX() == x + 1 && bloque.getY() == y) || (direccion == Juego.ABAJO && bloque.getX() == x && bloque.getY() == y + 1) || (direccion == Juego.IZQUIERDA && bloque.getX() == x - 1 && bloque.getY() == y) || (direccion == Juego.ARRIBA && bloque.getX() == x && bloque.getY() == y - 1)) {
                return true;
            }
        }
        return false;
    }

    private boolean colisionBorde(int direccion) {
        int x = this.comeGalletas.getX();
        int y = this.comeGalletas.getY();
        if ((direccion == Juego.DERECHA && x == 9) || (direccion == Juego.ABAJO && y == 6) || (direccion == Juego.IZQUIERDA && x == 0) || (direccion == Juego.ARRIBA && y == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public void colisionGalleta() {
        Iterator<Galleta> iterator = this.galletas.iterator();
        while (iterator.hasNext()) {
            Galleta galleta = iterator.next();
            if (galleta.getX() == this.comeGalletas.getX() && galleta.getY() == this.comeGalletas.getY()) {
                this.puntos++;
                iterator.remove();
                return;
            }
        }
    }

    public void notificar() {
        this.setChanged();
        this.notifyObservers(this);
    }

}

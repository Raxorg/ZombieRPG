package com.jorgeluis.zombierpg;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class GestorPantallas {
	 
    private static GestorPantallas instancia;
 
    private Game game;
 
    private GestorPantallas() {
        super();
    }
 
    public static GestorPantallas getInstance() {
        if (instancia == null) {
        	instancia = new GestorPantallas();
        }
        return instancia;
    }
 
    public void inicializar(Game game) {
        this.game = game;
    }
 
    public void abrirPantalla(PantallasEnum pantallEnum, Object... params) {
 
        Screen pantallaActual = game.getScreen();
 
        AbstractScreen nuevaPantalla = pantallEnum.getScreen(params);
        nuevaPantalla.buildStage();
        game.setScreen(nuevaPantalla);
 
        if (pantallaActual != null) {
        	pantallaActual.dispose();        	
        }
    }
}
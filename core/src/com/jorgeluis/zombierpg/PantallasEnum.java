package com.jorgeluis.zombierpg;

public enum PantallasEnum {
	PANTALLA_INTRO{
	  public AbstractScreen getScreen(Object... params) {
            return new PantallaIntro();
        }
	},
    PANTALLA_PRINCIPAL {
        public AbstractScreen getScreen(Object... params) {
            return new PantallaPrincipal();
        }
    },
    PANTALLA_JUEGO1 {
        public AbstractScreen getScreen(Object... params) {
            return new PantallaJuego1();
        }
    };
 
    public abstract AbstractScreen getScreen(Object... params);
}
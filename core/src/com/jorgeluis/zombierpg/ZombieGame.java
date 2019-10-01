package com.jorgeluis.zombierpg;

import com.badlogic.gdx.Game;

public class ZombieGame extends Game {
	@Override
	public void create () {
		GestorPantallas.getInstance().inicializar(this);
		GestorPantallas.getInstance().abrirPantalla( PantallasEnum.PANTALLA_JUEGO1 );
	}
}

package com.jorgeluis.zombierpg;

import com.badlogic.gdx.graphics.PerspectiveCamera;

public class Camara extends PerspectiveCamera {

	Camara(int width, int height){
		super(35, width,height);

		//cam.fieldOfView = 45f;
		position.set(-15f/1f, 30f/1f, 15f/1f);
		direction.set(0.1f, -0.2f, -0.1f);
		near = 1f;
		far = 380f;	
	}
}

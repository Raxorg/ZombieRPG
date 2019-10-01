package com.jorgeluis.zombierpg;

import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.utils.AnimationController.AnimationDesc;
import com.badlogic.gdx.graphics.g3d.utils.AnimationController.AnimationListener;

public class PlayerZombie extends GameInstance {

	public PlayerZombie(Model model, TipoEntidad tipoEntidad) {
		super(model, tipoEntidad);
	}

	void quieto() {
		this.ctrl.animate("Armature|stand", 1, 1f, null, 0.01f);
	}

	public void caminar() {
		this.ctrl.animate("Armature|walk", 1, 1f, null, 0.03f);
	}

	public void rotar(float r) {

		this.transform.rotate(0, 1, 0, r);
		// ghostObject.setWorldTransform(characterTransform);
		caminar();
	}
}

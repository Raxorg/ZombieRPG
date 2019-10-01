package com.jorgeluis.zombierpg;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.utils.AnimationController;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;

public class GameObject extends ModelInstance {
	public AnimationController ctrl;
	public float radius;
	public boolean visible = true;
	public final Vector3 center = new Vector3();
	public final Vector3 dimensions = new Vector3();
	public float velocidad = 0f;
	public float tiempo = 0f;
	public Vector3 vel = new Vector3();
	public Vector3 pos = new Vector3();

	public BoundingBox bounds = new BoundingBox();

	public GameObject(Model model, String rootNode, boolean mergeTransform) {
		super(model, rootNode, mergeTransform);
		ctrl = new AnimationController(this);
		calculateBoundingBox(bounds);
		bounds.getCenter(center);
		bounds.getDimensions(dimensions);
		radius = dimensions.len() / 2f;

	}

	public GameObject(Model model) {
		super(model);
		ctrl = new AnimationController(this);
		calculateBoundingBox(bounds);
		bounds.getCenter(center);
		bounds.getDimensions(dimensions);
		radius = dimensions.len() / 3f;

	}

	public boolean isMove = false;
	public boolean isSelected = false;
	public int mouseX = 0;
	public int mouseY = 0;

	public float speed = 0.3f;
	public float disTo = 2f;
	Vector3 vSpeed = new Vector3();
	public Vector3 posTo = new Vector3();
	Vector3 v2 = new Vector3();
	Vector3 v3 = new Vector3();
	Vector3 v1 = new Vector3();
	double vangle;

	public void moveTo(float x, float y, float z, float disTo) {
		this.disTo = disTo;
		posTo.set(x, y, z);
		posTo.y = 0;
		vSpeed.set(posTo);
		v3.set(posTo);
		this.transform.getTranslation(v2);
		v3.sub(v2);
		float t = v3.dst(Vector3.Zero) / this.speed;
		v3.scl(1 / t);
		vSpeed.set(v3);
		vangle = Math.atan2(vSpeed.x, vSpeed.z);
		this.transform.setToRotation(0, 1f, 0, (float) (vangle * (180 / Math.PI)));
		this.transform.setTranslation(v2); /**/
		isMove = true;
	}

	public void movimiento(float delta) {
		this.transform.getTranslation(v1);
		v1.add(vSpeed.cpy().scl(delta));
		this.transform.setTranslation(v1);
		if (v1.dst(posTo) < disTo) {
			isMove = false;
		}
	}

	public void selected(int MouseX, int MouseY) {
		this.mouseX = MouseX;
		this.mouseY = MouseY;
		isSelected = true;
	}

	public void estatico() {
		isMove = false;
	}

	public void update(float delta) {

	}

	public void draw(float delta) {
		if (isMove == true)
			movimiento(delta);
		if (ctrl != null)
			ctrl.update(delta);

	}
}
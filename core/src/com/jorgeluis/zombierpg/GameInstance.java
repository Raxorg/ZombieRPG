package com.jorgeluis.zombierpg;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.math.Vector3;

public class GameInstance extends GameObject{
	String nombre;
	GameInstance target;
	TipoEntidad tipoEntidad; 
	Vector3 targetPos = new Vector3();
	public int maxParents = 0; 
	public int parents = 0;
	public int life = 70;
	public int stepLife = 2;
	int recursos[] = {0,0,0,0,0};
	
	public void addRecurso(int tipo, int cant){
		recursos[tipo] += cant;
	}
	public int getRecurso(int tipo){
		return recursos[tipo];
	}

	public GameInstance(Model model,TipoEntidad tipoEntidad) {
		super(model);
		this.tipoEntidad = tipoEntidad;
		
	}
	void setTarget(GameInstance target){
		this.target = target;
	}
	void removeTarget(){
		if (this.target!= null){
			this.target.parents--;
			this.target = null;
		}		
	}
}

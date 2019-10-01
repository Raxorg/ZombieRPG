package com.jorgeluis.zombierpg;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalShadowLight;
import com.badlogic.gdx.graphics.g3d.environment.PointLight;
import com.badlogic.gdx.graphics.g3d.utils.DepthShaderProvider;

public class Ambiente extends Environment {
	DirectionalShadowLight shadowLight;
	DirectionalLight directionalLight;
	ColorAttribute colorAmbiente;
	
	Ambiente(){
		set(new ColorAttribute(ColorAttribute.Fog, 0.92f/9, 0.73f/9, 0.40f/9, 1f));		
		//environment.set(new ColorAttribute(ColorAttribute.Fog, 0.02f, 0.3f, 0.40f, 1f));
		colorAmbiente = new ColorAttribute(ColorAttribute.AmbientLight, 0.6f, 0.6f, 0.6f, 1.f);
		directionalLight = new DirectionalLight().set(0.3f, 0.3f, 0.3f, -0.5f, -1f, 0.7f);
		set(colorAmbiente);
		add(directionalLight);
		//add(new PointLight().set(0.92f/1, 0.73f/1, 0.40f/1, 0, 10f, 0f, 150f));	
		add(new PointLight().set(0.92f/3, 0.73f/3, 0.40f/3, 0, 10f, 0f, 150f));
		shadowLight = new DirectionalShadowLight(2000, 2000, 60f, 60f, .001f, 150f);
		//shadowMap = shadowLight;
	}
}

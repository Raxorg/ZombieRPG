package com.jorgeluis.zombierpg;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

public abstract class AbstractScreen extends Stage implements Screen {

	Array<Disposable> deshechables = new Array<Disposable>();
	AssetManager assets;

	Vector3 v3_temp1 = new Vector3();
	protected boolean isVisible(final Camera cam, final GameObject instance) {
		instance.transform.getTranslation(v3_temp1);
		v3_temp1.add(instance.center);
		return cam.frustum.sphereInFrustum(v3_temp1, instance.radius);
	}
	
    protected AbstractScreen() {
        super();
		assets = new AssetManager();
    }
 
    public abstract void buildStage();
 
    
    @Override public void dispose() {
    	for (Disposable disposable : deshechables) {
    		disposable.dispose();
    	}
    }

    @Override public void hide() {}
    @Override public void pause() {}
    @Override public void resume() {}
}
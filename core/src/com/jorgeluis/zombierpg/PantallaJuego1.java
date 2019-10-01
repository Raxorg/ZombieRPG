package com.jorgeluis.zombierpg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.utils.Array;

public class PantallaJuego1 extends AbstractScreen {
	//protected Stage stage;
	Ambiente ambiente;
	Camara cam;
	Touchpad touchpad;
	Array<GameInstance> gameInstances = new Array<GameInstance>();
	PlayerZombie playerZombie;
	
	SpriteBatch spritebatch;
	ModelBatch modelBatch;
	boolean isLoading=true;

	int mainWidth = Gdx.graphics.getWidth()/4;
	int mainHeight = Gdx.graphics.getHeight()/4;
	public PantallaJuego1() {
		spritebatch = new SpriteBatch();
		modelBatch = new ModelBatch();
		ambiente = new Ambiente();		
		iniciarControles();

		cam = new Camara(mainWidth,mainHeight);
		assets.load("3d/city.g3dj", Model.class); 
		assets.load("3d/skele.g3dj", Model.class); 
		Gdx.input.setInputProcessor(new InputMultiplexer(this));
	}

	private void iniciarControles() {
		Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
		touchpad = new Touchpad(20, skin);
		touchpad.setBounds(15, 15, Gdx.graphics.getWidth()*.3f, Gdx.graphics.getHeight()*.4f );
		this.addActor(touchpad);
	}

	@Override
	public void render(float delta) {
		if (isLoading && assets.update()){
			alCargar();
			isLoading=false;
		}

		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glViewport(0, 0, mainWidth, mainHeight); 
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		Gdx.gl.glDepthFunc(GL20.GL_LESS);
		Gdx.gl.glDepthMask(true);		
		cam.update();
		modelBatch.begin(cam);

		for (final GameInstance modelinstance : gameInstances)
			if (modelinstance.visible)
				//if (isVisible(cam, modelinstance))
					modelBatch.render(modelinstance, ambiente);

		modelBatch.end();
			for (final GameInstance modelinstance : gameInstances)
				if (modelinstance.visible)
					modelinstance.draw(delta);

		updateLight();
		updateControls();
		draw();
	}
	

	private void updateControls() {
		if (Gdx.input.isKeyPressed(Keys.A) || touchpad.getKnobPercentX()<-0.5){
			playerZombie.rotar(5f);
		}
		if (Gdx.input.isKeyPressed(Keys.D) || touchpad.getKnobPercentX()>0.5){
			playerZombie.rotar(-5f);
		}
		
		/*
		walkDirection.set(0,0,0);
		if (Gdx.input.isKeyPressed(Keys.W) || touchpad.getKnobPercentY()>0.5){
			walkDirection.add(characterDirection);
			walkDirection.scl(0.6f);
			CharAnim.animate("Armature|walk", -1, 1f, null, 0.13f);
		}
		
		if (Gdx.input.isKeyPressed(Keys.S) || touchpad.getKnobPercentY()<-0.5){
		
			walkDirection.add(-characterDirection.x, -characterDirection.y, -characterDirection.z);
			walkDirection.scl(0.6f);
			CharAnim.animate("Armature|walk", -1, 1f, null, 0.13f);
		}*/
	}

	private void updateLight() {
		/*
		ambiente.shadowLight.set(worldGame.dayLightCol, worldGame.dayLightDir);
		ambiente.directionalLight.set(worldGame.dayLightCol, worldGame.dayLightDir);

		shadowLight.begin(Vector3.Zero, cam.direction);
		shadowBatch.begin(shadowLight.getCamera());
		for (GameInstance mi : gameInstances)
			if (mi.visible)
				if (isVisible(cam, mi))
					shadowBatch.render(mi);
		shadowBatch.end();
		shadowLight.end();
		*/
	}

	public void alCargar() {
		Model mCity = assets.get("3d/city.g3dj", Model.class);
		GameInstance instanceCity = new GameInstance(mCity,TipoEntidad.ESCENARIO);
		gameInstances.add(instanceCity);
		Model mPlayer = assets.get("3d/skele.g3dj", Model.class);
		playerZombie = new PlayerZombie(mPlayer,TipoEntidad.PLAYER);
		playerZombie.quieto();
		gameInstances.add(playerZombie);
		//instanceCity.transform.scale(0.4f, 0.4f, 0.4f);
		//instancePlayer.transform.scale(0.1f, 0.1f, 0.1f);
	}

	@Override
	public void show() {
	}

	@Override
	public void resize(int width, int height) {
        getViewport().update(width, height, true);
		mainWidth = width;
		mainHeight = height;
		cam.position.set(cam.position);
		cam.viewportWidth = mainWidth;/*con width  */
		cam.viewportHeight = mainHeight;/* con width */
		cam.update();
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void buildStage() {
	}

}

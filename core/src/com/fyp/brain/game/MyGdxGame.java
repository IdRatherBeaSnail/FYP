package com.fyp.brain.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fyp.brain.game.screens.mainScreen;
import com.fyp.brain.game.screens.nbackScreen;
import com.fyp.brain.game.screens.test;

public class MyGdxGame extends Game {
	SpriteBatch batch;
	Texture img,buttons;
	private Music theme, theme2;
	private static final int FRAME_COLS = 7, FRAME_ROWS = 2;
	private Texture rainSheet;
	float stateTime;
	Animation<TextureRegion> rainAnimation;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new mainScreen(this));
		theme = Gdx.audio.newMusic(Gdx.files.internal("mainTheme.mp3"));
		theme2 = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
		theme.setVolume(0.5f);
		theme.play();
		theme.setLooping(true);

		theme2.setVolume(0.10f);
		theme2.play();
		theme2.setLooping(true);



	}

	@Override
	public void resize(int width, int height) {

	}


	@Override
	public void render () {
		super.render();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		rainSheet.dispose();
	}
}

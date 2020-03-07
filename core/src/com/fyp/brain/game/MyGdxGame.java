package com.fyp.brain.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.fyp.brain.game.screens.mainScreen;
import com.fyp.brain.game.screens.nbackScreen;


public class MyGdxGame extends Game {
	private SpriteBatch batch;
	private Music theme;
	private float musicVol,soundVol;
	private Preferences audio;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new mainScreen(this));
		audio = Gdx.app.getPreferences("Audio");
		musicVol = audio.getFloat("musicVol",0.5f);
		soundVol = audio.getFloat("soundVol",0.5f);
		theme = Gdx.audio.newMusic(Gdx.files.internal("mainTheme.mp3"));

		theme.setVolume(musicVol);
		theme.play();
		theme.setLooping(true);


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

	}


	public Music getTheme(){

		return theme;
	}

	public float getMusicVol(){
		return musicVol;
	}

	public void setMusicVol(float vol){

		this.musicVol = vol;
	}

	public float getSoundVol(){
		return soundVol;
	}

	public void setSoundVol(float vol){

		this.soundVol = vol;
	}
}

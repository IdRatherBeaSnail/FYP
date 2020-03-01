package com.fyp.brain.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.fyp.brain.game.MyGdxGame;

import java.text.DecimalFormat;

public class Leaderboard implements Screen {
    private  BitmapFont font;
    private  Stage stage;
    private SpriteBatch batch;
    private MyGdxGame game;
    private Skin skin;
    private TextureAtlas buttonAtlas;
    private Preferences score;
    private Texture img;

    public Leaderboard(MyGdxGame game){
        this.game = game;
        batch = new SpriteBatch();
        img = new Texture("leaderboard.png");
        font = new BitmapFont(Gdx.files.internal("fonty.fnt"));
        stage = new Stage(new ScreenViewport());
        score = Gdx.app.getPreferences("Highscores");

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        skin = new Skin();
        buttonAtlas = new TextureAtlas("nBack.pack");
        skin.addRegions(buttonAtlas);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



        batch.begin();
        batch.draw(img, 0, 0);
        batch.end();

        stage.getBatch().begin();
        font.draw(stage.getBatch(), Integer.toString(score.getInteger("currentNbackHighScore",0)) , Gdx.graphics.getWidth()/2 + 250,Gdx.graphics.getHeight()/2 + 285);
        font.draw(stage.getBatch(), new DecimalFormat("##.###").format(score.getFloat("currentSymbolHighScore",0)) , Gdx.graphics.getWidth()/2 + 250,Gdx.graphics.getHeight()/2 + 145);
        font.draw(stage.getBatch(), Integer.toString(score.getInteger("currentRunHighScore",0)) , Gdx.graphics.getWidth()/2 + 250,Gdx.graphics.getHeight()/2 + 5);
        font.draw(stage.getBatch(), Integer.toString(score.getInteger("currentBackHighScore",0)) , Gdx.graphics.getWidth()/2 + 250,Gdx.graphics.getHeight()/2 - 145);
        font.draw(stage.getBatch(), Integer.toString(score.getInteger("currentCorsiHighScore",0)) , Gdx.graphics.getWidth()/2 + 250,Gdx.graphics.getHeight()/2 - 285);
        font.draw(stage.getBatch(), Integer.toString(score.getInteger("currentStroopHighScore",0)) , Gdx.graphics.getWidth()/2 + 250,Gdx.graphics.getHeight()/2 - 425);
        stage.getBatch().end();

        stage.draw();
        stage.act();
    }

    @Override
    public void resize(int width, int height) {

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

    }
}

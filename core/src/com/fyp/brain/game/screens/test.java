package com.fyp.brain.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.*;
import com.fyp.brain.game.MyGdxGame;

public class test implements Screen {

    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Stage stage;
    private BitmapFont font;
    private Skin skinButton;
    private TextureAtlas buttonAtlas;
    private TextButtonStyle textButtonStyle;
    private TextButton button;
    private MyGdxGame game;

    public test(MyGdxGame game) {

        this.game = game;
    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        batch = new SpriteBatch();
        stage = new Stage();

        font = new BitmapFont();
        skinButton=new Skin();
        buttonAtlas = new TextureAtlas("nBack.pack");
        skinButton.addRegions(buttonAtlas);
        textButtonStyle = new TextButtonStyle();
        textButtonStyle.font = font;

        textButtonStyle.up = skinButton.getDrawable("correctButton");
        textButtonStyle.down = skinButton.getDrawable("incorrectButton");
        textButtonStyle.checked = skinButton.getDrawable("charButton");
        button=new TextButton("Finish",textButtonStyle);
        button.setText("Finish");
        button.setHeight(230);
        button.setWidth(500);
        button.setPosition(50,50);
        stage.addActor(button);
    }

    @Override
    public void render(float delta) {
        stage.draw();
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
        buttonAtlas.dispose();
        font.dispose();
        skinButton.dispose();
        buttonAtlas.dispose();
        batch.dispose();
    }
}

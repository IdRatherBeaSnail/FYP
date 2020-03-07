package com.fyp.brain.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.fyp.brain.game.MyGdxGame;



public class mainScreen implements Screen {
    private final BitmapFont font;
    private final Stage stage;
    private SpriteBatch batch;
    private Texture img;
    private TextButton nback,stroop,running,play,settings,leaderboard;
    private static final int FRAME_COLS = 7, FRAME_ROWS = 2;
    private Texture rainSheet;
    private float stateTime;
    private Animation<TextureRegion> rainAnimation;
    private MyGdxGame game;
    private Skin skin;
    private TextureAtlas buttonAtlas;
    private Camera camera;
    private Viewport viewport;


    public mainScreen(MyGdxGame game){
        this.game = game;
        batch = new SpriteBatch();
        camera = new OrthographicCamera(1080.0f,1920.0f);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        viewport = new FitViewport(1080.0f,1920.0f,camera);
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
        img = new Texture("mainBackground2.png");
        font = new BitmapFont(Gdx.files.internal("fonty.fnt"));


    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        skin = new Skin();
        buttonAtlas = new TextureAtlas("nBack.pack");
        skin.addRegions(buttonAtlas);


        TextButton.TextButtonStyle playStyle = new TextButton.TextButtonStyle();
        playStyle.up = skin.getDrawable("play");
        playStyle.font = font;

        play = new TextButton("",playStyle);
        play.setPosition(Gdx.graphics.getWidth()/2 - 255  ,Gdx.graphics.getHeight()/2 + 100);

        play.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){

                    game.setScreen(new GameSelect(game));


            }

        });

        stage.addActor(play);

        TextButtonStyle settingsStyle = new TextButton.TextButtonStyle();
        settingsStyle.up = skin.getDrawable("settings");
        settingsStyle.font = font;

        settings = new TextButton("",settingsStyle);
        settings.setPosition(Gdx.graphics.getWidth()/2 - 275  ,Gdx.graphics.getHeight()/2 - 400);

        settings.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){

                game.setScreen(new SettingsScreen(game));


            }

        });

        stage.addActor(settings);

        TextButtonStyle leaderStyle = new TextButton.TextButtonStyle();
        leaderStyle.up = skin.getDrawable("leaderboard");
        leaderStyle.font = font;

        leaderboard = new TextButton("",leaderStyle);
        leaderboard.setPosition(Gdx.graphics.getWidth()/2 - 375  ,Gdx.graphics.getHeight()/2 - 150);

        leaderboard.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){

                game.setScreen(new Leaderboard(game));


            }

        });

        stage.addActor(leaderboard);




    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.getBatch().setProjectionMatrix(stage.getCamera().combined);
        stage.getCamera().update();

        stage.getBatch().begin();
        stage.getBatch().draw(img, 0, 0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        stage.getBatch().end();

        stage.draw();
        stage.act();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
        stage.getCamera().position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
        stage.getCamera().update();
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
    public void dispose () {
        batch.dispose();
        img.dispose();
        rainSheet.dispose();

    }
}


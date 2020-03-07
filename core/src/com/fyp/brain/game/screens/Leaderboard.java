package com.fyp.brain.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
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
    private TextButton back;
    private Viewport viewport;
    private Camera camera;

    public Leaderboard(MyGdxGame game){
        this.game = game;
        batch = new SpriteBatch();
        img = new Texture("leaderboard.png");
        font = new BitmapFont(Gdx.files.internal("fonty.fnt"));
        camera = new OrthographicCamera(1080.0f,1920.0f);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        viewport = new FitViewport(1080.0f,1920.0f,camera);
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
        score = Gdx.app.getPreferences("Highscores");

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        skin = new Skin();
        buttonAtlas = new TextureAtlas("nBack.pack");
        skin.addRegions(buttonAtlas);

        TextButton.TextButtonStyle backStyle = new TextButton.TextButtonStyle();
        backStyle.font = font;
        backStyle.up = skin.getDrawable("backButton");

        back = new TextButton("",backStyle);
        back.setPosition(Gdx.graphics.getWidth()/2 - 160.0f,Gdx.graphics.getHeight()/2 - 960.0f);

        back.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                game.setScreen(new mainScreen(game));

            }


        });

        stage.addActor(back);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.getBatch().setProjectionMatrix(stage.getCamera().combined);
        stage.getCamera().update();



        stage.getBatch().begin();
        stage.getBatch().draw(img, 0, 0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        stage.getBatch().end();

        stage.getBatch().begin();
        font.draw(stage.getBatch(), Integer.toString(score.getInteger("currentNbackHighScore",0)) , Gdx.graphics.getWidth()/2 + 250,Gdx.graphics.getHeight()/2 + 285);
        font.draw(stage.getBatch(), new DecimalFormat("##.###").format(score.getFloat("currentSymbolHighScore",0)) + "s" , Gdx.graphics.getWidth()/2 + 200,Gdx.graphics.getHeight()/2 + 145);
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
    public void dispose() {

    }
}

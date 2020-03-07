package com.fyp.brain.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.fyp.brain.game.MyGdxGame;

public class GameSelect implements Screen {
    private MyGdxGame game;
    private BitmapFont font;
    private Stage stage;
    private Skin skin;
    private TextureAtlas buttonAtlas;
    private TextButton one,two,three,four,five,six,back;
    private Texture background;
    private Camera camera;
    private Viewport viewport;
    private Batch batch;


    public GameSelect(MyGdxGame game){
        this.game = game;
        font = new BitmapFont(Gdx.files.internal("fonty.fnt"));
        background = new Texture("gameSelect.png");
        batch = new SpriteBatch();
        camera = new OrthographicCamera(1080.0f,1920.0f);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        viewport = new FitViewport(1080.0f,1920.0f,camera);
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
    }
    @Override
    public void show() {
        stage.clear();
        Gdx.input.setInputProcessor(stage);
        skin = new Skin();
        buttonAtlas = new TextureAtlas("nBack.pack");

        skin.addRegions(buttonAtlas);

        TextButton.TextButtonStyle oneStyle = new TextButton.TextButtonStyle();
        oneStyle.font = font;
        oneStyle.up = skin.getDrawable("one");
        oneStyle.disabled = skin.getDrawable("oneD");

        one = new TextButton("",oneStyle);
        one.setPosition(Gdx.graphics.getWidth()/2  - 400.0f,Gdx.graphics.getHeight()/2 - 60.0f);

        one.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                 game.setScreen(new nbackScreen(game));
                }
            }

        );

        TextButton.TextButtonStyle twoStyle = new TextButton.TextButtonStyle();
        twoStyle.font = font;
        twoStyle.up = skin.getDrawable("2");
        twoStyle.disabled = skin.getDrawable("2D");

        two = new TextButton("",twoStyle);
        two.setPosition(Gdx.graphics.getWidth()/2 - 100.0f,Gdx.graphics.getHeight()/2 - 60.0f);

        two.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                game.setScreen(new RunningSpanScreen(game));
                }


        });


        TextButton.TextButtonStyle threeStyle = new TextButton.TextButtonStyle();
        threeStyle.font = font;
        threeStyle.up = skin.getDrawable("3");
        threeStyle.disabled = skin.getDrawable("3D");

        three = new TextButton("",threeStyle);
        three.setPosition(Gdx.graphics.getWidth()/2 + 180.0f,Gdx.graphics.getHeight()/2 - 60.0f);

        three.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                game.setScreen(new CorsiBlockScreen(game));
            }

        });

        TextButton.TextButtonStyle fourStyle = new TextButton.TextButtonStyle();
        fourStyle.font = font;
        fourStyle.up = skin.getDrawable("4");
        fourStyle.disabled = skin.getDrawable("4D");

        four = new TextButton("",fourStyle);
        four.setPosition(Gdx.graphics.getWidth()/2 - 400.0f,Gdx.graphics.getHeight()/2 - 400.0f);

        four.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                game.setScreen(new SymbolScreen(game));
                }


        });

        TextButton.TextButtonStyle fiveStyle = new TextButton.TextButtonStyle();
        fiveStyle.font = font;
        fiveStyle.up = skin.getDrawable("5");
        fiveStyle.disabled = skin.getDrawable("5D");

        five = new TextButton("",fiveStyle);
        five.setPosition(Gdx.graphics.getWidth()/2 - 100.0f,Gdx.graphics.getHeight()/2 - 400.0f);

        five.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                game.setScreen(new StroopScreen(game));
            }

        });

        TextButton.TextButtonStyle sixStyle = new TextButton.TextButtonStyle();
        sixStyle.font = font;
        sixStyle.up = skin.getDrawable("6");
        sixStyle.disabled = skin.getDrawable("6D");

        six = new TextButton("",sixStyle);
        six.setPosition(Gdx.graphics.getWidth()/2 + 180.0f,Gdx.graphics.getHeight()/2 - 400.0f);

        six.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                game.setScreen(new BackwardSpanScreen(game));
            }

        });

        stage.addActor(one);
        stage.addActor(two);
        stage.addActor(three);
        stage.addActor(four);
        stage.addActor(five);
        stage.addActor(six);

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

        batch.begin();
        batch.draw(background, 0, 0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
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

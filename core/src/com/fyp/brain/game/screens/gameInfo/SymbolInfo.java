package com.fyp.brain.game.screens.gameInfo;

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
import com.badlogic.gdx.utils.viewport.Viewport;
import com.fyp.brain.game.MyGdxGame;
import com.fyp.brain.game.screens.GameSelect;
import com.fyp.brain.game.screens.gameScreens.RunningSpanScreen;
import com.fyp.brain.game.screens.gameScreens.SymbolScreen;
import com.fyp.brain.game.screens.tutorial.SymbolTutorial;

public class SymbolInfo implements Screen {
    private MyGdxGame game;
    private BitmapFont font;
    private Stage stage;
    private Skin skin;
    private TextureAtlas buttonAtlas;
    private TextButton one, two, back;
    private Texture background;
    private Camera camera;
    private Viewport viewport;
    private Batch batch;


    public SymbolInfo(MyGdxGame game) {
        this.game = game;
        font = new BitmapFont(Gdx.files.internal("fonty.fnt"));
        background = new Texture("symbolGameSelect.png");
        batch = new SpriteBatch();
        camera = new OrthographicCamera(1080.0f, 1920.0f);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        viewport = new FitViewport(1080.0f, 1920.0f, camera);
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
    }
    @Override
    public void show () {
        stage.clear();
        Gdx.input.setInputProcessor(stage);
        skin = new Skin();
        buttonAtlas = new TextureAtlas("nBack.pack");

        skin.addRegions(buttonAtlas);

        TextButton.TextButtonStyle oneStyle = new TextButton.TextButtonStyle();
        oneStyle.font = font;
        oneStyle.up = skin.getDrawable("playGS");


        one = new TextButton("", oneStyle);
        one.setPosition(Gdx.graphics.getWidth() / 2 - 450.0f, Gdx.graphics.getHeight() / 2 - 500.0f);

        one.addListener(new ClickListener() {
                            @Override
                            public void clicked(InputEvent event, float x, float y) {
                                game.setScreen(new SymbolScreen(game));
                            }
                        }

        );

        TextButton.TextButtonStyle twoStyle = new TextButton.TextButtonStyle();
        twoStyle.font = font;
        twoStyle.up = skin.getDrawable("tutorialGS");


        two = new TextButton("", twoStyle);
        two.setPosition(Gdx.graphics.getWidth() / 2 +50.0f, Gdx.graphics.getHeight() / 2 - 500.0f);

        two.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new SymbolTutorial(game));
            }


        });


        stage.addActor(one);
        stage.addActor(two);

        TextButton.TextButtonStyle backStyle = new TextButton.TextButtonStyle();
        backStyle.font = font;
        backStyle.up = skin.getDrawable("backButton");

        back = new TextButton("", backStyle);
        back.setPosition(Gdx.graphics.getWidth() / 2 - 160.0f, Gdx.graphics.getHeight() / 2 - 960.0f);

        back.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameSelect(game));

            }


        });

        stage.addActor(back);


    }

    @Override
    public void render ( float delta){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.getBatch().setProjectionMatrix(stage.getCamera().combined);
        stage.getCamera().update();

        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        stage.getBatch().end();
        stage.draw();
        stage.act();

    }

    @Override
    public void resize ( int width, int height){
        stage.getViewport().update(width, height);
        stage.getCamera().position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
        stage.getCamera().update();
    }

    @Override
    public void pause () {

    }

    @Override
    public void resume () {

    }

    @Override
    public void hide () {

    }

    @Override
    public void dispose () {

    }

}

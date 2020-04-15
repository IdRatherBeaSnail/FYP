package com.fyp.brain.game.screens.tutorial;

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
import com.fyp.brain.game.screens.gameInfo.CorsiBlockInfo;
import com.fyp.brain.game.screens.gameInfo.RunningSpanInfo;

public class CorsiTutorial implements Screen {
    private MyGdxGame game;
    private BitmapFont font;
    private Stage stage;
    private Skin skin;
    private TextureAtlas buttonAtlas;
    private TextButton one, two;
    private Texture background;
    private Camera camera;
    private Viewport viewport;
    private Batch batch;
    private int count;

    public CorsiTutorial(MyGdxGame game){
        this.game = game;
        font = new BitmapFont(Gdx.files.internal("fonty.fnt"));
        background = new Texture("tutorial/corsi1.png");
        batch = new SpriteBatch();
        camera = new OrthographicCamera(1080.0f, 1920.0f);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        viewport = new FitViewport(1080.0f, 1920.0f, camera);
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
        count = 0;
    }
    @Override
    public void show() {
        stage.clear();
        Gdx.input.setInputProcessor(stage);
        skin = new Skin();
        buttonAtlas = new TextureAtlas("nBack.pack");

        skin.addRegions(buttonAtlas);


        TextButton.TextButtonStyle nextStyle = new TextButton.TextButtonStyle();
        nextStyle.font = font;
        nextStyle.up = skin.getDrawable("next");


        two = new TextButton("", nextStyle);
        two.setPosition(Gdx.graphics.getWidth() / 2 + 270.0f, Gdx.graphics.getHeight() / 2 - 700.0f);

        two.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (count < 0){
                    count = 0;
                }
                count += 1;
            }


        });


        stage.addActor(two);


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.getBatch().setProjectionMatrix(stage.getCamera().combined);
        stage.getCamera().update();
        if(count < 0){
            count = 0;
        }
        if(count == 0 ) {
            stage.getBatch().begin();
            stage.getBatch().draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            stage.getBatch().end();
        } else if (count == 1){
            game.setScreen(new CorsiBlockInfo(game));

        }
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

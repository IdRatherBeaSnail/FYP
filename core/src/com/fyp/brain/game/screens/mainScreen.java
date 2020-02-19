package com.fyp.brain.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
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
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.fyp.brain.game.MyGdxGame;

public class mainScreen implements Screen {
    private final BitmapFont font;
    private final Stage stage;
    private SpriteBatch batch;
    private Texture img;
    private TextButton nback,stroop,running;
    private static final int FRAME_COLS = 7, FRAME_ROWS = 2;
    private Texture rainSheet;
    private float stateTime;
    private Animation<TextureRegion> rainAnimation;
    private MyGdxGame game;
    private Skin skin;
    private TextureAtlas buttonAtlas;


    public mainScreen(MyGdxGame game){
        this.game = game;
        batch = new SpriteBatch();
        img = new Texture("mainBackground2.png");
        font = new BitmapFont(Gdx.files.internal("fonty.fnt"));
        stage = new Stage(new ScreenViewport());
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        img = new Texture("mainBackground2.png");
        Gdx.input.setInputProcessor(stage);
        skin = new Skin();
        buttonAtlas = new TextureAtlas("nBack.pack");
        skin.addRegions(buttonAtlas);


        TextButton.TextButtonStyle nbackStyle = new TextButton.TextButtonStyle();
        nbackStyle.up = skin.getDrawable("nBackButton");
        nbackStyle.font = font;

        nback = new TextButton("",nbackStyle);
        nback.setPosition(Gdx.graphics.getWidth()/2 - 275  ,Gdx.graphics.getHeight()/2+150);

        nback.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){

                    game.setScreen(new nbackScreen(game));


            }

        });

        stage.addActor(nback);

        TextButton.TextButtonStyle stroopStyle = new TextButton.TextButtonStyle();
        stroopStyle.up = skin.getDrawable("nBackButton");
        stroopStyle.font = font;

        stroop = new TextButton("",nbackStyle);
        stroop.setPosition(Gdx.graphics.getWidth()/2 - 275  ,Gdx.graphics.getHeight()/2 - 50);

        stroop.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){

                game.setScreen(new StroopScreen(game));


            }

        });

        stage.addActor(stroop);

        TextButton.TextButtonStyle runningStyle = new TextButton.TextButtonStyle();
        runningStyle.up = skin.getDrawable("nBackButton");
        runningStyle.font = font;

        running = new TextButton("",runningStyle);
        running.setPosition(Gdx.graphics.getWidth()/2 - 275  ,Gdx.graphics.getHeight()/2 - 250);

        running.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){

                game.setScreen(new RunningSpanScreen(game));


            }

        });

        stage.addActor(running);



        rainSheet = new Texture(Gdx.files.internal("rainSheets.png"));

        TextureRegion[][] tmp = TextureRegion.split(rainSheet,rainSheet.getWidth()/FRAME_COLS, rainSheet.getHeight()/FRAME_ROWS);

        TextureRegion[] rainFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                rainFrames[index++] = tmp[i][j];
            }
        }

        rainAnimation = new Animation<TextureRegion>(0.055f, rainFrames);

        stateTime = 0f;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stateTime += Gdx.graphics.getDeltaTime();
        TextureRegion currentFrame = rainAnimation.getKeyFrame(stateTime, true);
        batch.begin();
        batch.draw(img, 0, 0);
        batch.draw(currentFrame,0,0);
        batch.end();

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
    public void dispose () {
        batch.dispose();
        img.dispose();
        rainSheet.dispose();
    }
}


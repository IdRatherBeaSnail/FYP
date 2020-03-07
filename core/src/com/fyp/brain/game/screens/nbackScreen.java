package com.fyp.brain.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
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
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.fyp.brain.game.MyGdxGame;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.fyp.brain.game.player.Player;

import java.util.Random;


public class nbackScreen implements Screen {

    private Viewport viewport;
    private Camera camera;
    private Batch batch;
    private MyGdxGame game;
    private Stage stage;
    private Texture background,over,heart,heart2,heart3,dheart,dheart2,dheart3;
    private BitmapFont font;
    private Skin skin;
    private TextureAtlas buttonAtlas;
    private int counter,currentHighScore;
    private Preferences score;
    private Player player;
    private int N = 3;
    private TextButton character,correct,retry,menu, wrong,back;
    private String letter;
    private String easy = "a,o,e,a,o,e,o,o,e,o,e,o,a,o,o,e,o,e,e,a,o,a,o,a,e,d,e,o,a,d,a,o,d,e,a,d,o,k,e,o,k,k,a,d,o,a,o,e,a,o,e,o,a,o,d,o,a,o,d,a,d,e,d,o,a,o,e";
    private String[] letters;
    private boolean start;
    private float timer,deltaTime;


    public nbackScreen(MyGdxGame game) {
        this.game = game;
        player = new Player();
        player.setLife(3);
        timer = 0;
        deltaTime = Gdx.graphics.getDeltaTime();
        start = true;
        font = new BitmapFont(Gdx.files.internal("fonty.fnt"));
        counter = 0;
        String temp = easy.toUpperCase();
        letters = temp.split(",");

        background = new Texture("nbackBackground.png");
        over = new Texture("nbackBackgroundFinished.png");

        heart = new Texture("heart.png");
        heart2 = new Texture("heart.png");
        heart3 = new Texture("heart.png");

        dheart = new Texture("heartDead.png");
        dheart2 = new Texture("heartDead.png");
        dheart3 = new Texture("heartDead.png");
        score = Gdx.app.getPreferences("Highscores");
        currentHighScore = score.getInteger("currentNbackHighScore", 0);


        camera = new OrthographicCamera(1080.0f,1920.0f);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        viewport = new StretchViewport(1080.0f,1920.0f,camera);
        stage = new Stage(viewport);
        stage.getViewport().apply();
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        stage.clear();
        Gdx.input.setInputProcessor(stage);
        skin = new Skin();
        buttonAtlas = new TextureAtlas("nBack.pack");
        skin.addRegions(buttonAtlas);



        TextButtonStyle  rightStyle = new TextButtonStyle ();
        rightStyle.up = skin.getDrawable("right");
        rightStyle.font = font;

        correct = new TextButton("", rightStyle);
        correct.setPosition(Gdx.graphics.getWidth()/2 - 400.0f,Gdx.graphics.getHeight()/2 - 550.0f);



        TextButtonStyle  wrongStyle = new TextButtonStyle ();
        wrongStyle.up = skin.getDrawable("wrong");
        wrongStyle.font = font;

        wrong = new TextButton("", wrongStyle);
        wrong.setPosition(Gdx.graphics.getWidth()/2 + 50.0f,Gdx.graphics.getHeight()/2 - 550.0f);




        TextButtonStyle  letterStyle = new TextButtonStyle ();
        letterStyle.up = skin.getDrawable("letterbg");
        letterStyle.font = font;


        character = new TextButton(letters[counter],letterStyle);
        character.getLabel().setFontScale(2.0f);
        character.getLabel().setAlignment(Align.center);
        character.setPosition(Gdx.graphics.getWidth()/2- 390.0f,Gdx.graphics.getHeight()/2 - 200.0f );


        TextButtonStyle  retryStyle = new TextButtonStyle ();
        retryStyle.up = skin.getDrawable("retry");
        retryStyle.font = font;

        retry = new TextButton("",retryStyle);
        retry.setPosition(Gdx.graphics.getWidth()/2 -150 ,Gdx.graphics.getHeight()/2 - 250.0f);

        retry.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(player.getLife() <= 0){
                    player.setScore(0);
                    player.setLife(3);
                    counter = 0;
                    game.setScreen(new nbackScreen(game));

                }
            }

        });

        stage.addActor(retry);


        TextButtonStyle  menuStyle = new TextButtonStyle ();
        menuStyle.up = skin.getDrawable("mainmenu");
        menuStyle.font = font;

        menu = new TextButton("",menuStyle);
        menu.setPosition(Gdx.graphics.getWidth()/2 -250,Gdx.graphics.getHeight()/2 - 450.0f);

        menu.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                game.setScreen(new mainScreen(game));


            }

        });

        stage.addActor(menu);



        correct.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(letters[counter].equals(letters[counter-N])){
                    counter++;
                    player.setScore(1);




                } else if (!letters[counter].equals(letters[counter-N])){
                    counter ++;
                    player.loseLife(1);


                }
            }

        });


        wrong.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(counter < N || !letters[counter].equals(letters[counter-N])){
                    counter++;
                    player.setScore(1);

                } else if (letters[counter].equals(letters[counter-N])) {
                    counter ++;
                    player.loseLife(1);


                }
            }

        });
        TextButtonStyle backStyle = new TextButtonStyle();
        backStyle.font = font;
        backStyle.up = skin.getDrawable("backButton");

        back = new TextButton("",backStyle);
        back.setPosition(Gdx.graphics.getWidth()/2 - 160.0f,Gdx.graphics.getHeight()/2 - 960.0f);

        back.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                game.setScreen(new GameSelect(game));

            }


        });

        stage.addActor(back);



        stage.addActor(correct);
        stage.addActor(wrong);
        stage.addActor(character);


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.getBatch().setProjectionMatrix(stage.getCamera().combined);
        stage.getCamera().update();

        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        stage.getBatch().end();
        menu.setVisible(false);
        retry.setVisible(false);

        if(counter < N){
            correct.setVisible(false);
            wrong.setVisible(false);
        } else {
            correct.setVisible(true);
            wrong.setVisible(true);
        }
        if(start){
            timer += deltaTime;
            if(counter == 3){
                start = false;
            } else if(timer >= 1){
                counter++;
                timer = 0;
            }
        }
        character.setText(letters[counter]);


        stage.getBatch().begin();
        font.draw(stage.getBatch(), Integer.toString(player.getScore()), 300,1875);
        font.draw(stage.getBatch(), "N = " + N, Gdx.graphics.getWidth()/2 - 60,Gdx.graphics.getHeight()/2 - 220.0f);
        stage.getBatch().end();




        if (player.getLife() == 3){
            stage.getBatch().begin();
            stage.getBatch().draw(heart,925,1800,92, 89);
            stage.getBatch().draw(heart2,825,1800,92, 89);
            stage.getBatch().draw(heart3,725,1800,92, 89);
            stage.getBatch().end();
        } else if ( player.getLife() == 2){
            stage.getBatch().begin();
            stage.getBatch().draw(dheart,925,1800,92, 89);
            stage.getBatch().draw(heart2,825,1800,92, 89);
            stage.getBatch().draw(heart3,725,1800,92, 89);
            stage.getBatch().end();
        } else if (player.getLife() == 1) {
            stage.getBatch().begin();
            stage.getBatch().draw(dheart,925,1800,92, 89);
            stage.getBatch().draw(dheart2,825,1800,92, 89);
            stage.getBatch().draw(heart3,725,1800,92, 89);
            stage.getBatch().end();
        } else if (player.getLife() <= 0) {
            stage.getBatch().begin();
            stage.getBatch().draw(dheart,925,1800,92, 89);
            stage.getBatch().draw(dheart2,825,1800,92, 89);
            stage.getBatch().draw(dheart3,725,1800,92, 89);
            stage.getBatch().draw(over, 0, 0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            font.draw(stage.getBatch(), Integer.toString(player.getScore()), Gdx.graphics.getWidth()/2 + 90,Gdx.graphics.getHeight()/2 + 215);
            stage.getBatch().end();
            character.setVisible(false);
            correct.setVisible(false);
            wrong.setVisible(false);
            retry.setVisible(true);
            menu.setVisible(true);
            if(currentHighScore < player.getScore()|| currentHighScore == 0) {
                score.putInteger("currentNbackHighScore", player.getScore());
                score.flush();
            }
        } else {
            stage.getBatch().begin();
            stage.getBatch().draw(heart,925,1800,92, 89);
            stage.getBatch().draw(heart2,825,1800,92, 89);
            stage.getBatch().draw(heart3,725,1800,92, 89);
            stage.getBatch().end();
        }

        stage.draw();
        stage.act();




    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
        stage.getCamera().position.set(stage.getCamera().viewportWidth / 2, stage.getCamera().viewportHeight / 2, 0);
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
        buttonAtlas.dispose();
        font.dispose();
        skin.dispose();
        buttonAtlas.dispose();
        background.dispose();
        heart.dispose();
        heart2.dispose();
        heart3.dispose();
        dheart.dispose();
        dheart2.dispose();
        dheart3.dispose();
        stage.dispose();
    }

}

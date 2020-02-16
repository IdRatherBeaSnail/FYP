package com.fyp.brain.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.fyp.brain.game.MyGdxGame;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.fyp.brain.game.player.Player;

import java.util.Random;


public class nbackScreen implements Screen {

    private MyGdxGame game;
    private Stage stage;
    private Texture background,over,heart,heart2,heart3,dheart,dheart2,dheart3;
    private BitmapFont font;
    private Skin skin;
    private TextureAtlas buttonAtlas;
    private int counter;
    private Player player;
    private int N = 3;
    private TextButton character,correct,retry,menu, wrong;
    private String letter;
    private String easy = "a,o,e,a,o,e,o,o,e,o,e,o,a,o,o,e,o,e,e,a,o,a,o,a,e,d,e,o,a,d,a,o,d,e,a,d,o,k,e,o,k,k,a,d,o,a,o,e,a,o,e,o,a,o,d,o,a,o,d,a,d,e,d,o,a,o,e";
    private String[] letters;


    public nbackScreen(MyGdxGame game) {
        this.game = game;
        player = new Player();
        player.setLife(3);

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



        stage = new Stage (new ScreenViewport());
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


        stage.addActor(correct);
        stage.addActor(wrong);
        stage.addActor(character);


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0);
        stage.getBatch().end();
        menu.setVisible(false);
        retry.setVisible(false);

        if(counter < N){
            correct.setVisible(false);
        } else {
            correct.setVisible(true);
        }
        character.setText(letters[counter]);


        stage.getBatch().begin();
        font.draw(stage.getBatch(), Integer.toString(player.getScore()), 300,1875);
        font.draw(stage.getBatch(), "N = " + N, Gdx.graphics.getWidth()/2 - 60,Gdx.graphics.getHeight()/2 - 220.0f);
        //font.draw(stage.getBatch(), background.toString(), Gdx.graphics.getWidth()/2 ,Gdx.graphics.getHeight()/2);
        stage.getBatch().end();




        if (player.getLife() == 3){
            stage.getBatch().begin();
            stage.getBatch().draw(heart,925,1800);
            stage.getBatch().draw(heart2,825,1800);
            stage.getBatch().draw(heart3,725,1800);
            stage.getBatch().end();
        } else if ( player.getLife() == 2){

            stage.getBatch().begin();
            stage.getBatch().draw(dheart,925,1800);
            stage.getBatch().draw(heart2,825,1800);
            stage.getBatch().draw(heart3,725,1800);
            stage.getBatch().end();
        } else if (player.getLife() == 1) {

            stage.getBatch().begin();
            stage.getBatch().draw(dheart,925,1800);
            stage.getBatch().draw(dheart2,825,1800);
            stage.getBatch().draw(heart3,725,1800);
            stage.getBatch().end();
        } else if (player.getLife() <= 0) {
            stage.getBatch().begin();
            stage.getBatch().draw(dheart,925,1800);
            stage.getBatch().draw(dheart2,825,1800);
            stage.getBatch().draw(dheart3,725,1800);
            stage.getBatch().draw(over, 0, 0);
            font.draw(stage.getBatch(), Integer.toString(player.getScore()), Gdx.graphics.getWidth()/2 + 90,Gdx.graphics.getHeight()/2 + 215);
            stage.getBatch().end();
            character.setVisible(false);
            correct.setVisible(false);
            wrong.setVisible(false);
            retry.setVisible(true);
            menu.setVisible(true);
        } else {
            stage.getBatch().begin();
            stage.getBatch().draw(heart,925,1790);
            stage.getBatch().draw(heart2,825,1790);
            stage.getBatch().draw(heart3,725,1790);
            stage.getBatch().end();
        }

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

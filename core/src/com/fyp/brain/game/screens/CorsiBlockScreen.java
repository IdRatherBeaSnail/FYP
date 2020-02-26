package com.fyp.brain.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.fyp.brain.game.MyGdxGame;
import com.fyp.brain.game.player.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CorsiBlockScreen implements Screen {
    private ArrayList<Integer> display,answer,randNum;
    private int counter;
    private float timer,deltaTime;
    private Player player;
    private MyGdxGame game;
    private BitmapFont font;
    private Texture background,over,heart,heart2,heart3,dheart,dheart2,dheart3;;
    private Stage stage;
    private Skin skin;
    private TextureAtlas buttonAtlas;
    private TextButton one,two,three,four,five,six,seven,eight,nine,zero,retry,menu;
    private String chain;
    private Label label;
    private int buttonNum;

    public CorsiBlockScreen(MyGdxGame game){

        display = new ArrayList<>();
        answer = new ArrayList<>();
        randNum = new ArrayList<>();

        for (int i = 1; i<16; i++){
            randNum.add(i);
        }


        counter = 0;
        deltaTime = 0;
        timer = 2;


        this.game = game;
        player = new Player();
        player.setLife(3);
        font = new BitmapFont(Gdx.files.internal("fonty.fnt"));
        background = new Texture("corsiBackground.png");

        over = new Texture("nbackBackgroundFinished.png");

        heart = new Texture("heart.png");
        heart2 = new Texture("heart.png");
        heart3 = new Texture("heart.png");

        dheart = new Texture("heartDead.png");
        dheart2 = new Texture("heartDead.png");
        dheart3 = new Texture("heartDead.png");

        stage = new Stage(new ScreenViewport());
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
        one.setPosition(Gdx.graphics.getWidth()/2  - 400.0f,Gdx.graphics.getHeight()/2 - 20.0f);

        one.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!one.isDisabled()){
                    buttonNum = 1;
                    answer.add(buttonNum);
                }
            }

        });





        TextButton.TextButtonStyle retryStyle = new TextButton.TextButtonStyle();
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
                    answer.clear();
                    display.clear();
                    game.setScreen(new CorsiBlockScreen(game));

                }
            }

        });

        stage.addActor(retry);


        TextButton.TextButtonStyle menuStyle = new TextButton.TextButtonStyle();
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

    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0);
        stage.getBatch().end();
        menu.setVisible(false);
        retry.setVisible(false);

        deltaTime = Gdx.graphics.getDeltaTime();
        if(timer > 0){
            timer = timer - deltaTime;
            one.setDisabled(true);
            two.setDisabled(true);
            three.setDisabled(true);
            four.setDisabled(true);
            five.setDisabled(true);
            six.setDisabled(true);
            seven.setDisabled(true);
            eight.setDisabled(true);
            nine.setDisabled(true);
            zero.setDisabled(true);
        } else if ( timer <= 0) {
            label.setVisible(false);
            one.setDisabled(false);
            two.setDisabled(false);
            three.setDisabled(false);
            four.setDisabled(false);
            five.setDisabled(false);
            six.setDisabled(false);
            seven.setDisabled(false);
            eight.setDisabled(false);
            nine.setDisabled(false);
            zero.setDisabled(false);
        }

        if (player.getScore() <= 5){
            counter = 4;
        } else if (player.getScore() <= 10){
            counter = 6;
        } else if (player.getScore() <= 20){
            counter = 8;
        } else if (player.getScore() > 20) {
            counter = 9;
        }


        if(display.size() == answer.size()){
            Collections.sort(display);
            Collections.sort(answer);
            if(display.equals(answer)){
                player.setScore(1);
                display.clear();
                answer.clear();
                timer = 2;
                Collections.shuffle(randNum);
                for (int i =0; i < counter; i++){
                    display.add(randNum.get(i));
                    // change textures in here
                }
            }
        }

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

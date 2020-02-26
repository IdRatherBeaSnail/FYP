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
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.fyp.brain.game.MyGdxGame;
import com.fyp.brain.game.player.Player;


import java.util.ArrayList;
import java.util.Random;

public class RunningSpanScreen implements Screen {

    private ArrayList<Integer> display,answer;
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

    public RunningSpanScreen (MyGdxGame game){

        display = new ArrayList<>();
        answer = new ArrayList<>();

        display.add(randomInt());
        counter = 0;
        deltaTime = 0;
        timer = 2;


        this.game = game;
        player = new Player();
        player.setLife(3);
        font = new BitmapFont(Gdx.files.internal("fonty.fnt"));
        background = new Texture("DigitSpanBackground.png");

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

        TextButtonStyle oneStyle = new TextButton.TextButtonStyle();
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

        TextButtonStyle twoStyle = new TextButton.TextButtonStyle();
        twoStyle.font = font;
        twoStyle.up = skin.getDrawable("2");
        twoStyle.disabled = skin.getDrawable("2D");

        two = new TextButton("",twoStyle);
        two.setPosition(Gdx.graphics.getWidth()/2 - 100.0f,Gdx.graphics.getHeight()/2 - 20.0f);

        two.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!two.isDisabled()){
                buttonNum = 2;
                answer.add(buttonNum);
            }
            }

        });

        TextButtonStyle threeStyle = new TextButton.TextButtonStyle();
        threeStyle.font = font;
        threeStyle.up = skin.getDrawable("3");
        threeStyle.disabled = skin.getDrawable("3D");

        three = new TextButton("",threeStyle);
        three.setPosition(Gdx.graphics.getWidth()/2 + 180.0f,Gdx.graphics.getHeight()/2 - 20.0f);

        three.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!three.isDisabled()){
                buttonNum = 3;
                answer.add(buttonNum);
            }
            }

        });

        TextButtonStyle fourStyle = new TextButton.TextButtonStyle();
        fourStyle.font = font;
        fourStyle.up = skin.getDrawable("4");
        fourStyle.disabled = skin.getDrawable("4D");

        four = new TextButton("",fourStyle);
        four.setPosition(Gdx.graphics.getWidth()/2 - 400.0f,Gdx.graphics.getHeight()/2 - 200.0f);

        four.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!four.isDisabled()){
                buttonNum = 4;
                answer.add(buttonNum);
            }
            }

        });

        TextButtonStyle fiveStyle = new TextButton.TextButtonStyle();
        fiveStyle.font = font;
        fiveStyle.up = skin.getDrawable("5");
        fiveStyle.disabled = skin.getDrawable("5D");

        five = new TextButton("",fiveStyle);
        five.setPosition(Gdx.graphics.getWidth()/2 - 100.0f,Gdx.graphics.getHeight()/2 - 200.0f);

        five.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!five.isDisabled()){
                buttonNum = 5;
                answer.add(buttonNum);
            }
            }

        });

        TextButtonStyle sixStyle = new TextButton.TextButtonStyle();
        sixStyle.font = font;
        sixStyle.up = skin.getDrawable("6");
        sixStyle.disabled = skin.getDrawable("6D");

        six = new TextButton("",sixStyle);
        six.setPosition(Gdx.graphics.getWidth()/2 + 180.0f,Gdx.graphics.getHeight()/2 - 200.0f);

        six.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!six.isDisabled()){
                buttonNum = 6;
                answer.add(buttonNum);
            }
            }

        });

        TextButtonStyle sevenStyle = new TextButton.TextButtonStyle();
        sevenStyle.font = font;
        sevenStyle.up = skin.getDrawable("7");
        sevenStyle.disabled = skin.getDrawable("7D");

        seven = new TextButton("",sevenStyle);
        seven.setPosition(Gdx.graphics.getWidth()/2 - 400.0f,Gdx.graphics.getHeight()/2 - 380.0f);

        seven.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!seven.isDisabled()){
                buttonNum = 7;
                answer.add(buttonNum);
            }
            }

        });

        TextButtonStyle eightStyle = new TextButton.TextButtonStyle();
        eightStyle.font = font;
        eightStyle.up = skin.getDrawable("8");
        eightStyle.disabled = skin.getDrawable("8D");

        eight = new TextButton("",eightStyle);
        eight.setPosition(Gdx.graphics.getWidth()/2  - 100.0f,Gdx.graphics.getHeight()/2 - 380.0f);

        eight.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!eight.isDisabled()){
                buttonNum = 8;
                answer.add(buttonNum);
            }
            }

        });

        TextButtonStyle nineStyle = new TextButton.TextButtonStyle();
        nineStyle.font = font;
        nineStyle.up = skin.getDrawable("9");
        nineStyle.disabled = skin.getDrawable("9D");

        nine = new TextButton("",nineStyle);
        nine.setPosition(Gdx.graphics.getWidth()/2 + 180.0f,Gdx.graphics.getHeight()/2 - 380.0f);

        nine.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!nine.isDisabled()){
                buttonNum = 9;
                answer.add(buttonNum);
            }
            }

        });

        TextButtonStyle zeroStyle = new TextButton.TextButtonStyle();
        zeroStyle.font = font;
        zeroStyle.up = skin.getDrawable("0");
        zeroStyle.disabled = skin.getDrawable("0D");

        zero = new TextButton("",zeroStyle);
        zero.setPosition(Gdx.graphics.getWidth()/2 - 100,Gdx.graphics.getHeight()/2 - 550.0f);

        zero.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!zero.isDisabled()){
                buttonNum = 0;
                answer.add(buttonNum);
            }
            }

        });

        stage.addActor(one);
        stage.addActor(two);
        stage.addActor(three);
        stage.addActor(four);
        stage.addActor(five);
        stage.addActor(six);
        stage.addActor(seven);
        stage.addActor(eight);
        stage.addActor(nine);
        stage.addActor(zero);


        label = new Label(display.get(0).toString(), new Label.LabelStyle(font, Color.WHITE));
        label.setPosition(Gdx.graphics.getWidth()/2 - 380.0f ,Gdx.graphics.getHeight()/2 + 300.0f);
        label.setFontScale(1.2f);
        stage.addActor(label);

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
                    answer.clear();
                    display.clear();
                    game.setScreen(new RunningSpanScreen(game));

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




        if (display.equals(answer) && !answer.isEmpty() && display.size() == answer.size()){
                counter++;
                player.setScore(1);
                chain = "";
                display.clear();
                answer.clear();
                timer = 2;
                for (int i=0; i < counter; i++){
                    display.add(randomInt());
                    String concat = display.get(i).toString();
                    chain += concat;
                    label.setText(chain);
                    label.setVisible(true);

                }


        } else if (!display.equals(answer) && !answer.isEmpty() && display.size() == answer.size()){
                counter++;
                player.loseLife(3);
                chain = "";
                timer = 2;
                for (int i=0; i < counter; i++){
                    display.add(i,randomInt());
                    String concat = display.get(i).toString();
                    chain += concat;
                    label.setText(chain);
                    label.setVisible(true);
                }

        }






        stage.getBatch().begin();
        font.draw(stage.getBatch(), "Score " + player.getScore(), 100,1875);
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
            retry.setVisible(true);
            menu.setVisible(true);
            one.setVisible(false);
            two.setVisible(false);
            three.setVisible(false);
            four.setVisible(false);
            five.setVisible(false);
            six.setVisible(false);
            seven.setVisible(false);
            eight.setVisible(false);
            nine.setVisible(false);
            zero.setVisible(false);
            label.setVisible(false);
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

    }
    private int randomInt(){
        Random rand = new Random();
        int randInt = Math.abs(rand.nextInt()) % 10;
        return randInt;
    }
}

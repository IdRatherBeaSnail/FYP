package com.fyp.brain.game.screens.gameScreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
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
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.fyp.brain.game.MyGdxGame;
import com.fyp.brain.game.player.Player;
import com.fyp.brain.game.screens.GameSelect;
import com.fyp.brain.game.screens.mainScreen;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class SymbolScreen implements Screen {
    private ArrayList<Integer> display,xAxis,yAxis;
    private ArrayList<TextButton> buttonArray;
    private float timer,timer2,timer3,deltaTime, roundOne,roundTwo,roundThree,average,currentHighScore,countdownTimer;
    private Player player;
    private MyGdxGame game;
    private BitmapFont font;
    private Texture background,over,wrong,wrong2,wrong3,right,right2,right3,countdown,countdown2,countdown3;
    private Stage stage;
    private Skin skin;
    private TextureAtlas buttonAtlas;
    private TextButton one,two,three,four,five,six,tmp,retry,menu,back;
    private TextButtonStyle oneStyle;
    private int buttonNum,counter;
    private Label label;
    private Preferences score;
    private Viewport viewport;
    private Camera camera;

    public SymbolScreen(MyGdxGame game){
        display = new ArrayList<>();
        xAxis = new ArrayList<>();
        yAxis = new ArrayList<>();
        buttonArray = new ArrayList<>();

        xAxis.add(-415);
        xAxis.add(-115);
        xAxis.add(190);
        yAxis.add(550);
        yAxis.add(250);
        Collections.shuffle(xAxis);
        Collections.shuffle(yAxis);

        buttonNum = 7;
        deltaTime = 0;
        timer = 2;
        timer2 = 0;
        counter = 0;

        this.game = game;
        player = new Player();
        player.setLife(3);
        font = new BitmapFont(Gdx.files.internal("fonty.fnt"));
        background = new Texture("symbolBg.png");
        wrong = new Texture("symbwrong.png");
        wrong2 = new Texture("symbwrong.png");
        wrong3 = new Texture("symbwrong.png");

        right = new Texture("symbright.png");
        right2 = new Texture("symbright.png");
        right3 = new Texture("symbright.png");

        timer2 = 3;
        countdownTimer = Gdx.graphics.getDeltaTime();
        countdown = new Texture("count1.png");
        countdown2 = new Texture("count2.png");
        countdown3 = new Texture("count3.png");

        over = new Texture("symbolBgEnd.png");
        score = Gdx.app.getPreferences("Highscores");
        currentHighScore = score.getFloat("currentSymbolHighScore", 0);

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
        for (int i =0; i<6; i++) {
            display.add(i);
        }

        skin.addRegions(buttonAtlas);

        oneStyle = new TextButtonStyle();
        oneStyle.font = font;
        oneStyle.up = skin.getDrawable("circle");


        one = new TextButton("",oneStyle);
        one.setPosition(Gdx.graphics.getWidth()/2  + xAxis.get(0),Gdx.graphics.getHeight()/2 - yAxis.get(0));

        one.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!one.isDisabled()){
                    buttonNum = 0;
                    Collections.shuffle(xAxis);
                    Collections.shuffle(yAxis);


                }
            }

        });
        TextButtonStyle twoStyle = new TextButtonStyle();
        twoStyle.font = font;
        twoStyle.up = skin.getDrawable("square");

        two = new TextButton("",twoStyle);
        two.setPosition(Gdx.graphics.getWidth()/2  + xAxis.get(1),Gdx.graphics.getHeight()/2 - yAxis.get(1));
        two.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!two.isDisabled()){
                    buttonNum = 1;
                    Collections.shuffle(xAxis);
                    Collections.shuffle(yAxis);


                }
            }

        });
        TextButtonStyle threeStyle = new TextButtonStyle();
        threeStyle.font = font;
        threeStyle.up = skin.getDrawable("diamond");

        three = new TextButton("",threeStyle);
        three.setPosition(Gdx.graphics.getWidth()/2 + xAxis.get(2) ,Gdx.graphics.getHeight()/2 - yAxis.get(0));
        three.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!three.isDisabled()){
                    buttonNum = 2;
                    Collections.shuffle(xAxis);
                    Collections.shuffle(yAxis);

                }
            }

        });
        TextButtonStyle fourStyle = new TextButtonStyle();
        fourStyle.font = font;
        fourStyle.up = skin.getDrawable("ltri");

        four = new TextButton("",fourStyle);
        four.setPosition(Gdx.graphics.getWidth()/2  + xAxis.get(0),Gdx.graphics.getHeight()/2 - yAxis.get(1));
        four.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!four.isDisabled()){
                    buttonNum = 3;
                    Collections.shuffle(xAxis);
                    Collections.shuffle(yAxis);

                }
            }

        });
        TextButtonStyle fiveStyle = new TextButtonStyle();
        fiveStyle.font = font;
        fiveStyle.up = skin.getDrawable("rtri");

        five = new TextButton("",fiveStyle);
        five.setPosition(Gdx.graphics.getWidth()/2  + xAxis.get(1),Gdx.graphics.getHeight()/2 - yAxis.get(0));
        five.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!five.isDisabled()){
                    buttonNum = 4;
                    Collections.shuffle(xAxis);
                    Collections.shuffle(yAxis);

                }
            }

        });
        TextButtonStyle  sixStyle = new TextButtonStyle();
        sixStyle.font = font;
        sixStyle.up = skin.getDrawable("pentagon");

        six = new TextButton("",sixStyle);
        six.setPosition(Gdx.graphics.getWidth()/2  + xAxis.get(2),Gdx.graphics.getHeight()/2 - yAxis.get(1));
        six.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!six.isDisabled()){
                    buttonNum = 5;
                    Collections.shuffle(xAxis);
                    Collections.shuffle(yAxis);

                }
            }

        });

        stage.addActor(one);
        stage.addActor(two);
        stage.addActor(three);
        stage.addActor(four);
        stage.addActor(five);
        stage.addActor(six);

        buttonArray.add(one);
        buttonArray.add(two);
        buttonArray.add(three);
        buttonArray.add(four);
        buttonArray.add(five);
        buttonArray.add(six);

        TextButtonStyle retryStyle = new TextButtonStyle();
        retryStyle.up = skin.getDrawable("retry");
        retryStyle.font = font;

        retry = new TextButton("",retryStyle);
        retry.setPosition(Gdx.graphics.getWidth()/2 -150 ,Gdx.graphics.getHeight()/2 - 380.0f);

        retry.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(player.getLife() <= 0){

                    game.setScreen(new SymbolScreen(game));

                }
            }

        });

        stage.addActor(retry);


        TextButtonStyle menuStyle = new TextButtonStyle();
        menuStyle.up = skin.getDrawable("mainmenu");
        menuStyle.font = font;

        menu = new TextButton("",menuStyle);
        menu.setPosition(Gdx.graphics.getWidth()/2 -250,Gdx.graphics.getHeight()/2 - 580.0f);

        menu.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                game.setScreen(new mainScreen(game));


            }

        });

        stage.addActor(menu);

        Collections.shuffle(display);
        tmp = new TextButton (buttonArray.get(display.get(0)).getText().toString(),buttonArray.get(display.get(0)).getStyle());
        tmp.setVisible(false);
        tmp.setPosition(Gdx.graphics.getWidth() / 2 - 100.0f, Gdx.graphics.getHeight() / 2 + 150.0f);
        stage.addActor(tmp);

        label = new Label("Symbol",new Label.LabelStyle(font, Color.WHITE));
        label.setPosition(Gdx.graphics.getWidth()/2 - 140.0f ,Gdx.graphics.getHeight()/2 + 440.0f);
        label.setFontScale(1.5f);
        stage.addActor(label);

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




    }

    @Override
    public void render(float v) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.getBatch().setProjectionMatrix(stage.getCamera().combined);
        stage.getCamera().update();
        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        stage.getBatch().end();
        menu.setVisible(false);
        retry.setVisible(false);

        if (timer3 != 0){
            timer3 -= countdownTimer;
        }
        if(timer3 <= 3 && timer3 > 2 ){
            stage.getBatch().begin();
            stage.getBatch().draw(countdown3, 0, 0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            stage.getBatch().end();
        } else if (timer3 <= 2 && timer3 > 1){
            stage.getBatch().begin();
            stage.getBatch().draw(countdown2, 0, 0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            stage.getBatch().end();
        } else if (timer3 <= 1 && timer3 > 0){
            stage.getBatch().begin();
            stage.getBatch().draw(countdown, 0, 0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            stage.getBatch().end();
        } else if (timer3 <= 0) {


            deltaTime = Gdx.graphics.getDeltaTime();

            if (timer > 0 && player.getLife() != 0) {
                timer -= deltaTime;
                one.setVisible(false);
                two.setVisible(false);
                three.setVisible(false);
                four.setVisible(false);
                five.setVisible(false);
                six.setVisible(false);
                tmp.setVisible(true);
                label.setVisible(true);
                timer2 = 0;
            } else if (timer <= 0 && player.getLife() != 0) {
                timer2 += deltaTime;
                tmp.setVisible(false);
                label.setVisible(false);
                one.setVisible(true);
                two.setVisible(true);
                three.setVisible(true);
                four.setVisible(true);
                five.setVisible(true);
                six.setVisible(true);
                if (display.get(0) == buttonNum && buttonNum != 7) {

                    if (player.getLife() == 3) {
                        roundOne = timer2;
                    } else if (player.getLife() == 2) {
                        roundTwo = timer2;
                    } else if (player.getLife() == 1) {
                        roundThree = timer2;
                    }
                    player.loseLife(1);
                    timer = 2;
                    buttonNum = 7;
                    Collections.shuffle(display);
                    tmp.setStyle(buttonArray.get(display.get(0)).getStyle());
                    Collections.shuffle(xAxis);
                    Collections.shuffle(yAxis);
                    one.setVisible(false);
                    two.setVisible(false);
                    three.setVisible(false);
                    four.setVisible(false);
                    five.setVisible(false);
                    six.setVisible(false);
                    one.setPosition(Gdx.graphics.getWidth()/2  + xAxis.get(0),Gdx.graphics.getHeight()/2 - yAxis.get(0));
                    two.setPosition(Gdx.graphics.getWidth()/2  + xAxis.get(1),Gdx.graphics.getHeight()/2 - yAxis.get(1));
                    three.setPosition(Gdx.graphics.getWidth()/2  + xAxis.get(2),Gdx.graphics.getHeight()/2 - yAxis.get(0));
                    four.setPosition(Gdx.graphics.getWidth()/2  + xAxis.get(0),Gdx.graphics.getHeight()/2 - yAxis.get(1));
                    five.setPosition(Gdx.graphics.getWidth()/2  + xAxis.get(1),Gdx.graphics.getHeight()/2 - yAxis.get(0));
                    six.setPosition(Gdx.graphics.getWidth()/2  + xAxis.get(2),Gdx.graphics.getHeight()/2 - yAxis.get(1));
                } else if (display.get(0) != buttonNum && buttonNum != 7) {
                    // timer for rounds counter;
                    if (player.getLife() == 3) {
                        roundOne = timer2+1.000f;
                    } else if (player.getLife() == 2) {
                        roundTwo = timer2+1.000f;
                    } else if (player.getLife() == 1) {
                        roundThree = timer2+1.000f;
                    }
                    player.loseLife(1);
                    timer = 2;
                    buttonNum = 7;
                    Collections.shuffle(display);
                    tmp.setStyle(buttonArray.get(display.get(0)).getStyle());
                    Collections.shuffle(xAxis);
                    Collections.shuffle(yAxis);
                    one.setVisible(false);
                    two.setVisible(false);
                    three.setVisible(false);
                    four.setVisible(false);
                    five.setVisible(false);
                    six.setVisible(false);
                    one.setPosition(Gdx.graphics.getWidth()/2  + xAxis.get(0),Gdx.graphics.getHeight()/2 - yAxis.get(0));
                    two.setPosition(Gdx.graphics.getWidth()/2  + xAxis.get(1),Gdx.graphics.getHeight()/2 - yAxis.get(1));
                    three.setPosition(Gdx.graphics.getWidth()/2  + xAxis.get(2),Gdx.graphics.getHeight()/2 - yAxis.get(0));
                    four.setPosition(Gdx.graphics.getWidth()/2  + xAxis.get(0),Gdx.graphics.getHeight()/2 - yAxis.get(1));
                    five.setPosition(Gdx.graphics.getWidth()/2  + xAxis.get(1),Gdx.graphics.getHeight()/2 - yAxis.get(0));
                    six.setPosition(Gdx.graphics.getWidth()/2  + xAxis.get(2),Gdx.graphics.getHeight()/2 - yAxis.get(1));
                }

            }

            if (player.getLife() == 0) {
                average = (roundOne + roundThree + roundTwo) / 3;
                stage.getBatch().begin();
                stage.getBatch().draw(over, 0, 0);
                font.draw(stage.getBatch(), new DecimalFormat("##.###").format(roundOne), Gdx.graphics.getWidth() / 2 + 160, Gdx.graphics.getHeight() / 2 + 215);
                font.draw(stage.getBatch(), new DecimalFormat("##.###").format(roundTwo), Gdx.graphics.getWidth() / 2 + 160, Gdx.graphics.getHeight() / 2 + 130);
                font.draw(stage.getBatch(), new DecimalFormat("##.###").format(roundThree), Gdx.graphics.getWidth() / 2 + 160, Gdx.graphics.getHeight() / 2 + 40);
                font.draw(stage.getBatch(), new DecimalFormat("##.###").format(average), Gdx.graphics.getWidth() / 2 + 160, Gdx.graphics.getHeight() / 2 - 80);

                retry.setVisible(true);
                menu.setVisible(true);
                one.setVisible(false);
                two.setVisible(false);
                three.setVisible(false);
                four.setVisible(false);
                five.setVisible(false);
                six.setVisible(false);
                tmp.setVisible(false);
                if (currentHighScore > average || currentHighScore == 0) {
                    score.putFloat("currentSymbolHighScore", average);
                    score.flush();
                }

                if (roundOne == 1) {

                    stage.getBatch().draw(wrong, Gdx.graphics.getWidth() / 2 - 400, Gdx.graphics.getHeight() / 2 + 150);

                } else if (roundOne != 1) {

                    stage.getBatch().draw(right, Gdx.graphics.getWidth() / 2 - 400, Gdx.graphics.getHeight() / 2 + 150);

                }

                if (roundTwo == 1) {

                    stage.getBatch().draw(wrong2, Gdx.graphics.getWidth() / 2 - 400, Gdx.graphics.getHeight() / 2 + 70);

                } else if (roundTwo != 1) {

                    stage.getBatch().draw(right2, Gdx.graphics.getWidth() / 2 - 400, Gdx.graphics.getHeight() / 2 + 70);

                }

                if (roundThree == 1) {

                    stage.getBatch().draw(wrong3, Gdx.graphics.getWidth() / 2 - 400, Gdx.graphics.getHeight() / 2 - 15);

                } else if (roundThree != 1) {

                    stage.getBatch().draw(right3, Gdx.graphics.getWidth() / 2 - 400, Gdx.graphics.getHeight() / 2 - 15);

                }

                stage.getBatch().end();


            }

            stage.draw();
            stage.act();
        }
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


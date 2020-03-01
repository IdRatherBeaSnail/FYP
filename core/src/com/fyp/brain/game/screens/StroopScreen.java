package com.fyp.brain.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
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
import java.text.DecimalFormat;
import java.util.Random;

public class StroopScreen implements Screen {

    private Stage stage;
    private BitmapFont font,font2;
    private Player player;
    private Texture background,over,heart,heart2,heart3,dheart,dheart2,dheart3;
    private int counter, timerCounter,currentHighScore;
    private String currentColour;
    private  Color[] colorType;
    private final String[] colourArray = {"GREEN","WHITE","BLUE","ORANGE","RED","YELLOW",
            "BLUE","GREEN","RED","RED","WHITE","ORANGE","YELLOW",
            "WHITE","BLUE","ORANGE","GREEN","RED","BLUE","GREEN",
            "GREEN","WHITE","BLUE","ORANGE","RED","YELLOW","YELLOW",
            "WHITE","BLUE","ORANGE","GREEN","RED","BLUE","GREEN",
            "BLUE","GREEN","RED","RED","WHITE","ORANGE","YELLOW"};
    private Skin skin;
    private TextureAtlas buttonAtlas;
    private TextButton orange,yellow,white,blue,green,red,retry,menu;
    private MyGdxGame game;
    private float deltaTime,timer;
    private Label clock;
    private Preferences score;

    public StroopScreen(MyGdxGame game) {

        this.game = game;
        player = new Player();
        player.setLife(3);
        font = new BitmapFont(Gdx.files.internal("fonty.fnt"));
        font2 = new BitmapFont(Gdx.files.internal("fonty.fnt"));
        background = new Texture("Stroop.png");
        counter = 0;
        currentColour = "";
        colorType = new Color[] {Color.BLUE,Color.GREEN,Color.RED,Color.WHITE,Color.YELLOW,Color.ORANGE};
        deltaTime = 0;
        timerCounter = 3;
        timer = timerCounter;

        over = new Texture("nbackBackgroundFinished.png");

        heart = new Texture("heart.png");
        heart2 = new Texture("heart.png");
        heart3 = new Texture("heart.png");

        dheart = new Texture("heartDead.png");
        dheart2 = new Texture("heartDead.png");
        dheart3 = new Texture("heartDead.png");
        score = Gdx.app.getPreferences("Highscores");
        currentHighScore = score.getInteger("currentStroopHighScore", 0);
        stage = new Stage (new ScreenViewport());
    }


    @Override
    public void show() {
        stage.clear();
        Gdx.input.setInputProcessor(stage);
        skin = new Skin();
        buttonAtlas = new TextureAtlas("nBack.pack");

        skin.addRegions(buttonAtlas);

        TextButtonStyle yellowStyle = new TextButtonStyle();
        yellowStyle.font = font;
        yellowStyle.up = skin.getDrawable("yellow");

        yellow = new TextButton("",yellowStyle);
        yellow.setPosition(Gdx.graphics.getWidth()/2 + 50.0f,Gdx.graphics.getHeight()/2 - 550.0f);

        yellow.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                currentColour = "YELLOW";
                if(colourArray[counter].equals(currentColour)){
                    counter++;
                    timer = timerCounter;
                    font.setColor(randomColour());
                    player.setScore(1);

                } else if (!colourArray[counter].equals(currentColour)){
                    counter++;
                    timer = timerCounter;
                    font.setColor(randomColour());
                    player.loseLife(1);
                }
            }

        });


        stage.addActor(yellow);

        TextButtonStyle orangeStyle = new TextButtonStyle();
        orangeStyle.font = font;
        orangeStyle.up = skin.getDrawable("orange");

        orange = new TextButton("",orangeStyle);
        orange.setPosition(Gdx.graphics.getWidth()/2 + 50.0f,Gdx.graphics.getHeight()/2 - 250.0f);

        orange.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                currentColour = "ORANGE";
                if(colourArray[counter].equals(currentColour)){
                    counter++;
                    timer = timerCounter;
                    font.setColor(randomColour());
                    player.setScore(1);

                } else if (!colourArray[counter].equals(currentColour)){
                    counter++;
                    timer = timerCounter;
                    font.setColor(randomColour());
                    player.loseLife(1);
                }
            }

        });

        stage.addActor(orange);

        TextButtonStyle whiteStyle = new TextButtonStyle();
        whiteStyle.font = font;
        whiteStyle.up = skin.getDrawable("white");

        white = new TextButton("",whiteStyle);
        white.setPosition(Gdx.graphics.getWidth()/2 + 50.0f,Gdx.graphics.getHeight()/2 - 400.0f);

        white.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                currentColour = "WHITE";
                if(colourArray[counter].equals(currentColour)){
                    counter++;
                    timer = timerCounter;
                    font.setColor(randomColour());
                    player.setScore(1);

                } else if (!colourArray[counter].equals(currentColour)){
                    counter++;
                    timer = timerCounter;
                    font.setColor(randomColour());
                    player.loseLife(1);
                }
            }

        });

        stage.addActor(white);

        TextButtonStyle blueStyle = new TextButtonStyle();
        blueStyle.font = font;
        blueStyle.up = skin.getDrawable("blue");

        blue = new TextButton("",blueStyle);
        blue.setPosition(Gdx.graphics.getWidth()/2 - 400.0f,Gdx.graphics.getHeight()/2 - 250.0f);

        blue.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                currentColour = "BLUE";
                if(colourArray[counter].equals(currentColour)){
                    counter++;
                    timer = timerCounter;
                    font.setColor(randomColour());
                    player.setScore(1);

                } else if (!colourArray[counter].equals(currentColour)){
                    counter++;
                    timer = timerCounter;
                    font.setColor(randomColour());
                    player.loseLife(1);
                }
            }

        });

        stage.addActor(blue);

        TextButtonStyle greenStyle = new TextButtonStyle();
        greenStyle.font = font;
        greenStyle.up = skin.getDrawable("green");

        green = new TextButton("",greenStyle);
        green.setPosition(Gdx.graphics.getWidth()/2 - 400.0f,Gdx.graphics.getHeight()/2 - 400.0f);

        green.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                currentColour = "GREEN";
                if(colourArray[counter].equals(currentColour)){
                    counter++;
                    timer = timerCounter;
                    font.setColor(randomColour());
                    player.setScore(1);

                } else if (!colourArray[counter].equals(currentColour)){
                    counter++;
                    timer = timerCounter;
                    font.setColor(randomColour());
                    player.loseLife(1);
                }
            }

        });

        stage.addActor(green);

        TextButtonStyle redStyle = new TextButtonStyle();
        redStyle.font = font;
        redStyle.up = skin.getDrawable("red");

        red = new TextButton("",redStyle);
        red.setPosition(Gdx.graphics.getWidth()/2 - 400.0f,Gdx.graphics.getHeight()/2 - 550.0f);

        red.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                currentColour = "RED";
                if(colourArray[counter].equals(currentColour)){
                    counter++;
                    timer = timerCounter;
                    font.setColor(randomColour());
                    player.setScore(1);

                } else if (!colourArray[counter].equals(currentColour)){
                    counter++;
                    timer = timerCounter;
                    font.setColor(randomColour());
                    player.loseLife(1);
                }
            }

        });

        stage.addActor(red);

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
                    currentColour = "";
                    game.setScreen(new StroopScreen(game));

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

        Label tims = new Label("Time", new Label.LabelStyle(font, Color.WHITE));
        tims.setPosition(490,1845);
        tims.setFontScale(0.9f);
        stage.addActor(tims);

        clock = new Label("", new Label.LabelStyle(font, Color.WHITE));
        clock.setPosition(505,1805);
        clock.setFontScale(0.8f);
        stage.addActor(clock);


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.getBatch().begin();
        stage.getBatch().draw(background, 0, 0);
        stage.getBatch().end();
        menu.setVisible(false);
        retry.setVisible(false);

        if(player.getLife() != 0){

            deltaTime = Gdx.graphics.getDeltaTime();
            timer = timer - deltaTime;

            clock.setText(new DecimalFormat("##.##").format(timer));

            if(timer <= 0){
                counter++;
                player.loseLife(1);
                timer = timerCounter;
            }
        }

        if (counter >= 5) {
            timerCounter = 2;
        } else if (counter >=15) {
            timerCounter = 1;
        }


        stage.getBatch().begin();
        font2.draw(stage.getBatch(), "Score " + player.getScore(), 100,1875);
        font.draw(stage.getBatch(), colourArray[counter], Gdx.graphics.getWidth()/2 - 100.0f ,Gdx.graphics.getHeight()/2 + 250.0f);
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
            font2.draw(stage.getBatch(), Integer.toString(player.getScore()), Gdx.graphics.getWidth()/2 + 90,Gdx.graphics.getHeight()/2 + 215);
            stage.getBatch().end();
            retry.setVisible(true);
            menu.setVisible(true);
            yellow.setVisible(false);
            orange.setVisible(false);
            white.setVisible(false);
            blue.setVisible(false);
            red.setVisible(false);
            green.setVisible(false);
            clock.setVisible(false);
            if(currentHighScore < player.getScore()) {
                score.putInteger("currentStroopHighScore", player.getScore());
                score.flush();
            }
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

    private Color randomColour(){
        Random rand = new Random();
        int randInt = Math.abs(rand.nextInt()) % 6;
        Color ranColour = new Color(colorType[randInt]);

        return ranColour;
    }




}

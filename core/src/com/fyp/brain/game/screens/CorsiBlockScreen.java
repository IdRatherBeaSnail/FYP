package com.fyp.brain.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
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
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.fyp.brain.game.MyGdxGame;
import com.fyp.brain.game.player.Player;

import java.util.ArrayList;
import java.util.Collections;


public class CorsiBlockScreen implements Screen {
    private ArrayList<Integer> display,answer,randNum;
    private ArrayList<TextButton> buttonArray;
    private int counter;
    private float timer,deltaTime;
    private Player player;
    private MyGdxGame game;
    private BitmapFont font;
    private Texture background,over,heart,heart2,heart3,dheart,dheart2,dheart3;;
    private Stage stage;
    private Skin skin;
    private TextureAtlas buttonAtlas;
    private TextButton one,two,three,four,five,six,seven,eight,nine,ten,eleven,twelve,thirteen,
                       fourteen,fifteen,sixteen,seventeen,eighteen,nineteen,twenty,retry,menu,back;
    private TextButtonStyle change,oneStyle;
    private int buttonNum,currentHighScore;
    private Preferences score;


    public CorsiBlockScreen(MyGdxGame game){

        display = new ArrayList<>();
        answer = new ArrayList<>();
        randNum = new ArrayList<>();
        buttonArray = new ArrayList<>();


        for (int i = 0; i<16; i++){
            randNum.add(new Integer(i));
        }

        display.add(randNum.get(0));
        deltaTime = 0;
        timer = 2;
        counter = 1;

        score = Gdx.app.getPreferences("Highscores");
        currentHighScore = score.getInteger("currentCorsiHighScore", 0);

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

        stage = new Stage(new FitViewport(1080.0f,1920.0f));
    }
    @Override
    public void show() {

        stage.clear();
        Gdx.input.setInputProcessor(stage);
        skin = new Skin();
        buttonAtlas = new TextureAtlas("nBack.pack");

        skin.addRegions(buttonAtlas);

        change = new TextButtonStyle();
        change.font = font;
        change.up = skin.getDrawable("corsiOn");

        oneStyle = new TextButtonStyle();
        oneStyle.font = font;
        oneStyle.up = skin.getDrawable("corsiOff");
        oneStyle.down = skin.getDrawable("corsiOn");

        one = new TextButton("",oneStyle);
        one.setPosition(Gdx.graphics.getWidth()/2  - 445.0f,Gdx.graphics.getHeight()/2 + 280.0f);

        one.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!one.isDisabled()){
                    buttonNum = 0;
                    answer.add(buttonNum);


                }
            }

        });




        two = new TextButton("",oneStyle);
        two.setPosition(Gdx.graphics.getWidth()/2  - 215.0f,Gdx.graphics.getHeight()/2 + 280.0f);

        two.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!two.isDisabled()){
                    buttonNum = 1;
                    answer.add(buttonNum);

                }
            }

        });





        three = new TextButton("",oneStyle);
        three.setPosition(Gdx.graphics.getWidth()/2 + 15.0f ,Gdx.graphics.getHeight()/2 + 280.0f);

        three.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!three.isDisabled()){
                    buttonNum = 2;
                    answer.add(buttonNum);

                }
            }

        });




        four = new TextButton("",oneStyle);
        four.setPosition(Gdx.graphics.getWidth()/2  + 240.0f,Gdx.graphics.getHeight()/2 + 280.0f);

        four.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!four.isDisabled()){
                    buttonNum = 3;
                    answer.add(buttonNum);

                }
            }

        });




        five = new TextButton("",oneStyle);
        five.setPosition(Gdx.graphics.getWidth()/2  - 445.0f,Gdx.graphics.getHeight()/2 + 50.0f);

        five.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!five.isDisabled()){
                    buttonNum = 4;
                    answer.add(buttonNum);

                }
            }

        });




        six = new TextButton("",oneStyle);
        six.setPosition(Gdx.graphics.getWidth()/2  - 215.0f,Gdx.graphics.getHeight()/2 + 50.0f);

        six.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!six.isDisabled()){
                    buttonNum = 5;
                    answer.add(buttonNum);

                }
            }

        });




        seven = new TextButton("",oneStyle);
        seven.setPosition(Gdx.graphics.getWidth()/2 + 15.0f ,Gdx.graphics.getHeight()/2 + 50.0f);

        seven.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!seven.isDisabled()){
                    buttonNum = 6;
                    answer.add(buttonNum);

                }
            }

        });



        eight = new TextButton("",oneStyle);
        eight.setPosition(Gdx.graphics.getWidth()/2  + 240.0f,Gdx.graphics.getHeight()/2 + 50.0f);

        eight.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!eight.isDisabled()){
                    buttonNum = 7;
                    answer.add(buttonNum);

                }
            }

        });




        nine = new TextButton("",oneStyle);
        nine.setPosition(Gdx.graphics.getWidth()/2  - 445.0f,Gdx.graphics.getHeight()/2 - 180.0f);

        nine.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!nine.isDisabled()){
                    buttonNum = 8;
                    answer.add(buttonNum);

                }
            }

        });




        ten = new TextButton("",oneStyle);
        ten.setPosition(Gdx.graphics.getWidth()/2  - 215.0f,Gdx.graphics.getHeight()/2 - 180.0f);

        ten.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!ten.isDisabled()){
                    buttonNum = 9;
                    answer.add(buttonNum);

                }
            }

        });




        eleven = new TextButton("",oneStyle);
        eleven.setPosition(Gdx.graphics.getWidth()/2  + 15.0f,Gdx.graphics.getHeight()/2 - 180.0f);

        eleven.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!eleven.isDisabled()){
                    buttonNum = 10;
                    answer.add(buttonNum);

                }
            }

        });



        twelve = new TextButton("",oneStyle);
        twelve.setPosition(Gdx.graphics.getWidth()/2  + 240.0f,Gdx.graphics.getHeight()/2 - 180.0f);

        twelve.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!twelve.isDisabled()){
                    buttonNum = 11;
                    answer.add(buttonNum);

                }
            }

        });



        thirteen = new TextButton("",oneStyle);
        thirteen.setPosition(Gdx.graphics.getWidth()/2  - 445.0f,Gdx.graphics.getHeight()/2 - 410.0f);

        thirteen.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!thirteen.isDisabled()){
                    buttonNum = 12;
                    answer.add(buttonNum);

                }
            }

        });



        fourteen = new TextButton("",oneStyle);
        fourteen.setPosition(Gdx.graphics.getWidth()/2  - 215.0f,Gdx.graphics.getHeight()/2 - 410.0f);

        fourteen.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!fourteen.isDisabled()){
                    buttonNum = 13;
                    answer.add(buttonNum);

                }
            }

        });



        fifteen = new TextButton("",oneStyle);
        fifteen.setPosition(Gdx.graphics.getWidth()/2  + 15.0f,Gdx.graphics.getHeight()/2 - 410.0f);

        fifteen.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!fifteen.isDisabled()){
                    buttonNum = 14;
                    answer.add(buttonNum);

                }
            }

        });


        sixteen = new TextButton("",oneStyle);
        sixteen.setPosition(Gdx.graphics.getWidth()/2  + 240.0f,Gdx.graphics.getHeight()/2 - 410.0f);

        sixteen.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!sixteen.isDisabled()){
                    buttonNum = 15;
                    answer.add(buttonNum);

                }
            }

        });

        seventeen = new TextButton("",oneStyle);
        seventeen.setPosition(Gdx.graphics.getWidth()/2  - 445.0f,Gdx.graphics.getHeight()/2 - 640.0f);

        seventeen.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!seventeen.isDisabled()){
                    buttonNum = 16;
                    answer.add(buttonNum);

                }
            }

        });

        eighteen = new TextButton("",oneStyle);
        eighteen.setPosition(Gdx.graphics.getWidth()/2  - 215.0f,Gdx.graphics.getHeight()/2 - 640.0f);

        eighteen.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!eighteen.isDisabled()){
                    buttonNum = 17;
                    answer.add(buttonNum);

                }
            }

        });

        nineteen = new TextButton("",oneStyle);
        nineteen.setPosition(Gdx.graphics.getWidth()/2  + 15.0f,Gdx.graphics.getHeight()/2 - 640.0f);

        nineteen.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!nineteen.isDisabled()){
                    buttonNum = 18;
                    answer.add(buttonNum);

                }
            }

        });

        twenty = new TextButton("",oneStyle);
        twenty.setPosition(Gdx.graphics.getWidth()/2  + 240.0f,Gdx.graphics.getHeight()/2 - 640.0f);

        twenty.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(!twenty.isDisabled()){
                    buttonNum = 19;
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
        stage.addActor(ten);
        stage.addActor(eleven);
        stage.addActor(twelve);
        stage.addActor(thirteen);
        stage.addActor(fourteen);
        stage.addActor(fifteen);
        stage.addActor(sixteen);
        stage.addActor(seventeen);
        stage.addActor(eighteen);
        stage.addActor(nineteen);
        stage.addActor(twenty);


        buttonArray.add(one);
        buttonArray.add(two);
        buttonArray.add(three);
        buttonArray.add(four);
        buttonArray.add(five);
        buttonArray.add(six);
        buttonArray.add(seven);
        buttonArray.add(eight);
        buttonArray.add(nine);
        buttonArray.add(ten);
        buttonArray.add(eleven);
        buttonArray.add(twelve);
        buttonArray.add(thirteen);
        buttonArray.add(fourteen);
        buttonArray.add(fifteen);
        buttonArray.add(sixteen);
        buttonArray.add(seventeen);
        buttonArray.add(eighteen);
        buttonArray.add(nineteen);
        buttonArray.add(twenty);


        TextButton.TextButtonStyle retryStyle = new TextButton.TextButtonStyle();
        retryStyle.up = skin.getDrawable("retry");
        retryStyle.font = font;

        retry = new TextButton("",retryStyle);
        retry.setPosition(Gdx.graphics.getWidth()/2 -150 ,Gdx.graphics.getHeight()/2 - 250.0f);

        retry.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                if(player.getLife() <= 0){

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
            ten.setDisabled(true);
            eleven.setDisabled(true);
            twelve.setDisabled(true);
            thirteen.setDisabled(true);
            fourteen.setDisabled(true);
            fifteen.setDisabled(true);
            sixteen.setDisabled(true);
            seventeen.setDisabled(true);
            eighteen.setDisabled(true);
            nineteen.setDisabled(true);
            twenty.setDisabled(true);

            for (int i =0; i < counter; i++) {
                buttonArray.get(display.get(i)).setStyle(change);
            }

        } else if (timer <= 0 ) {
            one.setDisabled(false);
            two.setDisabled(false);
            three.setDisabled(false);
            four.setDisabled(false);
            five.setDisabled(false);
            six.setDisabled(false);
            seven.setDisabled(false);
            eight.setDisabled(false);
            nine.setDisabled(false);
            ten.setDisabled(false);
            eleven.setDisabled(false);
            twelve.setDisabled(false);
            thirteen.setDisabled(false);
            fourteen.setDisabled(false);
            fifteen.setDisabled(false);
            sixteen.setDisabled(false);
            seventeen.setDisabled(false);
            eighteen.setDisabled(false);
            nineteen.setDisabled(false);
            twenty.setDisabled(false);


            for (int i =0; i < counter; i++) {
                buttonArray.get(display.get(i)).setStyle(oneStyle);

            }

        }




        if(display.size() == answer.size()){
            Collections.sort(display);
            Collections.sort(answer);
            if(display.equals(answer) && !answer.isEmpty()){

                player.setScore(1);
                display.clear();
                answer.clear();
                timer = 1;

                one.setStyle(oneStyle);
                two.setStyle(oneStyle);
                three.setStyle(oneStyle);
                four.setStyle(oneStyle);
                five.setStyle(oneStyle);
                six.setStyle(oneStyle);
                seven.setStyle(oneStyle);
                eight.setStyle(oneStyle);
                nine.setStyle(oneStyle);
                ten.setStyle(oneStyle);
                eleven.setStyle(oneStyle);
                twelve.setStyle(oneStyle);
                thirteen.setStyle(oneStyle);
                fourteen.setStyle(oneStyle);
                fifteen.setStyle(oneStyle);
                sixteen.setStyle(oneStyle);
                seventeen.setStyle(oneStyle);
                eighteen.setStyle(oneStyle);
                nineteen.setStyle(oneStyle);
                twenty.setStyle(oneStyle);

                Collections.shuffle(randNum);

                if(player.getScore() == 1){
                    counter = 3;
                } else if (player.getScore() <= 5){
                    counter = 5;
                } else if (player.getScore() <= 10){
                    counter = 7;
                }else if (player.getScore() > 10){
                    counter = 8;
                }

                for (int i =0; i < counter; i++){
                    display.add(randNum.get(i));
                }
            } else if (!display.equals(answer) && !answer.isEmpty()) {

                player.loseLife(1);
                display.clear();
                answer.clear();
                timer = 1;
                one.setStyle(oneStyle);
                two.setStyle(oneStyle);
                three.setStyle(oneStyle);
                four.setStyle(oneStyle);
                five.setStyle(oneStyle);
                six.setStyle(oneStyle);
                seven.setStyle(oneStyle);
                eight.setStyle(oneStyle);
                nine.setStyle(oneStyle);
                ten.setStyle(oneStyle);
                eleven.setStyle(oneStyle);
                twelve.setStyle(oneStyle);
                thirteen.setStyle(oneStyle);
                fourteen.setStyle(oneStyle);
                fifteen.setStyle(oneStyle);
                sixteen.setStyle(oneStyle);
                seventeen.setStyle(oneStyle);
                eighteen.setStyle(oneStyle);
                nineteen.setStyle(oneStyle);
                twenty.setStyle(oneStyle);
                Collections.shuffle(randNum);
                if(player.getScore() == 1){
                    counter = 3;
                } else if (player.getScore() <= 5){
                    counter = 5;
                } else if (player.getScore() <= 10){
                    counter = 7;
                }else if (player.getScore() > 10){
                    counter = 8;
                }

                for (int i =0; i < counter; i++){
                    display.add(randNum.get(i));
                }

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
            ten.setVisible(false);
            eleven.setVisible(false);
            twelve.setVisible(false);
            thirteen.setVisible(false);
            fourteen.setVisible(false);
            fifteen.setVisible(false);
            sixteen.setVisible(false);
            seventeen.setVisible(false);
            eighteen.setVisible(false);
            nineteen.setVisible(false);
            twenty.setVisible(false);
            if(currentHighScore < player.getScore()) {
                score.putInteger("currentCorsiHighScore", player.getScore());
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
        stage.dispose();
        buttonAtlas.dispose();
        font.dispose();
        skin.dispose();
    }


}

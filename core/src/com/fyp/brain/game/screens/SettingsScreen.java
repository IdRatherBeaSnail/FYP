package com.fyp.brain.game.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Slider.SliderStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.fyp.brain.game.MyGdxGame;


public class SettingsScreen implements  Screen{
    private Stage stage;
    private Texture sliderBackgroundTexture;
    private Texture sliderKnobTexture;
    private Texture settingsBackground;
    private Slider musicSlider;
    private Slider soundSlider;
    private TextButtonStyle textButtonStyle;
    private TextButtonStyle textButtonStyle2;
    private TextButtonStyle textButtonStyle3;
    private BitmapFont font;
    private Skin skin;
    private TextureAtlas buttonAtlas;
    private TextButton soundButton,musicButton,back;
    private Sound hover;
    private Preferences audio;
    private MyGdxGame game;
    private Viewport viewport;
    private Camera camera;

    public SettingsScreen(MyGdxGame game){

        this.game = game;
        settingsBackground =  new Texture("settingsBg.png");
        font = new BitmapFont(Gdx.files.internal("fonty.fnt"));
        camera = new OrthographicCamera(1080.0f,1920.0f);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        viewport = new FitViewport(1080.0f,1920.0f,camera);
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
        audio = Gdx.app.getPreferences("Audio");

    }

    @Override
    public void show() {
        stage.clear();
        Gdx.input.setInputProcessor(stage);
        skin = new Skin();
        buttonAtlas = new TextureAtlas("nBack.pack");

        skin.addRegions(buttonAtlas);

        TextButtonStyle backStyle = new TextButtonStyle();
        backStyle.font = font;
        backStyle.up = skin.getDrawable("backButton");

        back = new TextButton("",backStyle);
        back.setPosition(Gdx.graphics.getWidth()/2 - 160.0f,Gdx.graphics.getHeight()/2 - 960.0f);

        back.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y){
                game.setScreen(new mainScreen(game));

                }


        });

        stage.addActor(back);


        // Music Slider volume control
        sliderBackgroundTexture = new Texture("bar.png");
        sliderKnobTexture = new Texture("knob.png");
        SliderStyle ss = new SliderStyle();
        ss.background = new TextureRegionDrawable(new TextureRegion(sliderBackgroundTexture));
        ss.knob = new TextureRegionDrawable(new TextureRegion(sliderKnobTexture));
        musicSlider = new Slider(0f, 1f, 0.1f, false, ss);
        musicSlider.setValue(game.getTheme().getVolume());
        musicSlider.setPosition(Gdx.graphics.getWidth()/2 - 100, Gdx.graphics.getHeight()/2 - 55f);
        musicSlider.setSize(440f, 308f);
        musicSlider.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                game.getTheme().setVolume(musicSlider.getValue());
                audio.putFloat("musicVol", musicSlider.getValue());
                audio.flush();
                return false;
            }
        });
        stage.addActor(musicSlider);


        soundSlider = new Slider(0f, 1f, 0.1f, false, ss);
        soundSlider.setValue(game.getSoundVol());
        soundSlider.setPosition(Gdx.graphics.getWidth()/2 - 100, Gdx.graphics.getHeight()/2 - 370.0f );
        soundSlider.setSize(440f, 308f);
        soundSlider.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                game.setSoundVol(soundSlider.getValue());
                audio.putFloat("soundVol", soundSlider.getValue());
                audio.flush();
                return false;
            }
        });
        stage.addActor(soundSlider);

        // Music Toggle button
        textButtonStyle2 = new TextButtonStyle();
        textButtonStyle2.up = skin.getDrawable("musicButton");
        textButtonStyle2.checked = skin.getDrawable("musicButtonPressed");
        textButtonStyle2.over = skin.getDrawable("musicButtonHover");
        textButtonStyle2.font = font;
        musicButton = new TextButton("", textButtonStyle2);
        musicButton.setPosition(Gdx.graphics.getWidth()/2 - 400 , Gdx.graphics.getHeight()/2 );
        musicButton.setSize(185.0f, 185.0f);
        musicButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.getTheme().setVolume(0f);
                musicSlider.setValue(0f);
                audio.putFloat("musicVol", musicSlider.getValue());
                audio.flush();
                if (musicButton.isChecked() == false) {
                    musicSlider.setValue(0.5f);
                    audio.putFloat("musicVol", musicSlider.getValue());
                    audio.flush();
                }

            };
        });

        stage.addActor(musicButton);


        // Sound Toggle button
        textButtonStyle3 = new TextButtonStyle();
        textButtonStyle3.up = skin.getDrawable("soundButton");
        textButtonStyle3.checked = skin.getDrawable("soundButtonPressed");
        textButtonStyle3.over = skin.getDrawable("soundButtonHover");
        textButtonStyle3.font = font;

        soundButton = new TextButton("", textButtonStyle3);
        soundButton.setPosition(Gdx.graphics.getWidth()/2 - 400 , Gdx.graphics.getHeight()/2 - 300.0f);
        soundButton.setSize(185.0f, 185.0f);

        soundButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                soundSlider.setValue(0f);
                audio.putFloat("soundVol", soundSlider.getValue());
                audio.flush();
                if (soundButton.isChecked() == false) {
                    soundSlider.setValue(0.5f);
                    audio.putFloat("soundVol", soundSlider.getValue());
                    audio.flush();
                }

            };
        });

        stage.addActor(soundButton);





    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.getBatch().setProjectionMatrix(stage.getCamera().combined);
        stage.getCamera().update();


        // So the Sound button is checked when returning to settings menu
        if (soundSlider.getValue() == 0) {
            soundButton.setChecked(true);
        } else
            soundButton.setChecked(false);

        // So the Music button is checked when returning to settings menu
        if (game.getTheme().getVolume() == 0) {
            musicButton.setChecked(true);
        } else
            musicButton.setChecked(false);

        stage.getBatch().begin();
        stage.getBatch().draw(settingsBackground, 0, 0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        stage.getBatch().end();
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

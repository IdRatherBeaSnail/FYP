package com.fyp.brain.game.screens;

import com.badlogic.gdx.Screen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BackwarsSpanScreen implements Screen {
    private ArrayList<Integer> display,answer;
    private int counter;


    public BackwarsSpanScreen (){
        display = new ArrayList<>();
        answer = new ArrayList<>();

        display.add(randomInt());

        counter = 1;
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {



        if (display.size() == answer.size()){
            Collections.reverse(display);
            if (display == answer){
                counter++;
                // player score increase
                // display new numbers
                for (int i=0; i < counter; i++){
                    display.add(i,randomInt());
                    answer.remove(i);
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
    private int randomInt(){
        Random rand = new Random();
        int randInt = Math.abs(rand.nextInt()) % 10;
        return randInt;
    }
}

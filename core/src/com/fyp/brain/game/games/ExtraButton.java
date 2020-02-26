package com.fyp.brain.game.games;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;


public class ExtraButton extends Button {
    private int id;
    private TextButton button;


    public ExtraButton(TextButton button , int id) {
        this.button = button;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public TextButton getButton() {
        return button;
    }
}

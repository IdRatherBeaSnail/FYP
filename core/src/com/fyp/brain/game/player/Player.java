package com.fyp.brain.game.player;

public class Player {

    private int score;
    private int life;

    public void Player(){
        score = 0;
        life = 0;
    }

    public void setScore(int add){
        score = score+add;
    }

    public int getScore(){
        return score;
    }

    public void loseLife(int lose) {
        life = life - lose;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life){
        this.life = life;

    }
}

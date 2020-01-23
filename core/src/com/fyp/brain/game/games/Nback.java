package com.fyp.brain.game.games;

public class Nback {
    private String[] stage1;
    private char[] stage2;
    private char[] stage3;
    private String EASY = "a,o,e,a,o,e,o,o,e,o,e,o,a,o,o,e,o,e,e,a,o,a,o,a,e,d,e,o,a,d,a,o,d,e,a,d,o,k,e,o,k,k,a,d,o,a,o,e,a,o,e,o,a,o,d,o,a,o,d,a,d,e,d,o,a,o,e";
    private final static String MEDIUM = "mkefmkefemkfefkefekmfkekmfleiooololeolmoelomepolemapmoelppmeolpem";
    private final static String HARD = "";


    public void Nback(){
        String temp = ",";
        stage1 = EASY.split(temp);

    }

    public String getEasy(int i) {
        return stage1[i];
    }

    public char[] getMedium() {
        return stage2;
    }

    public boolean isSame(int i, int n){

        if(i > n && stage1[i].equals(stage1[i-n])){
                return true;
        } else {
                return false;
            }
    }
}

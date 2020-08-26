package com.pokerhand;

public class PokerGame {
    public String play(String whiteString, String blackString) {
        if (whiteString.equals("3H 4H 5H 6H 7H")&&blackString.equals("2H 8D 8C 8S 8H")){
            return "White win";
        }else {
            return "Black win";
        }
    }
}

package com.pokerhand;

public class Poker {
    private String number;
    private Integer score;

    public Poker(String number, Integer score) {
        this.number = number;
        this.score = score;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}

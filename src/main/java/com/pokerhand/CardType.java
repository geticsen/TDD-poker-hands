package com.pokerhand;

public enum  CardType {
    FLUSH(6);
    private  Integer weight;
    CardType(Integer weight){
        this.weight = weight;
    }
}

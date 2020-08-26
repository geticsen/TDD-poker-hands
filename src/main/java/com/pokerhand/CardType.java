package com.pokerhand;

public enum  CardType {
    FLUSH(6),
    STRAIGHT(5);
    private final Integer weight;
    CardType(Integer weight){
        this.weight = weight;
    }
    public Integer getWeight() {
        return weight;
    }
}

package com.pokerhand;

public enum  CardType {
    FLUSH(6),
    STRAIGHT(5),
    FOUR_KIND(8),
    FULL_HOUSE(7),
    STRAIGHT_FLUSH(9),
    THREE_KIND(4),
    TWO_PAIRS(3),
    PAIRS(2),
    NORMAL(1);
    private final Integer weight;
    CardType(Integer weight){
        this.weight = weight;
    }
    public Integer getWeight() {
        return weight;
    }
}

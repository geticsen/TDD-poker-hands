package com.pokerhand;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class JudgeCardType {
    public CardType getCardsType(List<String> cards) {
        if(isFlush(cards)) return CardType.FLUSH;
        return null;
    }

    public Boolean isFlush(List<String> cards) {
        AtomicBoolean isFlush = new AtomicBoolean(true);
        String hua=cards.get(0).substring(1,2);
        cards.forEach(card->{
            if (!card.substring(1,2).equals(hua)){
                isFlush.set(false);
            }
        });
        return isFlush.get();
    }
}

package com.pokerhand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class JudgeCardType {
    public CardType getCardsType(List<String> cards) {
        if (isFlush(cards)) return CardType.FLUSH;
        if (isStraight(cards)) return CardType.STRAIGHT;
        Map<String, Integer> kind = getKind(cards);
        if (kind.size()==2) {
            for (Integer value : kind.values()) {
                if(value.equals(4)) return CardType.FOUR_KIND;
                if(value.equals(3)) return CardType.FULL_HOUSE;
            }
        }
        return null;
    }

    public Boolean isFlush(List<String> cards) {
        AtomicBoolean isFlush = new AtomicBoolean(true);
        String hua = cards.get(0).substring(1, 2);
        cards.forEach(card -> {
            if (!card.substring(1, 2).equals(hua)) {
                isFlush.set(false);
            }
        });
        return isFlush.get();
    }

    public Boolean isStraight(List<String> cards) {
        Map<String, Integer> pokers = new HashMap<>();
        pokers.put("2", 2);
        pokers.put("3", 3);
        pokers.put("4", 4);
        pokers.put("5", 5);
        pokers.put("6", 6);
        pokers.put("7", 7);
        pokers.put("8", 8);
        pokers.put("9", 9);
        pokers.put("10", 10);
        pokers.put("J", 11);
        pokers.put("Q", 12);
        pokers.put("K", 13);
        pokers.put("A", 14);
        for (int i = 1; i < 5; i++) {
            int result = pokers.get(cards.get(i - 1).substring(0, 1)) - pokers.get(cards.get(i).substring(0, 1));
            if (result != 1) {
                return false;
            }
        }
        return true;
    }

    public Map<String, Integer> getKind(List<String> cards) {
        Map<String, Integer> kindMap = new HashMap<>();
        for (String card : cards) {
            String key = card.substring(0, 1);
            Integer count = kindMap.get(key);
            kindMap.put(key, (count == null) ? 1 : count + 1);
        }
        return kindMap;
    }
}

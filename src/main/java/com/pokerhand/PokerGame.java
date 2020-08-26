package com.pokerhand;

import java.util.*;
import java.util.stream.Collectors;

public class PokerGame {
    private static final Map<String, Integer> pokers = new HashMap<>();
    private final List<String> whitePoker = new ArrayList<>();
    private final List<String> blackPoker = new ArrayList<>();

    static {
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
    }

    public String play(String whiteString, String blackString) {
        whitePoker.clear();
        blackPoker.clear();
        JudgeCardType judgeCardType = new JudgeCardType();
        Collections.addAll(whitePoker, whiteString.split(" "));
        Collections.addAll(blackPoker, blackString.split(" "));
        List<String> whiteSorted = whitePoker.stream().sorted(PokerGame::compare).collect(Collectors.toList());
        List<String> blackSorted = blackPoker.stream().sorted(PokerGame::compare).collect(Collectors.toList());

        CardType whiteType = judgeCardType.getCardsType(whiteSorted);
        CardType blackType = judgeCardType.getCardsType(blackSorted);

        Map<String, Integer> whitePokers = JudgeCardType.getKind(whiteSorted);
        Map<String, Integer> blackPokers = JudgeCardType.getKind(blackSorted);
        System.out.println(whiteSorted);
        if (whiteType.getWeight() > blackType.getWeight()) {
            return "White win";
        } else if (whiteType.getWeight() < blackType.getWeight()) {
            return "Black win";
        } else {
            return getSameTypeResult(whiteType,whitePokers,blackPokers,whiteSorted,blackSorted);
        }
    }

    public static int compare(String first, String second) {
        return pokers.get(second.substring(0, 1))-pokers.get(first.substring(0, 1)) ;
    }

    private String getSameTypeResult(CardType cardType, Map<String, Integer> whitePokers, Map<String, Integer> blackPokers,
                                     List<String> whiteSorted, List<String> blackSorted) {
        switch (cardType) {
            case NORMAL:
            case FLUSH:
            case STRAIGHT:
            case STRAIGHT_FLUSH:
                return getNormalResult(whiteSorted, blackSorted);
            case PAIRS:
                return getPairsResult(whitePokers,blackPokers,whiteSorted,blackSorted);
            case FOUR_KIND:
                return getFourKindResult(whitePokers, blackPokers);
            case TWO_PAIRS:
                ;
            case THREE_KIND:
            case FULL_HOUSE:
                return getFullHouseResult(whitePokers, blackPokers);
        }
        return null;
    }

    private String getNormalResult(List<String> whiteSorted, List<String> blackSorted) {
        for (int i = 0; i < whiteSorted.size(); i++) {
            if (pokers.get(whiteSorted.get(i).substring(0, 1)) > pokers.get(blackSorted.get(i).substring(0, 1))) {
                return "White win";
            } else if (pokers.get(whiteSorted.get(i).substring(0, 1)) < pokers.get(blackSorted.get(i).substring(0, 1))) {
                return "Black win";
            }
        }
        return "Tie.";
    }

    private String getFourKindResult(Map<String, Integer> whitePokers, Map<String, Integer> blackPokers) {
        String whiteKey1 = "";
        String blackKey1 = "";
        for (String key : whitePokers.keySet()) {
            if (whitePokers.get(key) == 4) whiteKey1 = key;
        }
        for (String key : blackPokers.keySet()) {
            if (blackPokers.get(key) == 4) blackKey1 = key;
        }

        if (pokers.get(whiteKey1.substring(0, 1)) > pokers.get(blackKey1.substring(0, 1))) {
            return "White win";
        } else {
            return "Black win";
        }
    }
    private String  getFullHouseResult(Map<String, Integer> whitePokers, Map<String, Integer> blackPokers){
        String whiteKey1 = "";
        String blackKey1 = "";
        for (String key : whitePokers.keySet()) {
            if (whitePokers.get(key) == 3) whiteKey1 = key;
        }
        for (String key : blackPokers.keySet()) {
            if (blackPokers.get(key) == 3) blackKey1 = key;
        }

        if (pokers.get(whiteKey1.substring(0, 1)) > pokers.get(blackKey1.substring(0, 1))) {
            return "White win";
        } else {
            return "Black win";
        }
    }

    private String getPairsResult(Map<String, Integer> whitePokers, Map<String, Integer> blackPokers,
                                  List<String> whiteSorted, List<String> blackSorted){
        String whiteKey1 = "";
        String blackKey1 = "";
        for (String key : whitePokers.keySet()) {
            if (whitePokers.get(key) == 2) whiteKey1 = key;
        }
        for (String key : blackPokers.keySet()) {
            if (blackPokers.get(key) == 2) blackKey1 = key;
        }

        if (pokers.get(whiteKey1.substring(0, 1)) > pokers.get(blackKey1.substring(0, 1))) {
            return "White win";
        } else if (pokers.get(whiteKey1.substring(0, 1)) < pokers.get(blackKey1.substring(0, 1))){
            return "Black win";
        }else{
            for (int i = 0; i < whiteSorted.size(); i++) {
                if (pokers.get(whiteSorted.get(i).substring(0, 1)) > pokers.get(blackSorted.get(i).substring(0, 1))) {
                    return "White win";
                } else if (pokers.get(whiteSorted.get(i).substring(0, 1)) < pokers.get(blackSorted.get(i).substring(0, 1))) {
                    return "Black win";
                }
            }
            return "Tie.";
        }
    }
}


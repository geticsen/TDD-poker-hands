package com.example;

import com.pokerhand.PokerGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PokerGameTest {
    private  static PokerGame pokerGame;
    @BeforeAll
    public static void setUp() throws Exception {
        pokerGame = new PokerGame();
    }

    @Test
    void should_return_white_win_when_play_poker_given_3H4H5H6H7H_and_2H8D8C8S8H() {
        //given
        String whiteString = "3H 4H 5H 6H 7H";
        String blackString = "2H 8D 8C 8S 8H";
        String result;
        String expect="White win";
        //when
        result = pokerGame.play(whiteString,blackString);
        //then
        Assertions.assertEquals(expect,result);
    }

}
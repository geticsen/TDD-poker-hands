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

    @Test
    void should_return_black_win_when_play_poker_given_3H4D5C6S8D_and_3H4D5C6S9D() {
        //given
        String whiteString = "3H 4D 5C 6S 8D";
        String blackString = "3H 4D 5C 6S 9D";
        String result;
        String expect="Black win";
        //when
        result = pokerGame.play(whiteString,blackString);
        //then
        Assertions.assertEquals(expect,result);
    }

    @Test
    void should_return_black_win_when_play_poker_given_5H5C5D5S2D_3H3C3D3S4C() {
        //given
        String blackString  = "3H 3C 3D 3S 4C";
        String whiteString  = "5H 5C 5D 5S 2D";
        String result;
        String expect="Black win";
        //when
        result = pokerGame.play(whiteString,blackString);
        //then
        Assertions.assertEquals(expect,result);
    }
}
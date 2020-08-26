package com.example;

import com.pokerhand.PokerGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PokerGameTest {
    private static PokerGame pokerGame;

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
        String expect = "White win";
        //when
        result = pokerGame.play(whiteString, blackString);
        //then
        Assertions.assertEquals(expect, result);
    }

    @Test
    void should_return_black_win_when_play_poker_given_3H4D5C6S8D_and_3H4D5C6S9D() {
        //given
        String whiteString = "3H 4D 5C 6S 8D";
        String blackString = "3H 4D 5C 6S 9D";
        String result;
        String expect = "Black win";
        //when
        result = pokerGame.play(whiteString, blackString);
        //then
        Assertions.assertEquals(expect, result);
    }

    @Test
    void should_return_black_win_when_play_poker_given_5H5C5D5S2D_3H3C3D3S4C() {
        //given
        String blackString = "3H 3C 3D 3S 4C";
        String whiteString = "5H 5C 5D 5S 2D";
        String result;
        String expect = "White win";
        //when
        result = pokerGame.play(whiteString, blackString);
        //then
        Assertions.assertEquals(expect, result);
    }

    @Test
    void should_return_white_win_when_play_poker_given_3H4H5H6H7H_and_5H6H7H8H9H() {
        //given
        String blackString = "3H 4H 5H 6H 7H";
        String whiteString = "5H 6H 7H 8H 9H";
        String result;
        String expect = "White win";
        //when
        result = pokerGame.play(whiteString, blackString);
        //then
        Assertions.assertEquals(expect, result);
    }

    @Test
    void should_return_black_win_when_play_poker_given_2H3C4D6S7C_5S6C2D8H9D() {
        //given
        String whiteString = "2H 3C 4D 6S 7C";
        String blackString = "5S 6C 2D 8H 9D";
        String result;
        String expect = "Black win";
        //when
        result = pokerGame.play(whiteString, blackString);
        //then
        Assertions.assertEquals(expect, result);
    }

    @Test
    void should_return_black_win_when_play_poker_given_3H4C5D6H7C_5C6C7D8S9H() {
        //given
        String whiteString = "3H 4C 5D 6H 7C";
        String blackString = "5C 6C 7D 8S 9H";
        String result;
        String expect = "Black win";
        //when
        result = pokerGame.play(whiteString, blackString);
        //then
        Assertions.assertEquals(expect, result);
    }
    @Test
    void should_return_black_win_when_play_poker_given_3C3H3D5C5D_4H4C4D6C6H() {
        //given
        String whiteString = "3C 3H 3D 5C 5D";
        String blackString = "4H 4C 4D 6C 6H";
        String result;
        String expect = "Black win";
        //when
        result = pokerGame.play(whiteString, blackString);
        //then
        Assertions.assertEquals(expect, result);
    }

    @Test
    void should_return_black_win_when_play_poker_given_ACAH9D8S7C_ADAS8C7H6D() {
        //given
        String whiteString = "AC AH 9D 8S 7C";
        String blackString = "AD AS 8C 7H 6D";
        String result;
        String expect = "White win";
        //when
        result = pokerGame.play(whiteString, blackString);
        //then
        Assertions.assertEquals(expect, result);
    }

    @Test
    void should_return_black_win_when_play_poker_given_ACAH9D8S7C_ADAS9C8H7D() {
        //given
        String whiteString = "AC AH 9D 8S 7C";
        String blackString = "AD AS 9C 8H 7D";
        String result;
        String expect = "Tie.";
        //when
        result = pokerGame.play(whiteString, blackString);
        //then
        Assertions.assertEquals(expect, result);
    }
    @Test
    void should_return_black_win_when_play_poker_given_3C3H3D5C6H_4C4H4D6S7C() {
        //given
        String whiteString = "3C 3H 5D 5C 6H";
        String blackString = "4C 4H 6D 6S 7C";
        String result;
        String expect = "Black win";
        //when
        result = pokerGame.play(whiteString, blackString);
        //then
        Assertions.assertEquals(expect, result);
    }


}
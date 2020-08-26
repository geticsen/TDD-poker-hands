package com.example;

import com.pokerhand.CardType;
import com.pokerhand.JudgeCardType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.smartcardio.Card;

public class JudgeCardTypeTest {
    @Test
    void should_return_flush_when_get_cards_type_given_3H5H7H8H9H() {
        //given
        String cards = "3H 5H 7H 8H 9H";
        CardType result ;
        CardType expect = CardType.FLUSH;
        //when
        result = JudgeCardType.getCardsType(cards);
        //then
        Assertions.assertEquals(expect,result);
    }
}

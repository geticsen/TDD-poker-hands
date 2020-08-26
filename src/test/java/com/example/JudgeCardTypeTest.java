package com.example;

import com.pokerhand.CardType;
import com.pokerhand.JudgeCardType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class JudgeCardTypeTest {
    @Test
    void should_return_flush_when_get_cards_type_given_3H5H7H8H9H() {
        //given
        String cards = "3H 5H 7H 8H 9H";
        CardType result ;
        CardType expect = CardType.FLUSH;
        List<String> cardlist=new ArrayList<>();
        JudgeCardType judgeCardType=new JudgeCardType();
        //when
        Collections.addAll(cardlist,cards.split(" "));
        result = judgeCardType.getCardsType(cardlist);
        //then
        assert result != null;
        Assertions.assertEquals(expect.getWeight(),result.getWeight());
    }
}

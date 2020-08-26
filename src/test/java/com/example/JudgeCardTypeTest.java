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
        Assertions.assertEquals(expect,result);
    }

    @Test
    void should_return_straight_when_get_cards_type_given_7H6C5D4S3H() {
        //given
        String cards = "7H 6C 5D 4S 3H";
        CardType result ;
        CardType expect = CardType.STRAIGHT;
        List<String> cardlist=new ArrayList<>();
        JudgeCardType judgeCardType=new JudgeCardType();
        //when
        Collections.addAll(cardlist,cards.split(" "));
        result = judgeCardType.getCardsType(cardlist);
        //then
        assert result != null;
        Assertions.assertEquals(expect.getWeight(),result.getWeight());
    }

    @Test
    void should_return_four_kind_when_get_cards_type_given_3H3D3S3C5D() {
        //given
        String cards = "3H 3D 3S 3C 5D";
        CardType result ;
        CardType expect = CardType.FOUR_KIND;
        List<String> cardlist=new ArrayList<>();
        JudgeCardType judgeCardType=new JudgeCardType();
        //when
        Collections.addAll(cardlist,cards.split(" "));
        result = judgeCardType.getCardsType(cardlist);
        //then
        assert result != null;
        Assertions.assertEquals(expect.getWeight(),result.getWeight());
    }

    @Test
    void should_return_full_house_when_get_cards_type_given_3H3D3S5C5D() {
        //given
        String cards = "3H 3D 3S 5C 5D";
        CardType result ;
        CardType expect = CardType.FULL_HOUSE;
        List<String> cardlist=new ArrayList<>();
        JudgeCardType judgeCardType=new JudgeCardType();
        //when
        Collections.addAll(cardlist,cards.split(" "));
        result = judgeCardType.getCardsType(cardlist);
        //then
        assert result != null;
        Assertions.assertEquals(expect.getWeight(),result.getWeight());
    }

    @Test
    void should_return_straight_flush_when_get_cards_type_given_7H6H5H4H3H() {
        //given
        String cards = "7H 6H 5H 4H 3H";
        CardType result ;
        CardType expect = CardType.STRAIGHT_FLUSH;
        List<String> cardlist=new ArrayList<>();
        JudgeCardType judgeCardType=new JudgeCardType();
        //when
        Collections.addAll(cardlist,cards.split(" "));
        result = judgeCardType.getCardsType(cardlist);
        //then
        assert result != null;
        Assertions.assertEquals(expect.getWeight(),result.getWeight());
    }
    @Test
    void should_return_three_kind_when_get_cards_type_given_6S6C6D8D9C() {
        //given
        String cards = "6S 6C 6D 8D 9C";
        CardType result ;
        CardType expect = CardType.THREE_KIND;
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

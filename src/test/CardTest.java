package test;

import static org.junit.jupiter.api.Assertions.*;
import static unochan.card.Color.*;

import org.junit.jupiter.api.Test;

import unochan.card.Card;
import unochan.card.WildCard;

public class CardTest {

    @Test
    void throwErrorIfDeclareWildCard2Times() {
        WildCard w = (WildCard) Card.newWildCard();
        w.color(BLUE);
        assertThrows(AssertionError.class, () -> w.color(GREEN));
    }

    @Test
    void testMatchSameColor() {
        Card c1 = Card.newSkipCard(RED);
        Card c2 = Card.newReverseCard(RED);
        assertTrue(isMatchedEachOther(c1, c2));
    }

    @Test
    void testMatchSameSymbol() {
        Card c1 = Card.newSkipCard(RED);
        Card c2 = Card.newSkipCard(BLUE);
        assertTrue(isMatchedEachOther(c1, c2));
    }

    @Test
    void testMatchWildCard() {
        WildCard wild = (WildCard) Card.newWildCard();
        Card card = Card.newNumberCard(RED, 1);
        assertTrue(isMatchedEachOther(wild, card));
    }

    @Test
    void testUnMatchUnsameColorAndUnsameSymbol() {
        Card c1 = Card.newSkipCard(RED);
        Card c2 = Card.newReverseCard(BLUE);
        assertTrue(isUnmatchedEachOther(c1, c2));
    }

    private static boolean isMatchedEachOther(Card card1, Card card2) {
        return card1.isMatched(card2) && card2.isMatched(card1);
    }

    private static boolean isUnmatchedEachOther(Card card1, Card card2) {
        return !card1.isMatched(card2) && !card2.isMatched(card1);
    }

}

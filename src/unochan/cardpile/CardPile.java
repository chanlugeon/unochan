package unochan.cardpile;

import java.util.Collections;
import java.util.Stack;

import unochan.card.Card;
import unochan.card.Color;

public class CardPile {

    public static Stack<Card> createDeck() {
        Stack<Card> pile = new Stack<>();
        addColoredCards(pile);
        addWildCards(pile);
        Collections.shuffle(pile);

        return pile;
    }

    private static void addColoredCards(Stack<Card> pile) {
        for (Color c : Color.values()) {
            Card zero = Card.newNumberCard(c, 0);
            pile.push(zero);

            for (int i = 0; i < 2; i++) {
                addNaturalNumberCards(pile, c);
                addActionCards(pile, c);
            }
        }
    }

    private static void addNaturalNumberCards(Stack<Card> pile, Color color) {
        for (int n = 1; n <= 9; n++) {
            Card natural = Card.newNumberCard(color, n);
            pile.push(natural);
        }
    }

    private static void addActionCards(Stack<Card> pile, Color color) {
        Card skip = Card.newSkipCard(color);
        Card reverse = Card.newReverseCard(color);
        Card draw = Card.newDraw2Card(color);
        pile.push(reverse);
        pile.push(skip);
        pile.push(draw);
    }

    private static void addWildCards(Stack<Card> pile) {
        for (int i = 0; i < 4; i++) {
            Card wild = Card.newWildCard();
            Card wildDraw = Card.newWildDraw4Card();
            pile.push(wild);
            pile.push(wildDraw);
        }
    }

}

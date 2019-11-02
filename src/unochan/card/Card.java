package unochan.card;

import java.util.Objects;

public interface Card {

    int score();
    Color color();

    default boolean isMatched(Card card) {
        return color() == card.color() || isUndeclaredColor() || card.isUndeclaredColor();
    }

    default boolean isUndeclaredColor() {
        return Objects.isNull(color());
    }

    static Card newNumberCard(Color color, int number) {
        if (!(number >= 0 && number <= 9))
            throw new IllegalArgumentException("number must be from 0 to 9.");

        return new NumberCard(color, number);
    }

    static Card newReverseCard(Color color) {
        return new ReverseCard(color);
    }

    static Card newSkipCard(Color color) {
        return new SkipCard(color);
    }

    static Card newDraw2Card(Color color) {
        return new Draw2Card(color);
    }

    static Card newWildCard() {
        return new WildCard();
    }

    static Card newWildDraw4Card() {
        return new WildDraw4Card();
    }

}

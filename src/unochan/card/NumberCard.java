package unochan.card;

public final class NumberCard extends ColoredCard {

    private final int number;

    NumberCard(Color color, int number) {
        super(color);
        this.number = number;
    }

    @Override
    public int score() {
        return number();
    }

    @Override
    public boolean isMatched(Card card) {
        return super.isMatched(card) || isMatchedNumber(card);
    }

    private boolean isMatchedNumber(Card card) {
        if (!(card instanceof NumberCard))
            return false;

        NumberCard nc = (NumberCard) card;
        return number == nc.number;
    }

    public int number() {
        return number;
    }

    @Override
    public String toString() {
        return String.format("%s_%d", super.toString(), number);
    }

}

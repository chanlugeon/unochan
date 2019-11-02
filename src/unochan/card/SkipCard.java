package unochan.card;

public final class SkipCard extends ActionCard {

    SkipCard(Color color) {
        super(color);
    }

    @Override
    public boolean isMatched(Card card) {
        return super.isMatched(card) || card instanceof SkipCard;
    }

}

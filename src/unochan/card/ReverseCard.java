package unochan.card;

public final class ReverseCard extends ActionCard {

    ReverseCard(Color color) {
        super(color);
    }

    @Override
    public boolean isMatched(Card card) {
        return super.isMatched(card) || card instanceof ReverseCard;
    }

}

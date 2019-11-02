package unochan.card;

public final class Draw2Card extends ActionCard implements AttackCard {

    Draw2Card(Color color) {
        super(color);
    }

    @Override
    public boolean isMatched(Card card) {
        return super.isMatched(card) || card instanceof Draw2Card;
    }

    @Override
    public int damage() {
        return 2;
    }

}

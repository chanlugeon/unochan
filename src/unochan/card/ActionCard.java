package unochan.card;

abstract class ActionCard extends ColoredCard {

    public ActionCard(Color color) {
        super(color);
    }

    @Override
    public final int score() {
        return 20;
    }

}

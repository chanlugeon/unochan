package unochan.card;

import java.util.Objects;

abstract class ColoredCard implements Card {

    private final Color color;

    public ColoredCard(Color color) {
        this.color = Objects.requireNonNull(color);
    }

    @Override
    public abstract int score();

    @Override
    public Color color() {
        return color;
    }

    @Override
    public String toString() {
        return String.format("%s_%s", getClass().getSimpleName(), color());
    }

}

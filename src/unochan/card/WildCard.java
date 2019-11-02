package unochan.card;

import java.util.Objects;

public class WildCard implements Card {

    private Color color = null;

    WildCard() {
    }

    public void color(Color color) {
        if (!isUndeclaredColor())
            throw new AssertionError();

        this.color = Objects.requireNonNull(color);
    }

    @Override
    public int score() {
        return 50;
    }

    @Override
    public Color color() {
        return color;
    }

    @Override
    public String toString() {
        if (isUndeclaredColor())
            return getClass().getSimpleName();

        return String.format("%s_%s", getClass().getSimpleName(), color());
    }

}

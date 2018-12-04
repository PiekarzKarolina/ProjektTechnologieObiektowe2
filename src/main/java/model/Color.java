package model;

public enum Color {
    BLACK, WHITE, BLUE, PINK, GREEN, NONE;

    @Override
    public String toString() {
        switch (this) {
            case GREEN:
                return "green";
            case BLUE:
                return "blue";
            case PINK:
                return "pink";
            case BLACK:
                return "black";
            case WHITE:
                return "white";
        }

        return null;
    }
}

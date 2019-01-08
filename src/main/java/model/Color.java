package model;

public enum Color {
    BLACK, WHITE, BLUE, RED, GREEN, NONE, SILVER, AQUA, PINK, GREENYELLOW;

    @Override
    public String toString() {
        return this != NONE ? super.toString().toLowerCase() : null;
    }
}

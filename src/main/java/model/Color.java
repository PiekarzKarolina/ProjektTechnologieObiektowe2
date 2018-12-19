package model;

public enum Color {
    BLACK, WHITE, BLUE, PINK, GREEN, NONE, SILVER;

    @Override
    public String toString() {
        return this != NONE ? super.toString().toLowerCase() : null;
    }
}

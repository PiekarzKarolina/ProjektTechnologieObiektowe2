package model;

public class Cell {
    private Color color;
    private final String islandNumber;

    //TODO

    public Cell(Color color) {
        this.color = color;
        this.islandNumber = "  ";
    }

    public Cell(String islandNumber) {
        this.color = Color.WHITE;
        this.islandNumber = islandNumber;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getIslandNumber() {
        return islandNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Cell)) return false;
        Cell comparedCell = (Cell) obj;

        return (this.color == comparedCell.color && this.islandNumber.equals(comparedCell.islandNumber));

    }
}

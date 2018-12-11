package model;

public class Cell {
    private Color color;
    private String islandNumber;

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
}

package model;

public class Cell {
    private Color color;
    private String islandNumber;

    //TODO

    public Cell(Color color) {
        this.color = color;
        this.islandNumber = "  ";
    }

    public Cell(Color color, String islandNumber) {
        this.color = color;
        this.islandNumber = islandNumber;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getIslandNumber() {
        return islandNumber;
    }
}

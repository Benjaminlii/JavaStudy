package play.fiveInARow;

class Cell {
    private int row;
    private int col;
    private int ID;
    private boolean isEmpty;
    private boolean isBlack;

    Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.ID = (this.row - 1) * 15 + this.col;
        this.isEmpty = true;
    }

    void setCell(boolean ifColorIsBlack) {
        this.isEmpty = false;
        this.isBlack = ifColorIsBlack;
    }

    boolean getColorIsBlack() {
        return this.isBlack;
    }

    boolean isEmpty() {
        return this.isEmpty;
    }

    int getID() {
        return this.ID;
    }

    int getRow() {
        return row;
    }

    int getCol() {
        return col;
    }

    static int getIDByRowAngCol(int row, int col) {
        return (row - 1) * 15 + col;
    }


}

package play.fiveInARow;

public class Cell {
    private int row;
    private int col;
    private int ID;
    private boolean isEmpty;
    private boolean isBlack;

    Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.ID = (this.col - 1) * 15 + this.row;
        this.isEmpty = true;
    }

    public void setCell(boolean ifColorIsBlack){
        this.isEmpty = false;
        this.isBlack = ifColorIsBlack;
    }

    public boolean getColorIsBlack(){
        return this.isBlack;
    }

    boolean isEmpty(){
        return this.isEmpty;
    }

    int getID(){
        return this.ID;
    }

    void exchange(boolean isBlack){
        this.isEmpty = false;
        this.isBlack = isBlack;
    }
}

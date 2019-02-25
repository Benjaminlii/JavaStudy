package play.fiveInARow;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.HashMap;

public class Board extends Application {
    private static boolean isblack = true;

    // 按钮的三种状态的背景
    private static Image gray = new Image(Board.class.getResourceAsStream("/Image/board.png"));
    private static Image white = new Image(Board.class.getResourceAsStream("/Image/WhitePiece.png"));
    private static Image black = new Image(Board.class.getResourceAsStream("/Image/BlackPiece.png"));

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Checker Board");
        GridPane grid = new GridPane();
        grid.setHgap(0);
        grid.setVgap(0);

        HashMap<Integer, PieceButton> pieces = new HashMap<>();

        for (int i = 1; i <= 15; i++) {
            for (int j = 1; j <= 15; j++) {
                PieceButton btn = new PieceButton();
                btn.setGraphic(new ImageView(gray));
                Cell one = new Cell(j, i);
                btn.setCell(one);
                btn.setStyle("-fx-padding: 0px;-fx-border-color: black;-fx-border-width: 1");


                pieces.put(btn.getCell().getID(), btn);
                grid.add(btn, i, j);
            }
        }
        for (int num = 1; num <= pieces.size(); num++) {
            PieceButton btn = pieces.get(num);
            btn.setOnAction((ActionEvent) -> {
                if (btn.getCell().isEmpty()) {
                    btn.getCell().setCell(Board.isblack);
                    if (Board.isblack) {
                        btn.setGraphic(new ImageView(black));
                    } else {
                        btn.setGraphic(new ImageView(white));
                    }
                    Board.exchangeColor(pieces);
                    if (Board.isEnough(btn.getCell().getRow(), btn.getCell().getCol(), pieces)) {
                        boolean isblack = btn.getCell().getColorIsBlack();
                        showWinner(pieces, isblack);
                    }
                }
            });
        }
        Scene bd = new Scene(grid, 780, 780);
        primaryStage.setScene(bd);

        primaryStage.show();
    }

    // 改变当前棋子的颜色
    private static void exchangeColor(HashMap<Integer, PieceButton> pieces) {
        Board.isblack = !Board.isblack;
        if (Board.isblack) {
            for (int i = 1; i <= pieces.size(); i++) {
                PieceButton btn = pieces.get(i);
                btn.setStyle("-fx-padding: 0px;-fx-border-color: black;-fx-border-width: 1");
            }
        } else {
            for (int i = 1; i <= pieces.size(); i++) {
                PieceButton btn = pieces.get(i);
                btn.setStyle("-fx-padding: 0px;-fx-border-color: white;-fx-border-width: 1");
            }
        }
    }

    private static boolean isEnough(int row, int col, HashMap<Integer, PieceButton> pieces) {
        boolean rtn = false;
        boolean isBlack = pieces.get(Cell.getIDByRowAngCol(row, col)).getCell().getColorIsBlack();

        // 行和列的临时坐标
        int numRow;
        int numCol;

        // 记录连成行的棋子个数
        int sum;

        code:
        {
            // 上下方向-------------------------------------------------------------------------------------------------
            sum = 0;
            numRow = row;
            numCol = col;
            while ((numRow >= 1 && numRow <= 15) && (numCol >= 0 && numCol <= 15)
                    && (!pieces.get(Cell.getIDByRowAngCol(numRow, numCol)).getCell().isEmpty())
                    && pieces.get(Cell.getIDByRowAngCol(numRow, numCol)).getCell().getColorIsBlack() == isBlack) {
                sum++;
                numRow++;
            }
            sum--;
            numRow = row;
            while ((numRow >= 1 && numRow <= 15) && (numCol >= 0 && numCol <= 15)
                    && (!pieces.get(Cell.getIDByRowAngCol(numRow, numCol)).getCell().isEmpty())
                    && pieces.get(Cell.getIDByRowAngCol(numRow, numCol)).getCell().getColorIsBlack() == isBlack) {
                sum++;
                numRow--;
            }
            if (sum >= 5) {
                rtn = true;
                break code;
            }

            // 左右方向-------------------------------------------------------------------------------------------------
            sum = 0;
            numRow = row;
            numCol = col;
            while ((numRow >= 1 && numRow <= 15) && (numCol >= 0 && numCol <= 15)
                    && (!pieces.get(Cell.getIDByRowAngCol(numRow, numCol)).getCell().isEmpty())
                    && pieces.get(Cell.getIDByRowAngCol(numRow, numCol)).getCell().getColorIsBlack() == isBlack) {
                sum++;
                numCol++;
            }
            sum--;
            numCol = col;
            while ((numRow >= 1 && numRow <= 15) && (numCol >= 0 && numCol <= 15)
                    && (!pieces.get(Cell.getIDByRowAngCol(numRow, numCol)).getCell().isEmpty())
                    && pieces.get(Cell.getIDByRowAngCol(numRow, numCol)).getCell().getColorIsBlack() == isBlack) {
                sum++;
                numCol--;
            }
            if (sum >= 5) {
                rtn = true;
                break code;
            }

            // 左上右下方向----------------------------------------------------------------------------------------------
            sum = 0;
            numRow = row;
            numCol = col;
            while ((numRow >= 1 && numRow <= 15) && (numCol >= 0 && numCol <= 15)
                    && (!pieces.get(Cell.getIDByRowAngCol(numRow, numCol)).getCell().isEmpty())
                    && pieces.get(Cell.getIDByRowAngCol(numRow, numCol)).getCell().getColorIsBlack() == isBlack) {
                sum++;
                numRow++;
                numCol++;
            }
            sum--;
            numRow = row;
            numCol = col;
            while ((numRow >= 1 && numRow <= 15) && (numCol >= 0 && numCol <= 15)
                    && (!pieces.get(Cell.getIDByRowAngCol(numRow, numCol)).getCell().isEmpty())
                    && pieces.get(Cell.getIDByRowAngCol(numRow, numCol)).getCell().getColorIsBlack() == isBlack) {
                sum++;
                numRow--;
                numCol--;
            }
            if (sum >= 5) {
                rtn = true;
                break code;
            }

            // 左下右上方向----------------------------------------------------------------------------------------------
            sum = 0;
            numRow = row;
            numCol = col;
            while ((numRow >= 1 && numRow <= 15) && (numCol >= 0 && numCol <= 15)
                    && (!pieces.get(Cell.getIDByRowAngCol(numRow, numCol)).getCell().isEmpty())
                    && pieces.get(Cell.getIDByRowAngCol(numRow, numCol)).getCell().getColorIsBlack() == isBlack) {
                sum++;
                numRow--;
                numCol++;
            }
            sum--;
            numRow = row;
            numCol = col;
            while ((numRow >= 1 && numRow <= 15) && (numCol >= 0 && numCol <= 15)
                    && (!pieces.get(Cell.getIDByRowAngCol(numRow, numCol)).getCell().isEmpty())
                    && pieces.get(Cell.getIDByRowAngCol(numRow, numCol)).getCell().getColorIsBlack() == isBlack) {
                sum++;
                numRow++;
                numCol--;
            }
            if (sum >= 5) {
                rtn = true;
            }
        }
        return rtn;
    }

    private static void showWinner(HashMap<Integer, PieceButton> pieces, boolean isblack) {
        Image color = isblack ? Board.black : Board.white;
        PieceButton btn;
        for(int i = 1; i <= pieces.size(); i++){
            btn = pieces.get(i);
            btn.setGraphic(new ImageView(color));
        }
    }

}

class PieceButton extends Button {
    private Cell one;

    public PieceButton(String str, ImageView img) {
        super(str, img);
    }

    PieceButton() {
        super();
    }

    void setCell(Cell one) {
        this.one = one;
    }

    Cell getCell() {
        return this.one;
    }

}

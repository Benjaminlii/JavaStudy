package play.fiveInARow;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
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
    private Image gray = new Image(getClass().getResourceAsStream("/board.png"));
    private Image white = new Image(getClass().getResourceAsStream("/WhitePiece.png"));
    private Image black = new Image(getClass().getResourceAsStream("/BlackPiece.png"));

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
                Cell one = new Cell(i, j);
                btn.setCell(one);
                btn.setStyle("-fx-padding: 0px;-fx-border-color: black;-fx-border-width: 1");

                btn.setOnAction((ActionEvent) -> {
                    if(btn.getCell().isEmpty()) {
                        btn.getCell().exchange(Board.isblack);
                        if (Board.isblack) {
                            btn.setGraphic(new ImageView(black));
                        } else {
                            btn.setGraphic(new ImageView(white));
                        }
                        Board.exchangeColor(pieces);
                    }
                });

                pieces.put(btn.getCell().getID(),btn);
                grid.add(btn, i, j);
            }
        }
        Scene bd = new Scene(grid, 780, 780);
        primaryStage.setScene(bd);

        primaryStage.show();
    }

    // 改变当前棋子的颜色
    private static void exchangeColor(HashMap<Integer, PieceButton> pieces) {
        Board.isblack = !Board.isblack;
        if(Board.isblack){
            for(int i = 1; i <= pieces.size(); i++){
                PieceButton btn = pieces.get(i);
                btn.setStyle("-fx-padding: 0px;-fx-border-color: black;-fx-border-width: 1");

            }
        }else{
            for(int i = 1; i <= pieces.size(); i++){
                PieceButton btn = pieces.get(i);
                btn.setStyle("-fx-padding: 0px;-fx-border-color: white;-fx-border-width: 1");
            }
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

    Cell getCell(){
        return this.one;
    }

}

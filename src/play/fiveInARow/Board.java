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
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Checker Board");
        GridPane grid = new GridPane();
        grid.setHgap(15);
        grid.setVgap(15);

        HashMap<Integer, PieceButton> pieces = new HashMap<>();

        // 按钮的三种状态的背景
        Image gray = new Image(getClass().getResourceAsStream("board.png"));
        Image white = new Image(getClass().getResourceAsStream("WhitePiece.png"));
        Image black = new Image(getClass().getResourceAsStream("BlackPiece.png"));

        for (int i = 1; i <= 15; i++) {
            for (int j = 1; j <= 15; j++) {
                PieceButton btn = new PieceButton("", new ImageView(gray));
                Cell one = new Cell(i, j);
                btn.setCell(one);
                grid.add(btn, i, j);
            }
        }
        Scene bd = new Scene(grid,1600, 1600);
        primaryStage.setScene(bd);

        primaryStage.show();
    }
}

class PieceButton extends Button {
    private Cell one;

    public PieceButton(String str, ImageView img) {
        super(str, img);
    }

    public void setCell(Cell one) {
        this.one = one;
    }

}

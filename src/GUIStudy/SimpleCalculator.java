package GUIStudy;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * author:Benjamin
 * data:2018.12.17
 */
public class SimpleCalculator extends Application {

    private static TextField number1_ = new TextField();
    private static TextField number2_ = new TextField();
    private static TextField result_ = new TextField();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Exercise");
        VBox one = this.getCol();

        Scene scene = new Scene(one, 920, 150);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private HBox getRow1() {
        HBox one = new HBox();
        one.setPadding(new Insets(10, 10, 10, 10));
        one.setSpacing(10);

        Label number1 = new Label("Number1: ");
        Label number2 = new Label("Number2: ");
        Label result = new Label("Result: ");

        one.getChildren().addAll(number1, number1_, number2, number2_, result, result_);

        return one;
    }

    private HBox getRow2() {
        HBox one = new HBox();
        one.setPadding(new Insets(10, 10, 10, 140));
        one.setSpacing(50);

        Button add = new Button("     Add     ");
        add.setOnAction(event -> result_.setText((Float.valueOf(number1_.getText())
                + Float.valueOf(number2_.getText())) + ""));

        Button subtract = new Button("     Subtract     ");
        subtract.setOnAction(event -> result_.setText((Float.valueOf(number1_.getText())
                - Float.valueOf(number2_.getText())) + ""));

        Button multiply = new Button("     Multiply     ");
        multiply.setOnAction(event -> result_.setText((Float.valueOf(number1_.getText())
                * Float.valueOf(number2_.getText())) + ""));

        Button divide = new Button("     Divide     ");
        divide.setOnAction(event -> {
                    if (number2_.getText().equals("0")) {
                        result_.setText("error");
                    } else {
                        result_.setText((Float.valueOf(number1_.getText())
                                / Float.valueOf(number2_.getText())) + "");
                    }
                }
        );

        one.getChildren().addAll(add, subtract, multiply, divide);

        return one;
    }

    private VBox getCol() {
        VBox one = new VBox();
        one.setPadding(new Insets(10, 10, 10, 10));
        one.setSpacing(10);
        one.getChildren().addAll(this.getRow1(), this.getRow2());
        return one;
    }

    public static void main(String[] args) {
        Application.launch();
    }
}

package JavaSE.GUIStudy;

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

public class InvestmentCalculator extends Application {
    private static TextField invAmount = new TextField();
    private static TextField years = new TextField();
    private static TextField annIntRate = new TextField();
    private static TextField futValue = new TextField();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Exercise");

        // 设置画布的上的排布以及尺寸
        Scene scene = new Scene(getRow(), 420, 250);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private HBox getRow() {
        HBox one = new HBox();

        // 组件之间间距
        one.setPadding(new Insets(10, 10, 10, 10));
        one.setSpacing(10);
        one.getChildren().addAll(this.getCol1(), this.getCol2());

        return one;
    }

    private VBox getCol1() {
        VBox one = new VBox();

        // 组件之间间距
        one.setPadding(new Insets(10, 10, 10, 10));
        one.setSpacing(20);
        one.getChildren().addAll(new Label("Investment Amount")
                , new Label("Years")
                , new Label("Annual Interest Rate")
                , new Label("Future Value"));

        return one;
    }

    private VBox getCol2() {
        VBox one = new VBox();

        // 组件之间间距
        one.setPadding(new Insets(10, 10, 10, 10));
        one.setSpacing(10);

        Button calculate = new Button("   Calculate   ");
        calculate.setOnAction(event -> {
            String value = "";
            try {
                double futureValue = Float.valueOf(invAmount.getText())
                        * Math.pow(1 + (Float.valueOf(annIntRate.getText()) / 100) / 12, Float.valueOf(years.getText()) * 12);
                value = futureValue + "";
            }catch (Exception e){
                value = "error";
            }finally {
                futValue.setText(value);
            }
        });

        one.getChildren().addAll(invAmount, years, annIntRate, futValue, calculate);

        return one;
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
